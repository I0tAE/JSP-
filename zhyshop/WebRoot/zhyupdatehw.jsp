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
    <li><a href="#">商品管理</a></li>
    <li><a href="#">更新</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    <form action="zhyUpdateHw" method="post"><ul class="forminfo">
    <li><label>商品ID</label><input name="id" type="text" class="dfinput" value="${spd.id }" readonly/></li>
    <li><label>商品名称</label><input name="nc" type="text" class="dfinput" value="${spd.nc }" required/></li>
    <li><label>商品单位</label><input name="dw" type="text" class="dfinput" value="${spd.dw }" required/></li>
    <li><label>商品条形码</label><input name="txm" type="text" class="dfinput" value="${spd.txm }"/></li>
    <li><label>商品进价</label><input name="jj" type="text" class="dfinput" value="${spd.jj }"/></li>
    <li><label>商品售价</label><input name="mj" type="text" class="dfinput" value="${spd.mj }"/></li>
    <li><label>商品普通会员折扣</label><input name="pzk" type="text" class="dfinput" value="${spd.pzk }"/></li>
    <li><label>商品白金会员折扣</label><input name="bzk" type="text" class="dfinput" value="${spd.bzk }"/></li>
    <li><label>商品黄金会员折扣</label><input name="hzk" type="text" class="dfinput" value="${spd.hzk }"/></li>
    <li><label>商品库存</label><input name="kc" type="text" class="dfinput" value="${spd.kc }"/></li>
    <li><label>商品备注</label><input name="bz" type="text" class="dfinput" value="${spd.bz }"/></li>
    <li><label>商品入库时间</label><input name="dtime" type="text" class="dfinput"  value="${spd.rkt }" readonly/></li>
    <li><input type="submit" value="提交" style="width:60px;height:20px;"/></li>
    <li><a href="zhyHw">返回</a></li>
    </ul>
    </form>
    
    </div>
</body>
</html>

