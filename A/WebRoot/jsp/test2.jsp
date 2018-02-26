<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>开始考试</title>
<link href="student/images/css2.css" rel="stylesheet" type="text/css" />
<style type="text/css">
a{
text-decoration:none;
}
body {TEXT-ALIGN: center;}
</style>
<script type="text/javascript">
	var ksTime; //定义考试时间以分钟计算
	ksTime = 120;//设置时间 这里设置为0.1代表是6秒,测试用
	if (readCookie("ss") == "") {
		setCookie("ss", new Date(), ksTime / 60);
	}
	function sT() {
		var tti = new Date();
		var lt = parseInt((tti - new Date(readCookie("ss"))) / 1000)
		if ((ksTime * 60 - lt) < 0) {
			setCookie("ss", new Date(), 0);
			alert("考试时间到!\n即将提交试卷!");
			document.forms[0].submit();
		} else {
			lm = Math.floor(lt / 60);
			ls = lt % 60;
			allY = ksTime * 60 - lt;
			ym = Math.floor(allY / 60);
			ys = allY % 60;
			document.getElementById("tTime").innerHTML = "考试已经开始了" + lm + "分"
					+ ls + "秒" + ",剩余" + ym + "分" + ys + "秒";
			var ttt = setTimeout("sT()", 1000);
		}
	}
	function readCookie(name) {
		var cookieValue = "";
		var search = name + "=";
		if (document.cookie.length > 0) {
			offset = document.cookie.indexOf(search);
			if (offset != -1) {
				offset += search.length;
				end = document.cookie.indexOf(";", offset);
				if (end == -1)
					end = document.cookie.length;
				cookieValue = document.cookie.substring(offset, end)
			}
		}
		return cookieValue;
	}
	function setCookie(name, value, hours) {
		var expire = "";
		if (hours != null) {
			expire = new Date((new Date()).getTime() + hours * 3600000);
			expire = "; expires=" + expire.toGMTString();
		}
		document.cookie = name + "=" + value + expire;
	}
</script>
</head>

<body onload="sT()">
<div>
	<table width="100%" height="100%" border="0" cellpadding="0"
		cellspacing="0" class="centerbg">
		<tr>
			<td width="149" height="485">&nbsp;</td>
			<td width="741" valign="top" class="rightbian">
				<form action="../service/testServlet" method="get">
					<table width="98%" border="0" align="center" cellpadding="0"
						cellspacing="10">
						<tr>
							<td><div align="center" >考试时间：120 分钟</div>
							</td>
							<td><div align="center">考生：${student.sname}</div>
								<input type="" name="stuID" value="${student.sid}">
							</td>
							<td><div align="center" >总分 ：100 分</div>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td><div id="tTime"></div>
							</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td colspan="3" bgcolor="#999999" class="STYLE4">选择题(每小题4分，共25个)</td>
						</tr>
						<!--题目开始-->

						<c:forEach var="list1" items="${list1}" begin="1" end="25" varStatus="s">
							<tr>
								<input type="hidden" name="subjectID" value="${s.index}" />
								<td colspan="3"><strong>第<span class="STYLE5">${s.index}</span>题&nbsp;${list1.setitle}</strong></td>
							</tr>
							<tr>
								<td colspan="3"><strong>A．</strong>${list1.sea}</td>
							</tr>
							<tr>
								<td colspan="3"><strong>B．</strong>${list1.seb}</td>
							</tr>
							<tr>
								<td colspan="3"><strong>C．</strong>${list1.sec}</td>
							</tr>
							<tr>
								<td colspan="3"><strong>D．</strong>${list1.sed}</td>
							</tr>
							<tr>
								<td height="32" colspan="3" bgcolor="#CCCCCC">选择答案： 
								<input type="radio" name="subjectAnswer${list1.setitle}" value="A" /> A 
								<input type="radio" name="subjectAnswer${list1.setitle}" value="B" /> B 
								<input type="radio" name="subjectAnswer${list1.setitle}" value="C" /> C 
								<input type="radio" name="subjectAnswer${list1.setitle}" value="D" /> D</td>
							</tr>
						</c:forEach>
						<!--题目结束-->
						<tr>
							<td colspan="3"><div align="center">
									<input type="submit" value=" 提交答卷 " name="Submit" />
									
								</div>
							</td>
						</tr>
					</table>
				</form></td>
			<td width="113">&nbsp;</td>
		</tr>
	</table>
</div>	
	<!--  <div style="width:100%;text-align:center">
	<c:forEach var = "i" begin="1" end="${totalPages}">
		<a href="../service/testServlet?currentPage=${i}">${i}</a>
	</c:forEach></div>-->
</body>
</html>