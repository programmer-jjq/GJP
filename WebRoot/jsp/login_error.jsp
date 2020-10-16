<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录异常</title>
  </head>
  
  <body>
  		<div style="font-size: 30px"><h2>登录错误信息：</h2></div>
	   	<%
	   	//从session中取出msg
	   	String msg = (String)session.getAttribute("msg");
	   	%>
	   	<table border="2px">
	   		<tr>
	   			<td style="width: 220px;height: 100px;"><%=msg %></td>
	   		</tr>
	   	</table>
	   	<div style="width: 100px"><a href="/GJP/jsp/login.jsp">返回</a></div>
  </body>
</html>
