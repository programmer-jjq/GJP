<%@page import="domain.ZhangWu"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>根据ID查询账务</title>
    <meta charset="UTF-8">
    <style type="text/css">
		 		body {
		 			margin: 20px 100px;
		 			background-image: url("../images/regist_bg.jpg");
		 		}	
		 		td {
		 			height:80px;
		 			background-color: white;
		 			margin-left: 50px;
		 			padding: 25px;
		 		}
		 </style>
  </head>
  <body>
	   <%
	    //获取session中的zhangwu对象
	  	ZhangWu zhangwu = (ZhangWu)session.getAttribute("zhangwu");
	  	//如果返回是空值，证明没有这条账务，发出提示，
	  	//如果返回不是空值，输出账务信息
	  	if(zhangwu!=null){
	   %>
	   <div style="font-size: 30px"><h2>账务ID为: <%=zhangwu.getZwid()%> 的账务信息如下：</h2></div>
	    <table>
			<thead>
				<tr>
					<th>账务ID</th>
					<th >分类名称</th>
					<th >金额</th>
					<th >账户名称</th>
					<th >创建时间</th>
					<th >说明</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=zhangwu.getZwid()%></td>
					<td style="width: 1000px;"><%=zhangwu.getFlname()%></td>
					<td><%=zhangwu.getMoney()%></td>
					<td style="width: 1000px;"><%=zhangwu.getZhangHu() %></td>
					<td style="width: 1000px;"><%=zhangwu.getCreatetime()%></td>
					<td style="width: 1000px;"><%=zhangwu.getDescription()%></td>
				</tr>
			</tbody>
		</table><br>
		<%}else{ %>
		<div style="font-size: 30px"><h2>查询错误信息：</h2></div>
		<table border="2px">
	   		<tr>
	   			<td style="width: 300px;height: 100px;"><%="您查询的账务不存在，请返回重试！" %></td>
	   		</tr>
	   	</table>
		<%} %>
		<table>
			<tr>
				<td><a href="/GJP/jsp/selectZhangWu.jsp">返回查询界面</a></td>
				<td><a href="/GJP/jsp/main.jsp">返回主界面</a></td>
				<td><a href="/GJP/jsp/login.jsp">注销登录</a></td>
			</tr>
		</table>
  </body>
</html>
