<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'xgTeacher.jsp' starting page</title>
	<style type="text/css">
		body {TEXT-ALIGN: center;}
	</style>
  </head>
   <body>
   <div>
    ID:&nbsp &nbsp<input name="sid" id="sid"  type="text" value="${student.sid}"><br>
   	姓名：<input name="sname" id="sname" type="text" value="${student.sname}"><br>
   	成绩：<input name="score" id="score" type="text" value="${student.sscore}"><br>
    <button class="xbtn" id="xbtn" style="margin-left: 60px">确认修改</button><br>
    </div>
    <span id="sp"></span>
  </body>
<script type="text/javascript" src="jquery/jquery.js"></script>
<script type="text/javascript">
$(function(){
		$(".xbtn").click(function(){
		var sname = $("#sname").val();
		var sid = $("#sid").val();
		var score = $("#score").val();
		$.ajax({
		type : "get",
		data : {
			"sname" : sname ,"sid" : sid , "score" : score
		},
		url : "iframe/adminSuser",
		success : function() {
			window.location.reload();
			alert("修改成功");
			}	
	});
	});
});

</script> 
</html>
