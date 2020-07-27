$(function() {
	$('.table-sort').DataTable({
				order : [ [ 1, 'asc' ] ],
				ajax : {
					url : "../../findAllrepair",
					type : 'POST',
					dataSrc : ""
				},
				columns : [  {
                    data : "bid"
                }, {
					data : "bid"
				}, {
					data : "status",
					defaultContent : ""
				}, {
					data : "latitude",
					defaultContent : ""
				}, {
					data : "longitude",
					defaultContent : ""
				}, {
					data : "types",
					defaultContent : ""
				} ,{
					data : "phoneNum",
					defaultContent : ""
				}],
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
function bike_add(title, url, w, h) {
	layer_show(title, url, w, h);
}

function bike_dels() {
	var cks = $(".table-sort input[name='ids']:checked");
	layer.confirm('确认要删除吗？', function(index) {
		var param = [];
		cks.each(function() {
			param.push($(this).val());
		});
		$.ajax({
			url : "/bike/" + param,
			type : "delete",
			success: function(msg){
				location.reload();
				layer.close(index);
			}
		});
		
	});
}

function bike_del(id) {
	layer.confirm('确认要删除吗1111？', function(index) {
		$.ajax({
			url : "/bike/" + id,
			type : "delete",
			success: function(msg){
				location.reload();
				layer.close(index);
			}
		});
		
	});
}

function bike_edit(id) {
	
	layer.open({
		type: 2,
		area: [800+'px', 510 +'px'],
		fix: false, //不固定
		maxmin: true,
		shade:0.4,
		title: "编辑教师",
		content: "/bike_edit",
		success: function(layero, index){
			var body = layer.getChildFrame('body', index);
			$.ajax({
				url : "/bike/" + id,
				type : "get",
				dataType : "json",
				success : function(data) {
					body.find('#id').val(data.id);
					body.find('#bikename').val(data.name);
					body.find("input[type='radio'][value="+ data.gender +"]").attr("checked", "checked")
					body.find("#bikeType option[value="+ data.type +"]").attr('selected', 'selected');
					body.find('#desc').val(data.description);
				}
			});
		}
	});
	
}
