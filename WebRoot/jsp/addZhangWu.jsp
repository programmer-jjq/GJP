<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加账务</title>
  </head>

  <body>
    <h1>管家婆家庭记账系统-添加账务</h1>
    <%-- include 指令插入selectAll.jsp 显示所有的账务信息 --%>
  	<%@ include file="selectAll.jsp"%><br>
  	<%= "---------------------------------------------------------------------------------------------------------" %>
    <%--  下面是添加操作 --%>
    <form action="/GJP/servlets/AddServlet" method="post">
    <div style="font-size: 30px"><h2>添加操作：</h2></div>	
    	<table>
    		<tr>
 			<td style=" font-size: 20px;">请输入添加的账务信息：</td>
	 		</tr>
		 	<tr>
		 		<td>账务ID：<input name="zwid" type="text"></td>
		 		<td>分类名称(用途)：<input name="flname" type="text"></td>
		 		<td>金额：<input name="money" type="text"></td>
		 	</tr>
		 	<tr>
	 			<td>账户名称(XX银行/现金/微信/支付宝)：<input name="zhanghu" type="text"></td>
		 		<td>创建时间(格式：xxxx-xx-xx)：<input name="createtime" type="text"></td>
		 		<td>说明：<input name="description" type="text"></td>
	 		</tr>
		 	<tr>
	 			<td><input type="submit" value="添加" style=" margin-left:30px; width: 200px;"></td>
	 		</tr>
    	</table>
    </form>
  </body>
</html>
