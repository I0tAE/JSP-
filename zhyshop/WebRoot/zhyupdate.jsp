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
    <form action="zhyUpdate" method="post"><ul class="forminfo">
    <li><label>会员ID</label><input name="id" type="text" class="dfinput" value="${v.id }" readonly/></li>
    <li><label>会员昵称</label><input name="name" type="text" class="dfinput" value="${v.vname }" required/></li>
    <li><label>会员电话</label><input name="phone" type="text" class="dfinput" value="${v.phone }" required/></li>
    <li><label>会员钱包</label><input name="qb" type="text" class="dfinput" value="${v.qb }"/></li>
    <li><label>会员积分</label><input name="jf" type="text" class="dfinput" value="${v.jf }"/></li>
    <li><label>会员地址</label><input name="addr" type="text" class="dfinput" value="${v.addr }"/></li>
    <li><label>会员级别</label><select name="jb" class="dfinput">
    <option <c:if test="${v.jb =='普通会员'}">selected</c:if>>普通会员</option>
    <option <c:if test="${v.jb =='黄金会员'}">selected</c:if>>黄金会员</option>
    <option <c:if test="${v.jb =='钻石会员'}">selected</c:if>>钻石会员</option></select></li>
    <li><label>注册时间</label><input name="dtime" type="text" class="dfinput"  value="${v.dtime }"/></li>
    <li><input type="submit" value="提交" style="width:60px;height:20px;"/></li>
    <li><a href="zhyQuery">返回</a></li>
    </ul>
    </form>
    
    </div>
</body>
</html>

