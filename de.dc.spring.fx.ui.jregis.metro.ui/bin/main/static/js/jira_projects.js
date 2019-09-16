function loadDocument(){
	console.log('On load jira projects.');
	initForm();
	initDatatables();
}

function initDatatables(){
	console.log('run_datatables');
	 var table = $('#projectTable').DataTable({
		select: true,
		dom: "Blfrtip",
		"sAjaxSource": "/data/projects",
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
	      	{ "mData": "shortName" },
	      	{ "mData": "createdOn", render: function(data, type, project) {
				return project.createdOn+'';
			}},
	      	{ "mData": "updatedOn", render: function(data, type, project) {
				return project.updatedOn+'';
			}}
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
}