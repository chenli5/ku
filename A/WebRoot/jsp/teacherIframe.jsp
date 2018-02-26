<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'iframe.jsp' starting page</title>
<script type="text/javascript">

</script>

</head>

<body>
	<form action="" method="get">
		<c:forEach var="list" items="${list}" varStatus="s">
			<tr>
				<td colspan="3">${list.tid}</td>

				<td colspan="3">${list.tname}
					
				</td>
				
				<td><input type="text" name="power" id="power" value="" style="display:none">
				</td>
				<td><input type="text" name="id" class="id1" value="${list.tid}"
					style="display:none">
				</td>
				<td>
					<a href="iframe/adminTeacherIm?id=${list.tid}">修改用户</a>
					<input type="text" name="id" class="id2" value="${list.tid}"
						style="display:none">
				</td>
				<td>
				<button type="submit" onclick="extvalue1()" name="del" class="del">删除用户</button>
									
					<input type="text" name="id" class="id1" value="${list.tid}"
						style="display:none">
					
					</td>
				<br>
			</tr>
		</c:forEach>

		<div style="width:100%;text-align:center">
			<c:forEach var="i" begin="1" end="${totalPages}">
				<a
					href="service/teacherIframe?currentPage=${i}&power=3&userPW=22&userId=11">${i}</a>
			</c:forEach>
		</div>
	</form>
	
</body>
<script type="text/javascript" src="jquery/jquery.js"></script>
<script type="text/javascript">
$(function(){
		$(".del").click(function(){
		var id = $(this).next().val();;
		var power = $("#power").val();
		$.ajax({
		type : "get",
		data : {
			"id" : id ,"power":power
		},
		url : "service/adminTeacherSerlet",
		success : function() {
			window.location.reload();
			alter(1);
		}
	});
	});
});

</script>
</html>
