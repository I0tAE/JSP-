<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加商品</title>
<script type="text/javascript">
function isCharsNotInBag (s, bag) //逐个判断s字符串中每个字符是否都在限定范围bag内
  { 
	var i,c; 
	for (i = 0; i < s.length; i++) 
	{ 
	c = s.charAt(i);
	if (bag.indexOf(c) < 0) //不在则返回真
	 return true; 
	} 
	return false; 
 } 
	
	function InValidChar(s) //无效输入判断(为真说明输入无效）
	{ 
	var haserrorChar; 
	var CorrectChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
	haserrorChar = isCharsNotInBag(s, CorrectChar);
	return haserrorChar;
  } 
function test()
{
    var name = document.getElementById("nc").value;
    var dw = document.getElementById("dw").value;
    var txm = document.getElementById("txm").value;
    var mj = document.getElementById("mj").value;
    var zk = document.getElementById("pzk").value;
    var zk1 = document.getElementById("bzk").value;
    var zk2 = document.getElementById("hzk").value;
    if(name=="")
    {
        alert("商品名称不能为空");
        return false;
    }    
    if(dw=="")
    {
        alert("单位不能为空");
        return false;
    }     
    if(txm=="")
    {
        alert("条形码不能为空");
        return false;
    }    
    if(mj=="")
    {
        alert("卖价不能为空");
        return false;
    }
    if(isNaN(mj))
    {
        alert("价格只能是数字");
        document.getElementById("mj").value="";
        return false;
    }
    if(isNaN(zk))
    {
        alert("折扣只能是数字");
        document.getElementById("zk").value="10";
        return false;
    }
    if(zk<0 || zk>10)
    {
        alert("折扣只能在0-10之间");
        document.getElementById("zk").value="10";
        return false;
    }
    if(isNaN(zk1))
    {
        alert("折扣只能是数字");
        document.getElementById("zk1").value="10";
        return false;
    }
    if(zk1<0 || zk1>10)
    {
        alert("折扣只能在0-10之间");
        document.getElementById("zk1").value="10";
        return false;
    }
    if(isNaN(zk2))
    {
        alert("折扣只能是数字");
        document.getElementById("zk2").value="10";
        return false;
    }
    if(zk2<0 || zk2>10)
    {
        alert("折扣只能在0-10之间");
        document.getElementById("zk2").value="10";
        return false;
    }
    return true;
}
</script>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a>添加商品信息</a></li>
    </ul>
    </div>
    
    <div class="formbody" style="margin-left:20px;margin-right:130px;">
    
    <div class="formtitle"><span>基本信息</span></div>
    <form action="zhyAddGoods" method="post" onsubmit="return test();">
    <ul class="forminfo">
    <li><label>商品名称：</label><input name="nc" id="nc" type="text" class="dfinput"><i><i style="color: red;">*</i>不能为空</i></li>
    <li><label>商品单位：</label><input name="dw" id="dw" type="text" class="dfinput"><i><i style="color: red;">*</i>如:个、件、只等,不能为空</i></li>
    
    <li><label>商品进价：</label><input name="jj" id="jj" type="text" class="dfinput" value=""><i><i> </i>只能填数字</i></li>
    <li><label>商品卖价：</label><input name="mj" id="mj" type="text" class="dfinput" value=""><i><i style="color: red;">*</i>只能填数字</i></li>
    <li><label>普通会员折扣：</label><input name="pzk" id="pzk" type="text" class="dfinput" value="10"><i><i> </i>只能填数字，且只能是0-10之间，10为不打折</i></li>
    <li><label>白金会员折扣：</label><input name="bzk" id="bzk" type="text" class="dfinput" value="10"><i><i> </i>只能填数字，且只能是0-10之间，10为不打折</i></li>
    <li><label>黄金会员折扣：</label><input name="hzk" id="hzk" type="text" class="dfinput" value="10"><i><i> </i>只能填数字，且只能是0-10之间，10为不打折</i></li>
    <li><label>备&nbsp;&nbsp;&nbsp;&nbsp;注：</label><textarea name="bz" id="bz" cols="" rows="" class="textinput"></textarea></li>  
    <li><label>条 形 码：</label><input name="txm" id="txm" type="text" class="dfinput"><i><i style="color: red;">*</i>不能为空</i></li>
    <li><label>&nbsp;</label><input type="submit" class="btn" value="添加商品"></li>
    </ul>
    </form>
    
    </div>



 
</body></html>