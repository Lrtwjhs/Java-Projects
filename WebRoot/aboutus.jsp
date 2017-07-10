<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>About·Lrtwjhs</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
<%@include file="head.jsp"  %>
</head>
<body>
<%@include file="nav.jsp"%>
<div class="cdf"></div>
<div class="container">
    <div class="post">
        <div class="about">
			<p><h2>About</h2></p>
			<p class="byline"><small> some thing about me.</a>  </small></p>
			</div>
	    
	    <div class="content">
				<p> 
				  这个网站是基于JSP和HTML5开发，是今年学习JSP Web开发的结课项目，主要使用的技术为：
				  <ul>
				  <li>JSP + Severlet + javabean</li>
				  <li>Mysql作为数据库</li>
				  <li>多说作为评论系统</li>
				  <li>HTML5为标签语言</li>
				  <li>Bootstrap作为前端框架</li>
				  </ul>
				  由于时间原因，仅完成大致结构，很多细节还未很好改进，后续的优化我将在我的<a href="https://github.com/Lrtwjhs/JavaWeb">Github</a>上进行持续更新........
                </p>
        </div>

   </br>
   </br>

		<%@include file="comment.jsp" %>
	    
	</div>     
</div>


<div class="yw"></div>
<%@include file="bottom.jsp" %>
</body>
</html>
