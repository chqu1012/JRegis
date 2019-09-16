function loadDetailsDocument() {
	console.log('-- Load Jira Ticket Details Page --');	
	
	$('#commentTextArea').hide('slow');
	
	$('#commentButton').click(function (event) {
		console.log('-- Open Comment Text Area --');
		$('#commentTextArea').fadeIn();
	});
	$('#commentSaveButton').click(function (event) {
		console.log('-- Save Comment Text Area --');
		$('#commentTextArea').hide('slow');
		var description = $('#editor-one').cleanHtml();
		var ticketId = $('#ticketId').val();
		$.ajax({
		      type: 'post',
		      url: '/data/create/jscomment',
		      data: { 
		        'description': description, 
		        'id': ticketId
		      },
		      success: function (data) {
		        $( data).prependTo( "#commentBoxContainer" );
		      },
		      error: function () {
		        alert("error");
		      }
		   });
	});
	$('#commentCancelButton').click(function (event) {
		console.log('-- Cancel Comment Text Area --');
		$('#commentTextArea').fadeOut();
	});
	$('#closeButton').click(function(event) {
		console.log('-- Close Button clicked --');
		$('#detailsContainer').hide('slow');
		$('#tableContainer').fadeIn('slow');
	})
	
	init_wysiwyg();
}
			
/* WYSIWYG EDITOR */
function init_wysiwyg() {
	
	if( typeof ($.fn.wysiwyg) === 'undefined'){ return; }
	console.log('init_wysiwyg');	
		
    function init_ToolbarBootstrapBindings() {
      var fonts = ['Serif', 'Sans', 'Arial', 'Arial Black', 'Courier',
          'Courier New', 'Comic Sans MS', 'Helvetica', 'Impact', 'Lucida Grande', 'Lucida Sans', 'Tahoma', 'Times',
          'Times New Roman', 'Verdana'
        ],
        fontTarget = $('[title=Font]').siblings('.dropdown-menu');
      $.each(fonts, function(idx, fontName) {
        fontTarget.append($('<li><a data-edit="fontName ' + fontName + '" style="font-family:\'' + fontName + '\'">' + fontName + '</a></li>'));
      });
      $('a[title]').tooltip({
        container: 'body'
      });
      $('.dropdown-menu input').click(function() {
          return false;
        })
        .change(function() {
          $(this).parent('.dropdown-menu').siblings('.dropdown-toggle').dropdown('toggle');
        })
        .keydown('esc', function() {
          this.value = '';
          $(this).change();
        });

      $('[data-role=magic-overlay]').each(function() {
        var overlay = $(this),
          target = $(overlay.data('target'));
        overlay.css('opacity', 0).css('position', 'absolute').offset(target.offset()).width(target.outerWidth()).height(target.outerHeight());
      });

      if ("onwebkitspeechchange" in document.createElement("input")) {
        var editorOffset = $('#editor').offset();

        $('.voiceBtn').css('position', 'absolute').offset({
          top: editorOffset.top,
          left: editorOffset.left + $('#editor').innerWidth() - 35
        });
      } else {
        $('.voiceBtn').hide();
      }
    }

    function showErrorAlert(reason, detail) {
      var msg = '';
      if (reason === 'unsupported-file-type') {
        msg = "Unsupported format " + detail;
      } else {
        console.log("error uploading file", reason, detail);
      }
      $('<div class="alert"> <button type="button" class="close" data-dismiss="alert">&times;</button>' +
        '<strong>File upload error</strong> ' + msg + ' </div>').prependTo('#alerts');
    }

    $('.editor-wrapper').each(function(){
		var id = $(this).attr('id');	//editor-one
		
		$(this).wysiwyg({
			toolbarSelector: '[data-target="#' + id + '"]',
			fileUploadError: showErrorAlert
		});	
	});

	
    window.prettyPrint;
    prettyPrint();

};