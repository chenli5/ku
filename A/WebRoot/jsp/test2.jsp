<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>��ʼ����</title>
<link href="student/images/css2.css" rel="stylesheet" type="text/css" />
<style type="text/css">
a{
text-decoration:none;
}
body {TEXT-ALIGN: center;}
</style>
<script type="text/javascript">
	var ksTime; //���忼��ʱ���Է��Ӽ���
	ksTime = 120;//����ʱ�� ��������Ϊ0.1������6��,������
	if (readCookie("ss") == "") {
		setCookie("ss", new Date(), ksTime / 60);
	}
	function sT() {
		var tti = new Date();
		var lt = parseInt((tti - new Date(readCookie("ss"))) / 1000)
		if ((ksTime * 60 - lt) < 0) {
			setCookie("ss", new Date(), 0);
			alert("����ʱ�䵽!\n�����ύ�Ծ�!");
			document.forms[0].submit();
		} else {
			lm = Math.floor(lt / 60);
			ls = lt % 60;
			allY = ksTime * 60 - lt;
			ym = Math.floor(allY / 60);
			ys = allY % 60;
			document.getElementById("tTime").innerHTML = "�����Ѿ���ʼ��" + lm + "��"
					+ ls + "��" + ",ʣ��" + ym + "��" + ys + "��";
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
							<td><div align="center" >����ʱ�䣺120 ����</div>
							</td>
							<td><div align="center">������${student.sname}</div>
								<input type="" name="stuID" value="${student.sid}">
							</td>
							<td><div align="center" >�ܷ� ��100 ��</div>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td><div id="tTime"></div>
							</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td colspan="3" bgcolor="#999999" class="STYLE4">ѡ����(ÿС��4�֣���25��)</td>
						</tr>
						<!--��Ŀ��ʼ-->

						<c:forEach var="list1" items="${list1}" begin="1" end="25" varStatus="s">
							<tr>
								<input type="hidden" name="subjectID" value="${s.index}" />
								<td colspan="3"><strong>��<span class="STYLE5">${s.index}</span>��&nbsp;${list1.setitle}</strong></td>
							</tr>
							<tr>
								<td colspan="3"><strong>A��</strong>${list1.sea}</td>
							</tr>
							<tr>
								<td colspan="3"><strong>B��</strong>${list1.seb}</td>
							</tr>
							<tr>
								<td colspan="3"><strong>C��</strong>${list1.sec}</td>
							</tr>
							<tr>
								<td colspan="3"><strong>D��</strong>${list1.sed}</td>
							</tr>
							<tr>
								<td height="32" colspan="3" bgcolor="#CCCCCC">ѡ��𰸣� 
								<input type="radio" name="subjectAnswer${list1.setitle}" value="A" /> A 
								<input type="radio" name="subjectAnswer${list1.setitle}" value="B" /> B 
								<input type="radio" name="subjectAnswer${list1.setitle}" value="C" /> C 
								<input type="radio" name="subjectAnswer${list1.setitle}" value="D" /> D</td>
							</tr>
						</c:forEach>
						<!--��Ŀ����-->
						<tr>
							<td colspan="3"><div align="center">
									<input type="submit" value=" �ύ��� " name="Submit" />
									
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