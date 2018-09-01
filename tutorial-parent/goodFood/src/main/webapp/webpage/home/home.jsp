<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示页</title>
<style type="text/css">
table, tr, td {
	border: solid 1px black;
}
</style>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script type="text/javascript">
 var ctx = "<%=request.getContextPath()%>
	";
</script>
</head>
<body>
	<div id="app">{{ message }}</div>
</body>
<script>
	var app = new Vue({
		el : '#app',
		data : {
			message : 'Hello Vue!'
		}
	})
</script>
</html>