<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<link rel="stylesheet" href="css/main.css" />
<title>学生主页</title>
<style type="text/css">
.showdiv {
	MARGIN-RIGHT: auto;
	MARGIN-LEFT: auto;
	background-color: #ff6;
	border: 1px solid #f90;
	text-align: center;
	line-height: 40px;
	font-size: 12px;
	font-weight: bold;
	z-index: 99;
	width: 300px;
	height: 120px;
	display: none;
}

.bg {
	MARGIN-RIGHT: auto;
	MARGIN-LEFT: auto;
	background-color: #fff;
	width: 100%;
	height: 50%;
	filter: alpha(opacity = 50); /*IE*/
	opacity: 0.5; /*FF*/
	z-index: 1;
	display: none;
}

a {
	text-decoration: none;
	}
.btn
{
	display: inline-block; 
	zoom: 1; /* zoom and *display = ie7 hack for display:inline-block */ 
	*display: inline; 
	vertical-align: baseline; 
	margin: 0 2px; 
	outline: none; 
	cursor: pointer; 
	text-align: center; 
	text-decoration: none; 
	font: 14px/100% Arial, Helvetica, sans-serif; 
	padding: .5em 2em .55em; 
	text-shadow: 0 1px 1px rgba(0,0,0,.3); 
	-webkit-border-radius: .5em; 
	-moz-border-radius: .5em; 
	border-radius: .5em; 
	-webkit-box-shadow: 0 1px 2px rgba(0,0,0,.2); 
	-moz-box-shadow: 0 1px 2px rgba(0,0,0,.2); 
	box-shadow: 0 1px 2px rgba(0,0,0,.2); 
}
</style>
<script type="text/javascript" src="jquery/jquery.js">
</script>
<script>
$(function() {
    //alert($(window).height());
    $('#check').click(function() {
        $('#code').center();
        $('#goodcover').show();
        $('#code').fadeIn();
    });
    $('#closebt').click(function() {
        $('#code').hide();
        $('#goodcover').hide();
    });
	$('#goodcover').click(function() {
        $('#code').hide();
        $('#goodcover').hide();
    });
    /*var val=$(window).height();
	var codeheight=$("#code").height();
    var topheight=(val-codeheight)/2;
	$('#code').css('top',topheight);*/
    jQuery.fn.center = function(loaded) {
        var obj = this;
        body_width = parseInt($(window).width());
        body_height = parseInt($(window).height());
        block_width = parseInt(obj.width());
        block_height = parseInt(obj.height());

        left_position = parseInt((body_width / 2) - (block_width / 2) + $(window).scrollLeft());
        if (body_width < block_width) {
            left_position = 0 + $(window).scrollLeft();
        };

        top_position = parseInt((body_height / 2) - (block_height / 2) + $(window).scrollTop());
        if (body_height < block_height) {
            top_position = 0 + $(window).scrollTop();
        };

        if (!loaded) {

            obj.css({
                'position': 'absolute'
            });
            obj.css({
                'top': ($(window).height() - $('#code').height()) * 0.5,
                'left': left_position
            });
            $(window).bind('resize', function() {
                obj.center(!loaded);
            });
            $(window).bind('scroll', function() {
                obj.center(!loaded);
            });

        } else {
            obj.stop();
            obj.css({
                'position': 'absolute'
            });
            obj.animate({
                'top': top_position
            }, 200, 'linear');
        }
    };

});
</script>
</head>

<body>
	<div id="sbox">
		<div
			style="width:100%;height:300px;background-image: url(images/student_top.jpg);position: absolute;left: 0px;top:0px;"></div>
		<div id="sid"
			style="position:absolute;
				left:225px;
				top:30px;">你的学号为：${userId}</div>
		<div id="sname" style="position: absolute;left:15px;top:30px">${student.sname}欢迎使用在线考试系统</div>



		<div id="goodcover"></div>

		<div id="code">
			<div class="close1">
				<a href="javascript:void(0)" id="closebt"><img
					src="images/close.gif">
				</a>
			</div>
			<div class="goodtxt">
				<p>你的成绩是：</p>
				<p>${student.sscore}</p>
			</div>
		</div>
		
	</div>

	<div style="position:absolute;
				left:480px;
				top:320px;">
		<input type="submit" value="成绩查询" id="check" class="btn">

		<a href="service/testServlet"><input type="submit" value="参加考试"
			id="test" class="btn">
		</a> <a href="service/stestServlet"><input type="submit" value="习题演练"
			id="stest" class="btn">
		</a>
	</div>
	
</body>
</html>
