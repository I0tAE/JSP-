<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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


</head>
<script>
function up(txm){
  var sl=document.getElementById("sl"+txm).value;
  var t=1;
  location.href="zhysprk?txm="+txm+"&sl="+sl;
}
</script>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a>首页</a></li>
    <li><a>商品入库</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    <form action="zhysprk" onsubmit="return test();">

    <div class="tools">
    
    	<ul class="toolbar">
    	<li><input name="txm" id="txm" type="text" class="dfinput" style="margin-left:0px;margin-right:-10px;"></li>               
        
        </ul>
        <input type="submit" class="btn" value="扫描商品条形码" required>
        <ul class="toolbar1">
        <li><a href="zhyDrop" onclick="return confirm('确认全部删除?')"><span><img src="images/t03.png"></span>清空列表</a></li>
         <li><a href="zhySprkAll" onclick="return confirm('确认入库?')"><span><img src="images/t01.png"></span>商品入库</a></li>
        </ul>
    
    </div>
    </form>
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
        <c:forEach items="${spss }" var="sp" varStatus="status">
		    <tr>
	        <td align="center">${sp.id }</td>
	        <td align="center">${sp.nc }</td>
	        <td align="center">${sp.dw }</td>
	        <td align="center">${sp.txm }</td>
	        <td align="center">${sp.jj }</td>
	        <td align="center">${sp.mj }</td>
	        <td align="center">${sp.pzk }</td>
	        <td align="center"><input type="text" name = "sl${sp.txm }" id = "sl${sp.txm }" value="${sp.kc }" onblur="up(${sp.txm });" style="border:1px solid #b6cad2 ;height:22px; "/></td>
	        <td align="center"><a href="zhyDeleteSp?id=${sp.id }" onclick="return confirm('确认删除?')"><img src="images/t03.png" height="15" width="15">删除</a></td>
			</tr>
			</c:forEach>
       
        </tbody>
    </table>        
    
    </div>
    

</body></html>