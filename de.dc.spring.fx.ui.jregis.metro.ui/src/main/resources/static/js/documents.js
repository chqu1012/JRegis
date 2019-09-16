function loadDocument() {
	initForm();
	initDatatables();
}

function initDatatables(){
	console.log('run_datatables');
	 var table = $('#documentTable').DataTable({
		select: true,
		dom: "Blfrtip",
		"sAjaxSource": "/data/documents",
		"sAjaxDataProp": "",
		order: [[ 1, "asc" ]],
		columns: [
			{
               "className":      'details-control',
               "orderable":      false,
               "data":           null,
               "defaultContent": ''
            },
		    { "mData": "id"},
	      	{ "mData": "name" },
			{ "mData": "description" },
	      	{ "mData": "category", render: function(data, type, document) {
				return document.category.name;
			}},
			{ "mData": "files", render: function(data, type, document) {
				return document.files.length;
			}}
		],
		columnDefs: [
		    { "width": "5%", "targets": 0 },
		    { "width": "7%", "targets": 1 },
		    { "width": "15%", "targets": 4 },
		    { "width": "5%", "targets": 5 }
		],
		responsive: true,
		order: [[ 1, "desc" ]]
	 });
	 
	// Add event listener for opening and closing details
	    $('#documentTable tbody').on('click', 'td.details-control', function () {
	        var tr = $(this).closest('tr');
	        var row = table.row( tr );
	 
	        if ( row.child.isShown() ) {
	            // This row is already open - close it
	            row.child.hide();
	            tr.removeClass('shown');
	        }
	        else {
	            // Open this row
	        	$.get('/data/documents/attachments/'+row.data().id, function(data, status) {
	        		row.child(data).show();
	        	});
	            //row.child( format(row.data()) ).show();
	            tr.addClass('shown');
	        }
	    } );
}

function initForm(){
	var createDatePicker = $('#createdDatePicker');
	createDatePicker.datetimepicker({
		defaultDate: new Date(),
		format: 'DD-MM-YYYY HH:mm',
        showTodayButton: true,
        useCurrent: true,
        sideBySide: true
    });
	$('#updatedOnPicker').datetimepicker({
		defaultDate: new Date(),
		format: 'DD-MM-YYYY HH:mm',
		showTodayButton: true,
		useCurrent: true,
		sideBySide: true
	});
}

/* Formatting function for row details - modify as you need */
function format ( d ) {
	$.get('/data/documents/attachments/'+d.id, function(data, status) {
		return data;
	});
	return '';
}