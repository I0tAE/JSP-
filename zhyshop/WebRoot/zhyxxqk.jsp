<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>万能销售系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/laydate.js"></script>
<link type="text/css" rel="stylesheet" href="js/need/laydate.css">
<link type="text/css" rel="stylesheet" href="js/skins/yahui/laydate.css" id="LayDateSkin">
<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>
<script type="text/javascript">
function del(path)
{
    if(confirm('确定删除该记录?'))
        location.href = path;
    else 
        return false;
}


</script>

</head>

<body>

	<div class="place">
	 <a href="zhyrkxq2"><span>返回 |</span></a>
    <span>位置：</span>
   
    <ul class="placeul">
    <li>首页</li>
    <li>入库情况</li>
    <li>详细情况</li>
    </ul>
    </div>
    
    </form>
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th style="text-align:center;">编号</th>
        <th style="text-align:center;">单号</th>
        <th style="text-align:center;">商品id</th>
        <th style="text-align:center;">商品名称</th>
	    <th style="text-align:center;">商品进价</th>
	    <th style="text-align:center;">商品卖价</th>
	    <th style="text-align:center;">商品数量</th>
	    <th style="text-align:center;">入库时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${rkss }" var="rk" varStatus="status">
        <td>${status.index+1 }</td>
        <td>${rk.id }</td>
        <td>${rk.spid }</td>
        <td>${rk.spmc }</td>
        <td>${rk.spjj }</td>
        <td>${rk.spmj }</td>
        <td>${rk.spsl }</td>
        <td>${rk.sptime }</td>
        <tr>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</body></html>
