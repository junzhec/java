/**
 * 
 */

$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehiclestatus, status){
			$('#idEdit').val(vehiclestatus.id);
			$('#descriptionEdit').val(vehiclestatus.description);
			$('#detailsEdit').val(vehiclestatus.details);
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