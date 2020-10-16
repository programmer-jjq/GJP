<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<html>
  	<head>
  		<title>提示信息页面</title>
		<meta charset="UTF-8">
	</head>
	
	<body>
	<div style="font-size: 30px"><h2>提示信息：</h2></div>
	<%  
		//从session中获取id的值
		int id = (int)session.getAttribute("id");
		if(id==1){
			//添加账务的提示信息
			//从session中获取update的值
			int update = (int)session.getAttribute("update");
			if(update>0){
	%>
		<table border="2px">
	   		<tr>
	   			<td style="width: 100px;height: 100px;"><%="添加成功!"%></td>
	   		</tr>
	   	</table>	
			<%}else{%>
			<table border="2px">
	   		<tr>
	   			<td style="width: 100px;height: 100px;"><%="添加失败!"%></td>
	   		</tr>
	   		</table>
			<%}
		}
		if(id==2){
			//删除账务的提示信息  
			//从session中获取delupdate的值
			int delupdate = (int)session.getAttribute("delupdate");
			if(delupdate>0){
			%>
			<table border="2px">
	   			<tr>
	   				<td style="width: 100px;height: 100px;"><%="删除成功!"%></td>
	   			</tr>
	   		</table>
			<%}else{%>
			<table border="2px">
	   			<tr>
	   				<td style="width: 100px;height: 100px;"><%="您要删除的账务不存在!"%></td>
	   			</tr>
	   		</table>
			<%}
		}
		if(id==3){
			//编辑账务的提示信息
			//从session中获取editupdate的值
			int editupdate = (int)session.getAttribute("editupdate");
			if(editupdate>0){
			%>
			<table border="2px">
	   			<tr>
	   				<td style="width: 100px;height: 100px;"><%="编辑成功!"%></td>
	   			</tr>
	   		</table>
			<%}else{%>
			<table border="2px">
	   			<tr>
	   				<td style="width: 100px;height: 100px;"><%="编辑失败！"%></td>
	   			</tr>
	   		</table>
			<%}
		}%><br>
		<a href="/GJP/jsp/main.jsp">返回主界面</a>
	</body>
</html>
