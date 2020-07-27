$(function() {
	$('.table-sort').DataTable({
				order : [ [ 1, 'asc' ] ],
				ajax : {
					url : "../../findAllusers",
					type : 'POST',
					dataSrc : ""
				},
				columns : [  {
                    data : "openId"
                }, {
					data : "openId"
				}, {
					data : "status",
					defaultContent : ""
				}, {
					data : "name",
					defaultContent : ""
				}, {
					data : "sex",
					defaultContent : ""
				}, {
					data : "phoneNum",
					defaultContent : ""
				}, {
					data : "birth",
					defaultContent : ""
				}, {
					data : "deposit",
					defaultContent : ""
				}, {
					data : "balance",
					defaultContent : ""
				} ],
				columnDefs : [{
					targets : [ 0 ],
					orderable : false,
					render : function(id, type, row, meta) {
						return '<input id="input-' + id
								+ '" type="checkbox" name="ids" value=' + id
								+ '><label for="input-' + id + '"></label>';
					}
				
                }]
			});
});