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
<script src="<%=request.getContextPath()%>/plugins/vue.js"></script>
<script type="text/javascript">
 var ctx = "<%=request.getContextPath()%>";
</script>
</head>
<body>
	<div id="app">{{ message }}</div>
	<div id="app-2">
		<span v-bind:title="message"> 鼠标悬停几秒钟查看此处动态绑定的提示信息！ </span>
	</div>
</body>
<script>
	var app = new Vue({
		el : '#app',
		data : {
			message : 'Hello Vue!'
		}
	})
	var app2 = new Vue({
		el : '#app-2',
		data : {
			message : '页面加载于 ' + new Date().toLocaleString()
		}
	})
</script>
</html>