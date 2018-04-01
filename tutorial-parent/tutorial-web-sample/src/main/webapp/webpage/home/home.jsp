<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示页</title>
<style type="text/css">
table,tr,td {
	border: solid 1px black;
}
</style>
<script type="text/javascript">
 var ctx = "<%=request.getContextPath()%>";
</script>
</head>
<body>
<table id="result">
<thead>
<tr><td>id</td><td>name</td><td>content</td><td>path</td><td>create date</td></tr>
</thead>
</table>
</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/plugins/jquery.min-1.3.2.js"></script>
<script>
$(function(){

	$.ajax({
		url: ctx + '/image/list.do',
		type: "post",
		success: function(data){
			data = eval("("+data+")");
			for(var d in data){
				d = data[d];
				var tr = "<tr>";
				tr+="<td>"+d.id + "</td>";
				tr+="<td>"+d.name + "</td>";
				tr+="<td>"+d.path + "</td>";
				tr+="<td>"+d.content + "</td>";
				tr+="<td>"+d.createDate + "</td>";
				tr += "</tr>";
				
				$("#result").append(tr);
			}
		}
	});
});
</script>
</html>