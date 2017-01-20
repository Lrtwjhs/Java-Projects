<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理首页</title>
<link href="Css/Style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="Nav">
  <div class="BarLeft"></div>
  <div id="NavContent">
    <ul>
      <li><a href="Index_main.jsp"  target="mainFrame" >管理首页</a></li>
      <li><a href="A_list.jsp"      target="mainFrame" >文章管理</a></li>
      <li><a href="S_list.jsp" target="mainFrame">分类管理</a></li>
      <li><a href="U_list.jsp" target="mainFrame">用户管理</a></li>  
      <li><a href="F_list.jsp" target="mainFrame">评论管理</a></li>    
      <li><a href="L_list.jsp" target="mainFrame" >友情链接</a></li>
      <li><a href="logout.jsp" target="_top" >退出系统</a></li>
    </ul>
  </div>
  <div class="BarRight"></div>
  <div class="Cal"></div>
</div>
<div id="Content">
  <div id="ContentLeft">
    <div id="ContentLeftTop">
      <div class="BarLeft"></div>
      <div id="ContentLeftTopText">添加菜单</div>
      <div class="BarRight"></div>
      <div class="Cal"> </div>
    </div>
    <div id="ContentLeftBox">
      <ul>
        <li><a href="Index_main.jsp"  target="mainFrame" >返回首页>></a></li>
        <li><a href="A_add.jsp"   target="mainFrame" >新建文章>></a></li>
        <li><a href="S_add.jsp" target="mainFrame" >添加分类>></a></li>
        <li><a href="U_add.jsp" target="mainFrame" >添加用户>></a></li>  
        <li><a href="L_add.jsp" target="mainFrame" >添加友情链接>></a></li>
      </ul>
    </div>
  </div>
  <div id="ContentRight">
    <div id="ContentRightTop">
      <div class="BarLeft"></div>
      <div id="ContentRightTopText">系统配置</div>
      <div class="BarRight"></div>
      <div class="Cal"></div>
    </div>
    <div id="ContentRightBox">
    
      <iframe height="500px" width="100%" border="0" frameborder="0" id="mainFrame" name="mainFrame" title="mainFrame" src="Index_main.jsp" ></iframe>
   
    </div>
    <div class="Cal"></div>
  </div>
</div>
<div id="Bottom"><a href="#" target="_blank"></a></div>
</body>
</html>
