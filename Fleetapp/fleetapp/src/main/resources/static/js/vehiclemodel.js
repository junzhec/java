/**
 * 
 */

$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehiclemodel, status){
			$('#idEdit').val(vehiclemodel.id);
			$('#descriptionEdit').val(vehiclemodel.description);
			$('#detailsEdit').val(vehiclemodel.details);
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