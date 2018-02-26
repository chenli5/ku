<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'techer.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="jquery/jquery.js"></script>
    <script>    	
   		$(function(){
   			$(".quedin").click(function(){
				var power = $("#work").val();
				if(power == 0){
				alert("请选择你的身份");
				return false;
   			}
			});
   		});
   	</script>
   	<style type="text/css">
   	.cur-select { 
   		position: absolute;left: 600px;top: 308px;
		display: block; 
		width: 150px; 
		height: 25px; 
		line-height: 25px; 
		background: #2482D9  no-repeat 125px center; 
		text-indent: 10px; 
		}
	.quedin{
		position: absolute;left: 750px;top: 308px;
		width: 70px; height: 25px
	}	 
   	</style>

  </head>
  
  <body>
		<div id="bigBox">
			<div
			style="width:100%;height:308px;background-image: url(images/student_top.jpg);position: absolute;left: 0px;top:0px;"></div>
			<form action="service/techerServlet" method="get" style="padding-left:700px;padding-top:300px">
			<div>
				<select name="work" id="work" class="cur-select">
					<option value="0">请选择事务</option>
					<option value="1">管理学生</option>
					<option value="2">管理考试试题</option>
					<option value="3">管理练习试题</option>
				</select>
				<button type="submit" name="quedin" class="quedin">确定</button>
			</div>	
			</form>
		</div>
  </body>
</html>
