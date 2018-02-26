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

</head>
<style>
	.btnsty {
	height: 21px;
	line-height: 21px;
	padding: 0 11px;
	background: #ffffff;
	border: 1px #26bbdb solid;
	border-radius: 3px;
	/*color: #fff;*/
	display: inline-block;
	text-decoration: none;
	font-size: 12px;
	outline: none;
}
</style>
<body>
	<form action="" method="get">
		<c:forEach var="list" items="${list}" varStatus="s">
			<tr>
				<td colspan="3">${list.sid}</td>
				<td colspan="3">${list.sname}</td>
				<td><a href="iframe/adminStudentIm?id=${list.sid}" class="btnsty">修改用户</a>
				<input type="text" name="id" class="id2" value="${list.sid}"
						style="display:none"></td>
				<td><a id="del"class="btnsty">删除用户</a>
					<input type="text" name="id" class="id1" value="${list.sid}"
						style="display:none">
				</td>
				<br>
			</tr>
		</c:forEach>
		<div style="width:100%;text-align:center">
			<c:forEach var="i" begin="1" end="${totalPages}">
				<a href="service/iframe?currentPage=${i}&power=3&userPW=22&userId=11">${i}</a>
			</c:forEach>
		</div>
	</form>
	
</body>
<script type="text/javascript" src="jquery/jquery.js"></script>
<script type="text/javascript">
$(function(){
		$("#del").click(function(){
		var id = $(this).next().val();;
		$.ajax({
		type : "get",
		data : {
			"id" : id 
		},
		url : "service/adminStudent",
		success : function() {
			window.location.reload();
		}
	});
	});
});

</script>
</html>
