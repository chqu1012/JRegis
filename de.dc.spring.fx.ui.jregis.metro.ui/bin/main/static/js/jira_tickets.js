function loadDocument(){
	console.log('On load jira tickets document.');
	initForm();
	initDatatables();
	initDatatablesListener();
	initModalDialog();
	initToolbarButtons();
}

function initToolbarButtons() {
	$('.open-add-dialog').click(function () {
		$.post('openForm', function(data, status) {
			console.log('-- run_ticket_form --');
			$('#addDialog').html(data);
			$('#addDialog').modal('show');
			$("#statusSelect").prop("selectedIndex", 1);
			$("#typeSelect").prop("selectedIndex", 1);
			$("#projectSelect").prop("selectedIndex", 1);
			initForm();
    	});
    });
}

function initModalDialog(){
	$(".modal-wide").on("show.bs.modal", function() {
		 var width = $(window).width() - 10;
	  $(this).find(".modal-body").css("max-width", width);
	  var height = $(window).height() - 200;
	  $(this).find(".modal-body").css("max-height", height);
	});
}

function initDatatablesListener() {
	console.log('-- run_datatables_listeners --');
	$('#ticketTable tbody').on( 'dblclick', 'tr', function () {
		  var rowData = $('#ticketTable').DataTable().row( this ).data();
		  var id = rowData.id;
		  
		  $.ajax({
			  method: 'POST',
			  url: 'openTicket',
			  data: {'id': id},
			  success: function(data) {
				  $('#tableContainer').hide('slow');
				  $('#detailsContainer').html(data);
				  $('#detailsContainer').fadeIn('slow');
			  }
		 });
	} );
}

function initDatatables(){
	console.log('-- run_datatables --');
	 var table = $('#ticketTable').DataTable({
		dom: "Blfrtip",
		select: true,
		"sAjaxSource": "/data/tickets",
		"sAjaxDataProp": "",
		order: [[ 1, "asc" ]],
		columns: [
			{
               "className":      'details-control',
               "orderable":      false,
               "data":           null,
               "defaultContent": ''
            },
		    { "mData": "id", render: function(data, type, ticket) {
				return ticket.id;
			}},
			{ "mData": "id", render: function(data, type, ticket) {
				return ticket.project.shortName+'-'+ticket.id;
			}},
	      	{ "mData": "name" },
			{ "mData": "description" },
	      	{ "mData": "type", render: function(data, type, ticket) {
				return ticket.type.name;
			}},
			{ "mData": "status", render: function(data, type, ticket) {
				return ticket.status.name;
			}},
			{ "mData": "labels" },
			{ "mData": "resolution" }
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
}


function initForm(){
	console.log('-- run_forms --');
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