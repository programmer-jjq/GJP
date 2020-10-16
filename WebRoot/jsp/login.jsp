<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管家婆家庭记账系统</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<style>
			<%-- body主体部分--%>
			body{
			  background:url(../images/bg.png) repeat-x;
			  min-height: 600px;
			  position: relative;
			}
			<%-- 全文字体格式--%>
			*{font-family:"微软雅黑"; margin:0; padding:0; border:0; font-size:14px;color:white;}
			  html,body{height:100%; width:100%;;
			}
			
			<%-- 表单输入框 --%>
			.name,.pwd{            
			  width: 310px;
			  height: 44px;
			  line-height: 44px;
			  padding-left: 15px;
			  outline: none;
			  border-radius: 20px;
			  background-color: #0A3C78;
			  border: 1px solid #329BE0;
			}
			.name:hover,.pwd:hover,.name:focus,.pwd:focus{
				  background-color: #052b64;
			}
			<%-- 登录按钮 --%>
			#login{
			  background: #3fb9ff;
			  font-size: 18px;
			  width: 329px;
			  height: 44px;
			  outline: none;
			  color: white;
			  background: -webkit-linear-gradient(#3fb9ff, #099be7, #229de3);
			  background: -o-linear-gradient(#3fb9ff, #099be7, #229de3);
			  background: -moz-linear-gradient(#3fb9ff, #099be7, #229de3);
			  background: linear-gradient(#3fb9ff, #099be7, #229de3);
			  border-radius: 20px;
			}
			#login:hover{
			  background: -webkit-linear-gradient(#229de3, #099be7,#3fb9ff);
			  background: -o-linear-gradient(#229de3, #099be7,#3fb9ff);
			  background: -moz-linear-gradient(#229de3, #099be7,#3fb9ff);
			  background: linear-gradient(#229de3, #099be7,#3fb9ff);
			}
			
			#head{
			    height: 50px;
				padding-top: 25px;
				margin-left: 14px;
			}
			#middle{
			  margin-top: 100px;
			  /* height:600px; */
			}
			<%-- 页面头部 --%>
			#head{
			    height: 50px;
				padding-top: 25px;
				margin-left: 14px;
			}
		    #middle li {
			 list-style-type:none;
			 margin-top: 15px;
			}
			 
		 	#children li {
		  		list-style-type: none;
		 		height: 42px;
		  		line-height: 42px;
		  		border-bottom: 1px double rgb(5, 33, 113);
			}	
			 
			#children li a{
			   color: rgba(255, 255, 255);
			}
			#cloud{
			  background: url(../images/cloud.png) repeat;
			  width: 100%;
			  height: 356px;
			  position: absolute;
			  bottom: 0px;
			  -webkit-animation: cloud 60s linear infinite alternate;
			  -moz-animation: clouds 60s linear infinite alternate;
			  z-index: -10;
			}
			@-webkit-keyframes cloud { 
			    0%{background-position:top left} 
			    100%{background-position:top right} 
			}
			@-moz-keyframes clouds { 
			    0%{background-position:top left} 
			    100%{background-position:top right} 
			}
			#sky{
			  background: url(../images/sky.png) repeat;
			  width: 100%;
			  heigth: 462px;
			  z-index: -20;
			  height: 462px;
			  position: absolute;
			  top: 0px;
			}
			
			#tlogin:focus{outline:none;}
		</style>
	</head>
	
  	<body>
  	<div id="sky"></div>
	<div id="head"></div>
	<div id="middle">
     <form action="/GJP/servlets/LoginServlet" method="post">
     		<ul style="text-align: center;">
			<li style="font-size: 48px">管家婆家庭记账系统</li>
	     	<li><input type="text" class="name" name="username" placeholder="请输入用户名"></li>
			<li><input type="password" class="pwd" name="password"  placeholder="请输入密码"></li>
			<li><input type="submit" value="登录" id="login"></li>
     		</ul>
     </form>
    </div>
	<div id="cloud"></div>
	    <script src="../js/jquery-2.1.1.js" type="text/javascript" charset="UTF-8"></script>
 		<script language='javascript' type='text/javascript'>
		  $(document).ready(function() {
		            init();
		 });
		 function init(){
		 $(".name,.pwd,#valid").keyup(function(event){
                if( event.keyCode==13 )
                {
                    $('#login').click();
                }
    	  });
    	  }
		  $("form").submit( function(event){
			     var account = $(".name").val(); 
			     var pwd = $(".pwd").val();
			        if(!account ||!pwd) {
			          $("#err").css("display","inline-block");
			          $("#err").text("请输入用户名或密码");
			           return false;
			        }
         })
 		</script>
  	 </body>
</html>
