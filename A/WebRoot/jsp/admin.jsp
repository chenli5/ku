<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>管理员</title>
<style type="text/css">

.showdiv {
	MARGIN-RIGHT: auto;
	MARGIN-LEFT: auto;
	background-color: #02BAFA;
	border: 1px solid #f90;
	text-align: center;
	line-height: 40px;
	font-size: 12px;
	font-weight: bold;
	z-index: 99;
	width: 300px;
	height: 300px;
	;
}

.btnsty {
	height: 21px;
	line-height: 21px;
	padding: 0 11px;
	background: #02bafa;
	border: 1px #26bbdb solid;
	border-radius: 3px;
	/*color: #fff;*/
	display: inline-block;
	text-decoration: none;
	font-size: 12px;
	outline: none;
}

.ch_cls {
	background: #e4e4e4;
}
body {TEXT-ALIGN: center;}
</style>
<script type="text/javascript" src="jquery/jquery.js">
	
</script>


</head>

<body>
	<div id="bdiv" style="margin: auto 0px;">
		<div id="adiv">
			<a href="service/iframe" target="iframe" class="btnsty ch_cls"
				id="btn1" onclick="changeSelBtn(1)" style="margin-right: 100px">学生用户管理</a>
			<a href="service/teacherIframe" target="iframe" class="btnsty"
				id="btn2" onclick="changeSelBtn(2)">教师用户管理</a>
			
		</div>
		<script type="text/javascript">
			function changeSelBtn(index) {
				if (index == 1) {
					$("#btn1").addClass('ch_cls');
					$("#btn2").removeClass('ch_cls');
				} else if (index == 2) {
					$("#btn1").removeClass('ch_cls');
					$("#btn2").addClass('ch_cls');
				}
			}
		</script>
		<iframe name="iframe" id="iframe" class="showdiv"
			style="border:1px dashed #000;"> </iframe>
	</div>

</body>
</html>
