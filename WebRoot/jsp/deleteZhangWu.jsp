<%@page import="domain.ZhangWu"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>删除账务</title>
  </head>
  
  <body>
    <h1>管家婆家庭记账系统-删除账务</h1>
  	<%-- include 指令插入selectAll.jsp 显示所有的账务信息 --%>
  	<%@ include file="selectAll.jsp"%><br>
  	<%= "---------------------------------------------------------------------------------------------" %>
    <%--  下面是删除操作 --%>
    <form action="/GJP/servlets/DeleteServlet" method="post">
    <div style="font-size: 30px"><h2>添加操作：</h2></div>	
    <table>
    		<tr>
 			<td style=" font-size: 20px;">请输入要删除的账务的账务ID：</td>
 			<td><input type="text" name="zwid"></td>
	 		</tr>
		 	<tr>
	 			<td><input type="submit" value="删除" style=" margin-left:30px; width: 200px;"></td>
	 		</tr>
    	</table>
    </form>
  </body>
</html>
