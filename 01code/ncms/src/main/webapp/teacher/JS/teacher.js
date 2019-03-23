//回显下拉框
		$(function() {
			$.ajax({
				type : 'get',
				url : HOST_URL + 'list',
				dataType : 'json',
				success : function(data) {
					var specialtys = '<option selected="selected"  value=""></option>';//所属专业下拉框
					var schoolarea = '<option selected="selected"  value=""></option>';//所属院校下拉框
					var edu ='<option selected="selected"  value=""></option>';//文化水平下拉框
					$.each(data, function(i, obj) {
						$.each(obj, function(i, d) {
							if (d.dicttype == 'specialty') {
								specialtys += '<option value="'+d.dictid+'">'
										+ d.dicname + '</option>'
								$('#specialty').html(specialtys);
							} else if (d.dicttype == 'school_area') {
								schoolarea += '<option value="'+d.dictid+'">'
										+ d.dicname + '</option>'
								$('#schoolarea').html(schoolarea);
							}
						})
					})
				}
			});
			$.ajax({
				type : 'get',
				url : HOST_URL + 'clazzs',
				dataType : 'json',
				success : function(data) {
					var clazz = '<option selected="selected"  value=""></option>';//所属专业下拉框

					$.each(data, function(i, a) {
						clazz += '<option value="'+a.classid+'">' + a.code
								+ '</option>'
						$('#code').html(clazz);

					});
				}
			});
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		layui.use([ 'laydate', 'element', 'laypage', 'layer' ], function() {
			$ = layui.jquery;//jquery
			laydate = layui.laydate;//日期插件
			//lement = layui.element();//面包导航
			laypage = layui.laypage;//分页
			layer = layui.layer;//弹出层
		});

		/*添加*/
		function admin_add(title, url, w, h) {
			x_admin_show(title, url, w, h);
		}

		//编辑
		function admin_edit(title, url, id, w, h) {
			x_admin_show(title, url, w, h);
		}