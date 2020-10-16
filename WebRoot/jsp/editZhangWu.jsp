<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>编辑账务</title>
  </head>
  
  <body>
    <h1>管家婆家庭记账系统-编辑账务</h1>
    <%-- include 指令插入selectAll.jsp 显示所有的账务信息 --%>
  	<%@ include file="selectAll.jsp"%><br>
  	<%= "---------------------------------------------------------------------------------------------" %>
    <%--  下面是编辑操作 --%>
    <form action="/GJP/servlets/EditServlet" method="post">
    <div style="font-size: 30px"><h2>编辑操作：</h2></div>	
    <table>
    		<tr>
 			<td style=" font-size: 20px;">请输入修改的账务信息：</td>
	 		</tr>
		 	<tr>
		 		<td>请输入要修改账务的账务ID：<input name="zwid" type="text"></td>
		 		<td>新分类名称(用途)：<input name="newflname" type="text"></td>
		 		<td>新金额：<input name="newmoney" type="text" ></td>
		 	</tr>
		 	<tr>
	 			<td>新账户名称(XX银行/现金/微信/支付宝)：<input name="newzhanghu" type="text"></td>
		 		<td>新创建时间(格式：xxxx-xx-xx)：<input name="newcreatetime" type="text"></td>
		 		<td>新说明：<input name="newdescription" type="text"></td>
	 		</tr>
		 	<tr>
	 			<td><input type="submit" value="更改" style=" margin-left:30px; width: 200px;"></td>
	 		</tr>
    	</table>
    </form>
  </body>
</html>
