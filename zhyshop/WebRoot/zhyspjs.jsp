<%@ page language="java" import="java.util.*" pageEncoding="UTf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'zhyspjs.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <script>
  function sz(sum){
  var gm=document.getElementById("in").value;
  document.getElementById("money").value=gm-sum;
  }</script>
  </head>
  
  <body>
   <p style="text-align: center">商品结算</p>
   <form action="zhySpjs">
   <ul style="list-style:none;padding-left:0px;">
      <li>商品总价：<input type="text" value=${sum } readonly/></li>
      <li>会员级别: <input type="text" value=${jb } readonly/></li>
      <li>收取金额: <input type="text" name="in" id="in" onblur="sz(${sum });" required/></li>
      <li>应找金额: <input type="text" name="money" id="money"/></li>
        
   </ul>
   <input type="submit" value="结算"/>
  </form>
  </body>
</html>
