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
    <span>位置：</span>
    <ul class="placeul">
    <li>首页</li>
    <li>入库情况</li>
    </ul>
    </div>
    
    <div class="rightinfo">
    <form action="zhyrkxq" method="get">
    <div class="tools">    
    	
        <input class="laydate-icon" id="tj" name="tj" value="${time }" size="28" style="height:30px;">   
        <input type="submit" class="btn" value="查询" style="margin-height:30px;">
    
    </div>
    </form>
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th style="text-align:center;">编号</th>
        <th style="text-align:center;">单号</th> 
	    <th style="text-align:center;">商品进价</th>
	    <th style="text-align:center;">商品卖价</th>
	    <th style="text-align:center;">商品数量</th>
	    <th style="text-align:center;">入库时间</th>	    
	    <th style="text-align:center;width:150px">商品操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${rks }" var="rk" varStatus="status">
        <td>${status.index+1 }</td>
        <td>${rk.id }</td>
        <td>${rk.spjj }</td>
        <td>${rk.spmj }</td>
        <td>${rk.spsl }</td>
        <td>${rk.sptime }</td>
        <td><a href="zhyXxqk?id=${rk.id }">详细情况</a></td>
        <tr>
        </tr>
        </c:forEach>
         
        </tbody>
    </table>
    
   





  
    
    <title>My JSP 'yejiao.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  
  
  
    <div class="pagin">
    
    	<div class="message">共<i class="blue">${column }</i>条记录，<i class="blue">${pagecount }</i>页，当前显示第&nbsp;<i class="blue">${pagenow+1 }&nbsp;</i>页</div>
       
        <ul class="paginList">
        <li class="paginItem"><a href="zhyrkxq2?page=0">|&lt;</a></li>
        <li class="paginItem"><c:choose><c:when test="${pagenow==0 }"><a href="#">&lt;</a></c:when><c:otherwise><a href="zhyrkxq2?page=${pagenow-1 }">&lt;</a></c:otherwise></c:choose></li>
        <li class="paginItem current"><a href="javascript:;">...</a></li>
        <li class="paginItem"><c:choose><c:when test="${pagenow==pagecount-1 }"><a href="#">&gt;</a></c:when><c:otherwise><a href="zhyrkxq2?page=${pagenow+1 }">&gt;</a></c:otherwise></c:choose></li>
        <li class="paginItem"><a href="zhyrkxq2?page=${pagecount }">&gt;|</a></li>
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
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
	<script type="text/javascript">
!function(){
	laydate.skin('yahui');//切换皮肤，请查看skins下面皮肤库
	laydate({elem: '#tj'});//绑定元素
}();

//日期范围限制
var start = {
    elem: '#start',
    format: 'YYYY-MM-DD',
    min: laydate.now(), //设定最小日期为当前日期
    max: '2099-06-16', //最大日期
    istime: true,
    istoday: false,
    choose: function(datas){
         end.min = datas; //开始日选好后，重置结束日的最小日期
         end.start = datas //将结束日的初始值设定为开始日
    }
};

var end = {
    elem: '#end',
    format: 'YYYY-MM-DD',
    min: laydate.now(),
    max: '2099-06-16',
    istime: true,
    istoday: false,
    choose: function(datas){
        start.max = datas; //结束日选好后，充值开始日的最大日期
    }
};
laydate(start);
laydate(end);

//自定义日期格式
laydate({
    elem: '#test1',
    format: 'YYYY年MM月DD日',
    festival: true, //显示节日
    choose: function(datas){ //选择日期完毕的回调
        alert('得到：'+datas);
    }
});

//日期范围限定在昨天到明天
laydate({
    elem: '#hello3',
    min: laydate.now(-1), //-1代表昨天，-2代表前天，以此类推
    max: laydate.now(+1) //+1代表明天，+2代表后天，以此类推
});
</script>
</body></html>
