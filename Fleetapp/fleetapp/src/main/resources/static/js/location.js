/**
 * 
 */

$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(location, status){
			$('#idEdit').val(location.id);
			$('#descriptionEdit').val(location.description);
			$('#cityEdit').val(location.city);
			$('#addressEdit').val(location.address);
			$('#ddlStateEdit').val(location.stateid);
			$('#ddlCountryEdit').val(location.countryid);
			$('#detailsEdit').val(location.details);
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