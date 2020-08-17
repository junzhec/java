/**
 * 
 */

$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicletype, status){
			$('#idEdit').val(vehicletype.id);
			$('#descriptionEdit').val(vehicletype.description);
			$('#detailsEdit').val(vehicletype.details);
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