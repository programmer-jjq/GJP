<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   	<title>管家婆记账软件主界面</title>
   	<meta charset="UTF-8">
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
	 <div style="font-size: 30px"><h2>管家婆记账软件主界面</h2></div>
	 <div style="margin:20px 0;"></div>
	 <table border="10px">
	 	<tr>
	 		<td style=" font-size: 20px">请选择功能：</td>
	 	</tr>
	 	<tr>
	 		<td><a href="/GJP/jsp/selectZhangWu.jsp" >查询账务</a></td>
	 	</tr>
	 	<tr>
	 		<td><a href="/GJP/jsp/addZhangWu.jsp" >添加账务</a></td>
	 	</tr>
	 	<tr>
	 		<td><a href="/GJP/jsp/editZhangWu.jsp" >编辑账务</a></td>
	 	</tr>
	 	<tr>
	 		<td><a href="/GJP/jsp/deleteZhangWu.jsp" >删除账务</a></td>
	 	</tr>
	 	<tr>
	 		<td><a href="/GJP/jsp/login.jsp">注销登录</a></td>
	 	</tr>
	 </table>
	</div>
</body>
</html>
