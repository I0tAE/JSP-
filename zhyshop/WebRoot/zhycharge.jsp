<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">会员管理</a></li>
    <li><a href="#">更新</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    <form action="zhyCharge" method="post"><ul class="forminfo">
    <li><label>会员ID</label><input name="id" type="text" class="dfinput" value="${vip.id }" readonly/></li>
    <li><label>会员昵称</label><input type="text" class="dfinput" value="${vip.vname }" readonly/></li>
    <li><label>剩余余额</label><input name="qb" type="text" class="dfinput" value="${vip.qb }" readonly/></li>
    <li><label>剩余积分</label><input name="jf" type="text" class="dfinput" value="${vip.jf }" readonly/></li>
    <li><label>充值金额</label><input name="money" type="text" class="dfinput"/></li>
    <li><label>充值积分</label><input name="score" type="text" class="dfinput"/></li>
    <li><input type="submit" value="提交" style="width:60px;height:20px;"/></li>
     <li><a href="zhyQuery">返回</a></li>
    </ul>
    </form>
    
    </div>
</body>
</html>