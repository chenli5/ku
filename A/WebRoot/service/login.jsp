<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
    <title>教师（学生）登录页面</title>
    <style type="text/css">
        html, body {
            height: 100%;
            overflow: auto;
        }	
    	*{margin: 0px;padding: 0px}
    	
    </style>
    <script type="text/javascript" src="jquery/jquery.js"></script>
    <script>    	
   		$(function(){
   			$(".dl").click(function(){
				var power = $("#power").val();
				if(power == 0){
				alert("请选择你的身份");
				return false;
   				}
   				
			});
   		});
   		$(function(){
   			$("#cl").click(function(){
   				$("#userId").val("").focus();
   				$("#password").val("");
   				
   			});
   		});
   	</script>
    
  </head>
  
  <body >
		<div id="box" style="background-image:url(images/backTOP.jpg); height:100%;">
			<h1 style="position: absolute;left:600px;top:50px;color:#99ffcc">在线考试系统</h1>
			<form action="service/loginService" method="get" style="padding-left:700px;padding-top:300px">
				用户名：  <input type="text" name="userId" id="userId"></br>
				密码: &nbsp &nbsp<input type="password" name="userPW" id="userPW"></br>
				<select name="power" id="power">
					<option value="0">请选择身份</option>
					<option value="1">学生</option>
					<option value="2">教师</option>
					<option value="3">管理员</option>
				</select></br>
				<button type="submit" value="登录" name="dl" class="dl">登录</button>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
        		<input type="button"  name="cl" id="cl" value="取消">
			</form>
		</div>
  </body>
</html>