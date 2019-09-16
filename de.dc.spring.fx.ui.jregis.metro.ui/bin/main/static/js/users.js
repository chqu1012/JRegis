function loadDocument(){
	console.log('On load users.');
	initForm();
	initDatatables();
}

function initDatatables(){
	console.log('run_datatables');
	 var table = $('#userTable').DataTable({
		select: true,
		dom: "Blfrtip",
		"sAjaxSource": "/data/users",
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
		    { "mData": "shortname" },
	      	{ "mData": "name" },
	      	{ "mData": "forename" },
	      	{ "mData": "email" }
		],
		responsive: true,
		order: [[ 1, "desc" ]]
	 });
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
	$('#birthdayPicker').datetimepicker({
		defaultDate: new Date(),
		format: 'DD-MM-YYYY',
		showTodayButton: true,
		useCurrent: true,
		sideBySide: true
	});
}