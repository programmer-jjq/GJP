<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	  <title>查询账务</title>
	  <style type="text/css">
	 		body {
	 			margin: 20px 100px;
	 			background-image: url("../images/regist_bg.jpg");
	 		}
	 		td {
	 			width: 200px;
	 			height:80px;
	 			background-color: white;
	 			margin-left: 50px;
	 		}
	 		td>a {
	 			margin-left: 50px;
	 		}
	   	</style>
  </head>
  
  <body>
    <div style="font-size: 30px"><h2>管家婆家庭记账系统-查询账务</h2></div>
    <form action="/GJP/servlets/SelectServlet" method="post">
		<table border="10px">
	 		<tr>
	 			<td style=" font-size: 20px">选择账务查询方式：</td>
	 		</tr>
		 	<tr>
		 		<td><input name="choice" type="radio" checked="checked" value="all">所有账务查询</td>
		 	</tr>
		 	<tr>
		 		<td><input name="choice" type="radio" value="id">账务ID查询</td>
		 		<td>请输入查询的账务ID：<input name="id" type="text"></td>
		 	</tr>
		 	<tr>
		 		<td><input name="choice" type="radio" value="date">账务日期查询</td>
		 		<td>请输入开始日期<br>(格式：xxxx-xx-xx)：<input name="startdate" type="text"></td>
		 		<td>请输入结束日期<br>((格式：xxxx-xx-xx)：<input name="enddate" type="text"></td>
		 	</tr>
		 	<tr>
		 		<td><input type="submit" value="查询" style=" margin-left:40px; width: 100px;"></td>
		 		<td><a href="/GJP/jsp/main.jsp">返回主界面</a></td>
		 		<td><a href="/GJP/jsp/login.jsp">注销登录</a></td>
		 	</tr>
		</table>
	</form>
  </body>
</html>
