/**
 * 
 */

$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehiclemake, status){
			$('#idEdit').val(vehiclemake.id);
			$('#descriptionEdit').val(vehiclemake.description);
			$('#detailsEdit').val(vehiclemake.details);
		});			
		$('#editModal').modal();		
	});

	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();		
	});	
});