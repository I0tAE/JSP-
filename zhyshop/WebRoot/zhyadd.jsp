<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script>
function test(){
var phone = document.getElementsById("ph").value;
if(isNaN(phone)){
alert('请输入数字');
return false;
}
return true;}</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">会员管理</a></li>
    <li><a href="#">添加</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    <form action="zhyAdd" method="post" onsubmit="return test();"><ul class="forminfo">
    <li><label>会员昵称</label><input name="name" type="text" class="dfinput" required/></li>
    <li><label>会员电话</label><input name="phone" id="ph" type="text"  class="dfinput" required/></li>
    <li><label>会员地址</label><input name="addr" type="text" class="dfinput"/></li>
    <li><label>会员级别</label><select name="jbs" id="jbs" class="dfinput">
    <option value="普通会员">普通会员</option>
    <option value="黄金会员">黄金会员</option>
    <option value="钻石会员">钻石会员</option></select></li>
    <li><input type="submit" value="提交" style="width:60px;height:20px;"/></li>
    </ul>
    </form>
    
    </div>
</body>
</html>

