<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addStudent.jsp' starting page</title>


  </head>
  
  <body>
    <div>
    	学号：<input type="text" id="stuID"><br>
    	姓名：<input type="text" id="stuName"><br>
    	密码：<input type="text" id="stuPW"><br>
    	班级：<input type="text" id="stuClass"><br>
    	<button class="btn" id="btn">确认添加</button>
    </div>
  </body>
  <script type="text/javascript" src="jquery/jquery.js"></script>
<script type="text/javascript">

	$(function() {
		$(".xbtn").click(function() {
			var sname = $("#stuName").val();
			var sid = $("#stuID").val();
			var pw = $("#stuPW").val();
			var sClass = $("#stuClass").val();
			$.ajax({
				type : "get",
				data : {
					"sname" : sname,
					"sid" : sid,
					"pw" : pw,
					"sClass" :sClass 
				},
				url : "iframe/adminSuser",
				success : function() {
					window.location.reload();
					alert("添加成功");
				}
			});
		});
	});
</script> 
</html>
