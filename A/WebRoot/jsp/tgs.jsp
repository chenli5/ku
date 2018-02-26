<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'TGS.jsp' starting page</title>

<style type="text/css">
  input{background:transparent;border:1px solid #2185CF}
</style>
  </head>
  <script type="text/javascript">
  	function refresh(){
    window.location.reload();
    }
  </script>
  <body>
    <form action="service/tManageStudentServlet">
    	<c:forEach var="list" items="${list}" varStatus="s">
    	<tr>
	    	<td>姓名:${list.sname}</td><br>
	    	<td>学号:<input type="text" name="stuID${s.index}" value="${list.sid }"readonly="readonly" style="border: none;width: 30px"></td>
	    	<td></td>
	    	<td>成绩:<input type="text" style="width:45px" name="cj${s.index}"value="${list.sscore}"></td><br>
    	</tr>
    	</c:forEach>
    	<br>
    </form>
    <button type="submit" onclick="refresh()">确定</button>
  </body>
</html>
