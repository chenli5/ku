<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>考试试卷管理</title>
  </head>
  
  <body>
  <div>
    <form action="service/tgtServlet">
     	<tr>
    		<td>请输入题库ID：<input type="text" name="itemID"></td>
    		<td>请输入题库名称：<input type="text" name="itemName"></td>
    	</tr><br>
    	<tr>
    		
    		<td><input type="text" value="题干"></td>
    		<td><input type="text" style="width:20px" value="A"></td>
    		<td><input type="text" style="width:20px" value="B"></td>
    		<td><input type="text" style="width:20px" value="C"></td>
    		<td><input type="text" style="width:20px" value="D"></td>
    		<td><input type="text" style="width:60px" value="正确答案"></td>
    	</tr><br>	
    	<tr>
    		
    		<td><input type="text" name="T1"></td>
    		<td><input type="text" name="A1" style="width:20px"></td>
    		<td><input type="text" name="B1" style="width:20px"></td>
    		<td><input type="text" name="C1" style="width:20px"></td>
    		<td><input type="text" name="D1" style="width:20px"></td>
    		<td><input type="text" name="ANWER1" style="width:60px"></td>
    	</tr><br>
    	<tr>
    		
    		<td><input type="text" name="T2"></td>
    		<td><input type="text" name="A2" style="width:20px"></td>
    		<td><input type="text" name="B2" style="width:20px"></td>
    		<td><input type="text" name="C2" style="width:20px"></td>
    		<td><input type="text" name="D2" style="width:20px"></td>
    		<td><input type="text" name="ANWER2" style="width:60px"></td>
    	</tr><br>    	
    	<tr>
    		
    		<td><input type="text" name="T3"></td>
    		<td><input type="text" name="A3" style="width:20px"></td>
    		<td><input type="text" name="B3" style="width:20px"></td>
    		<td><input type="text" name="C3" style="width:20px"></td>
    		<td><input type="text" name="D3" style="width:20px"></td>
    		<td><input type="text" name="ANWER3" style="width:60px"></td>
    	</tr><br>
    	<tr>
    		
    		<td><input type="text" name="T4"></td>
    		<td><input type="text" name="A4" style="width:20px"></td>
    		<td><input type="text" name="B4" style="width:20px"></td>
    		<td><input type="text" name="C4" style="width:20px"></td>
    		<td><input type="text" name="D4" style="width:20px"></td>
    		<td><input type="text" name="ANWER4" style="width:60px"></td>
    	</tr><br>
    	<tr>
    		
    		<td><input type="text" name="T5"></td>
    		<td><input type="text" name="A5" style="width:20px"></td>
    		<td><input type="text" name="B5" style="width:20px"></td>
    		<td><input type="text" name="C5" style="width:20px"></td>
    		<td><input type="text" name="D5" style="width:20px"></td>
    		<td><input type="text" name="ANWER5" style="width:60px"></td>
    	</tr><br>    	    	  
    	<td><button type="submit">确定录入</button></td>  	    	
    </form>
   </div> 
  </body>
</html>
