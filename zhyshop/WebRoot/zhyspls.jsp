<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>零售</title>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
</script>
<link href="css/style.css" rel="stylesheet" type="text/css">
<script><!--
function ssrk(txm){
var sl = document.getElementById("sl"+txm).value;
location.href="zhySpls1?sl="+sl+"&txm="+txm;
}
function hy(){
var role = document.getElementById("role").value;
var hyphone = document.getElementById("hyphone").value;
location.href="zhySpls2?hyphone="+hyphone;
}
function spjs(){
var iTop = (window.screen.availHeight-280)/2;
var iLeft = (window.screen.availWidth-210)/2; 
window.open("zhyspjs.jsp","",'height=250,width=200,left='+iLeft+',top='+iTop);
}
function tz(role){
location.href="zhySpls?role="+role;
}
function c(){
var role=document.getElementById("role").value;
if(role==1){
document.getElementById("a").style="color:red;";
}else if(role==2){
document.getElementById("b").style="color:red;";
}else if(role==3){
document.getElementById("c").style="color:red;";
}else{
document.getElementById("d").style="color:red;";}
}
</script>


</head>

<body onload="c()">

	<div class="place">
    <span>顾客：</span>
    <ul class="placeul">
    <li><a href="#" onclick="tz(1)"><label id="a" style="">顾客A</label></a></li>
    <li><a href="#" onclick="tz(2)"><label id="b" style="">顾客B</label></a></li>
    <li><a href="#" onclick="tz(3)"><label id="c" style="">顾客C</label></a></li>
    <li><a href="#" onclick="tz(4)"><label id="d" style="">顾客D</label></a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    <form action="zhySpls" onsubmit="return test();">
    <input type="hidden" name="role" id="role" value="${role }">
    <div class="tools">
    
    	<ul class="toolbar">
    	<li><input name="txm" id="txm" type="text" class="dfinput" style="margin-left:0px;margin-right:-10px;width:250px;"></li>               
        
        </ul>
        
        <input type="submit" class="btn" value="扫描商品条形码">
         会员电话：<input name="hyphone" id="hyphone" value="${phone }" type="text" onblur="hy();" class="dfinput" style="margin-left:0px;margin-right:-10px; width:150px;">
      &nbsp;&nbsp;<label style="color:red"></label><label style="color:blue"></label>
      <label style="margin-left:10px;font-size:16px;font-weight:20px;">*${jb }</label>
      <b><label style="margin-left:10px;font-size:16px;font-weight:20px;">总金额：${sum }￥</label></b>
        <ul class="toolbar1">        
         <li><a href="zhyDeletels"><span><img src="images/t03.png"></span>清空列表</a></li>
         <li><a href="#" onclick="spjs();"><span><img src="images/t01.png"></span>商品结算</a></li>
        </ul>
    
    </div>
    </form>
    <form name="form1" action="action/rk.jsp">
    <input type="hidden" name="role" value="1">
    <table class="tablelist">
    	<thead>
    	<tr>
        <th style="text-align:center;">编号</th>
        <th style="text-align:center;">名称</th>        
        <th width="45" style="text-align:center;">单位</th>   
        <th style="text-align:center;">条形码</th> 
	    <th style="text-align:center;">商品进价</th>
	    <th style="text-align:center;">商品卖价</th>
	    <th style="text-align:center;">商品折扣</th>
	    <th style="text-align:center;">商品数量</th>
	    <th style="text-align:center;width:150px">商品操作</th>
        </tr>
        </thead>
        <tbody>
        	<c:forEach items="${spls }" var="sp" varStatus="status">
		    <tr>
	        <td align="center">${sp.id }</td>
	        <td align="center">${sp.nc }</td>
	        <td align="center">${sp.dw }</td>
	        <td align="center">${sp.txm }</td>
	        <td align="center">${sp.jj }</td>
	        <td align="center">${sp.mj }</td>
	        <td align="center">${sp.pzk }</td>
	       <td align="center"><input size="4" type="text" name="sl${sp.txm }" id="sl${sp.txm }" value="${sp.kc }" style="border:1px solid #b6cad2 ;height:22px; " onblur="ssrk(${sp.txm })"></td>	
	        <td align="center"><a href="zhyDeletelsByid?id=${sp.id }"><img src="images/t03.png" height="15" width="15">&nbsp;删除</a></td>
	        </tr> 
			</c:forEach>
       
        </tbody>
    </table>
      <input size="4" type="hidden" name="rowcount" id="rowcount" value="1">	        
	  </form>
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body></html>