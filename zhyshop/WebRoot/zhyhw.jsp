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
function cz()
{
    var tj = document.getElementById("tj").value;
    location.href="zhyHw?tj="+tj;
    document.getElementById("tj").value=tj;
}


</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a>首页</a></li>
    <li><a>商品信息</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    <form name="form1" action="goodslist.jsp">
    <div class="tools">
    
    	<ul class="toolbar">
        <li><a href="zhyaddgoods.jsp"><span><img src="images/t01.png"></span>添加商品</a></li>        
        <li><a href="zhyhwtobase.jsp"><span><img src="images/t03.png"></span>商品入库</a></li>
        <li><a href="zhyOutGoodsToExcel"><span><img src="images/leftico04.png"></span>导出库存</a></li>
        </ul>
        <ul class="toolbar1">
        <li><input name="tj" id="tj" type="text" class="dfinput" style="margin-left:0px;margin-right:-10px;"></li>               
        <li><a href="#" onclick="cz(); return false;"><span><img src="images/t05.png"></span>查找</a></li>
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
	    <th style="text-align:center;">普通会员折扣</th>
	    <th style="text-align:center;">白金会员折扣</th>
	    <th style="text-align:center;">黄金会员折扣</th>
	    <th style="text-align:center;">商品库存</th>
	    <th style="text-align:center;">添加时间</th>
	    <th style="text-align:center;">备注</th>
	    <th style="text-align:center;width:200px">商品操作</th>
        </tr>
        </thead>
        <tbody>
        	<c:forEach items="${sps }" var="sp" varStatus="status">
		    <tr>
	        <td align="center">${sp.id }</td>
	        <td align="center">${sp.nc }</td>
	        <td align="center">${sp.dw }</td>
	        <td align="center">${sp.txm }</td>
	        <td align="center">${sp.jj }</td>
	        <td align="center">${sp.mj }</td>
	        <td align="center">${sp.pzk }</td>
	        <td align="center">${sp.bzk }</td>
	        <td align="center">${sp.hzk }</td>
	        <td align="center">${sp.kc }</td>
	        <td align="center">${sp.rkt }</td>
	        <td align="center">${sp.bz }</td>
	        <td align="center"><a href="zhyUpdateHw?id=${sp.id }"><img src="images/t02.png" height="15" width="15">修改</a>&nbsp; <a href="zhyDeleteHw?id=${sp.id }" onclick="return confirm('确认删除?')"><img src="images/t03.png" height="15" width="15">删除</a></td>
			</tr>
			</c:forEach>
	        
        </tbody>
    </table>
    <div class="pagin">
    
    	<div class="message">共<i class="blue">${countpage }</i>条记录，<i class="blue">${pagecount }</i>页，当前显示第&nbsp;<i class="blue">${pagenow+1 }&nbsp;</i>页</div>
       
        <ul class="paginList">
        <li class="paginItem"><a href="zhyHw?page=0">|&lt;</a></li>
        <li class="paginItem">
        <c:choose><c:when test="${pagenow==0}"><a>&lt;</a></c:when>
        <c:otherwise><a href="zhyHw?page=${pagenow-1 }">&lt;</a></c:otherwise></c:choose>
        </li>
        <li class="paginItem current"><a href="javascript:;">...</a></li>
        <li class="paginItem">
        <c:choose><c:when test="${pagenow==pagecount-1 }"><a>&gt;</a></c:when>
        <c:otherwise><li class="paginItem"><a href="zhyHw?page=${pagenow+1 }">&gt;</a></c:otherwise></c:choose>
        </li>
        <li class="paginItem"><a href="zhyHw?page=${pagecount-1 }">&gt;|</a></li>
        </ul>
        
    </div>
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png"></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button" class="sure" value="确定">&nbsp;
        <input name="" type="button" class="cancel" value="取消">
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body></html>