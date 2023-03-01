<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网站后台管理系统HTML模板--模板之家 www.cssmoban.com</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
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
function cz(){
	var tj = document.getElementById("tj").value;
	location.href="zhyQuery?tj="+tj;
}
</script>


</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">数据表</a></li>
    <li><a href="#">基本内容</a></li>
    
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
    	<li><input name="tj" id="tj" type="text" value="${tj }" class="dfinput" style="margin-left:0px;margin-right:-10px;"></input></li>
        <li> <a href="#" onclick="cz();return false"><span><img src="images/ico06.png" height="25" width="25" /></span>查询</a></li>
        <li><a href="zhyExcel"><span><img src="images/ico06.png" height="25" width="25" /></span>导出会员信息</a></li>        
        </ul>
        
        
        <ul class="toolbar1">
        <li><span><img src="images/t05.png" /></span>设置</li>
        </ul>
    
    </div>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>编号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>会员ID</th>
        <th>会员名称</th>
        <th>会员电话</th>
        <th>会员钱包</th>
        <th>会员积分</th>
        <th>会员地址</th>
        <th>会员级别</th>
        <th>会员注册时间</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${vips }" var="vip" varStatus="status">
        <tr>
        <td><input name="" type="checkbox" value="" /></td>
        <td>${status.index+1 }</td>
        <td>${vip.id }</td>
        <td>${vip.vname }</td>
        <td>${vip.phone }</td>
        <td>${vip.qb }</td>
        <td>${vip.jf }</td>
        <td>${vip.addr }</td>
        <td>${vip.jb }</td>
        <td>${vip.dtime }</td>
        <td><a href="zhyCharge?id=${vip.id }" class="tablelink"><img src="images/ico03.png" height="15" width="15" />充值</a>
        	<a href="zhyUpdate?id=${vip.id }" class="tablelink"> <img src="images/t02.png" height="15" width="15" />修改</a>
        	<a href="zhyDelete?id=${vip.id }" class="tablelink" onclick="return confirm('确认删除')"><img src="images/t03.png" height="15" width="15" />删除</a> 
        	</td>
        </tr> 
        </c:forEach>
        </tbody>
    </table>
    
   
    <div class="pagin">
    	<div class="message">共<i class="blue">${pagecount }</i>页，当前显示第&nbsp;<i class="blue">${pagenow+1 }&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><c:choose><c:when test="${pagenow==0 }"><span class="pagepre"></span></c:when><c:otherwise><a href="zhyQuery?page=${pagenow-1 }">
        <span class="pagepre"></span></a></c:otherwise></c:choose></li>
        <li class="paginItem more"><a href="javascript:;">...</a></li>
        <li class="paginItem"><c:choose><c:when test="${pagenow==pagecount-1 }"><span class="pagenxt"></span></c:when><c:otherwise><a href="zhyQuery?page=${pagenow+1 }"><span class="pagenxt"></span></a></c:otherwise></c:choose></li>
        </ul>
    </div>
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
