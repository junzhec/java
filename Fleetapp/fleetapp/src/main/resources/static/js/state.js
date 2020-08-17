$('document').ready(function() {

	$('.table .btn-primary').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(state, status){
			$('#idEdit').val(state.id);
			$('#ddlCountryEdit').val(state.countryid);
			$('#codeEdit').val(state.code);
			$('#capitalEdit').val(state.capital);
			$('#nameEdit').val(state.name);
			$('#detailsEdit').val(state.details);
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