<%@page import="domain.ZhangWu"%>
<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 	<head>
	  	<title>根据账务日期查询账务</title>
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
		 		.gong2 a{
		 			width: 2000px;
		 		}
		 </style>
	</head>
  <body>
	    <%
	  	//把SelectServlet传过来的账务list从session中获取
	  	ArrayList<ZhangWu> list =(ArrayList<ZhangWu>)session.getAttribute("zwlist");
	  	%>
	  	<div style="font-size: 30px"><h2>账务信息如下：</h2></div>
    	<h3>范围:<%= session.getAttribute("startdate")%>---><%=session.getAttribute("enddate")%></h3>
    <table style="width:700px;height:250px">
		<thead>
				<tr>
					<th>账务ID</th>
					<th>分类名称</th>
					<th>金额</th>
					<th>账户名称</th>
					<th>创建时间</th>
					<th>说明</th>
				</tr>
		</thead>
		<tbody>
		<%
            for(int j=0;j<list.size();j++){ %>
			<tr>
				<td><%=list.get(j).getZwid()%></td>
				<td style="width: 1000px;"><%=list.get(j).getFlname()%></td>
				<td><%=list.get(j).getMoney()%></td>
				<td style="width: 1000px;"><%=list.get(j).getZhangHu() %></td>
				<td style="width: 1000px;"><%=list.get(j).getCreatetime()%></td>
				<td style="width: 1000px;"><%=list.get(j).getDescription()%></td>
			</tr>
		<% 
			};
		%>
		</tbody>
	</table>
	<table>
			<tr>
				<td><a href="/GJP/jsp/selectZhangWu.jsp">返回查询界面</a></td>
				<td><a href="/GJP/jsp/main.jsp">返回主界面</a></td>
				<td><a href="/GJP/jsp/login.jsp">注销登录</a></td>
			</tr>
	</table>
  </body>
</html>
