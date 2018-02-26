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

  </head>
  
  <body>
    ID：<input name="tid" id="tid"  type="text" value="${teacher.tid}"><br>
   	姓名：<input name="tname" id="tname" type="text" value="${teacher.tname}"><br>
    <button class="xbtn" id="xbtn">确认修改</button><br>
    <span id="sp"></span>
  </body>
<script type="text/javascript" src="jquery/jquery.js"></script>
<script type="text/javascript">
$(function(){
		$(".xbtn").click(function(){
		var tname = $("#tname").val();
		var tid = $("#tid").val();
		$.ajax({
		type : "get",
		data : {
			"tname" : tname ,"tid" : tid
		},
		url : "service/adminTuser",
		success : function() {
			window.location.reload();
			alert("修改成功");
			}	
	});
	});
});

</script>  
</html>
