<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.blog.dao.ArticleDao,com.blog.dto.Article" %>

<% 
  String      list_con = "";
  ArticleDao  dao = new ArticleDao();
  
  List     lista =  dao.getList(0,10);           
  Iterator  ita = lista.iterator();
  while(ita.hasNext()){
     Article  l = (Article)ita.next();
     list_con +=  "<h2 class=\"title\"><a href='show_art.jsp?id="+l.getId()+"'>"+l.getTitle()+"</a></h2>"
			   +" <p class=\"byline\"><small>日期:"+l.getPubtime()+" </small></p>"
		       +" <div class=\"entry\"> "
			   +"<blockquote><p>&#8220;"+l.getContent()+" &#8221;</p></blockquote></div>";				
  }
  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Lrtwjhs</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<div id="wrapper">
<!-- start header -->
<div id="header">
	<h1>Lrtwjhs</h1>
	<p>Red Roses Blog</p>
</div>
<!-- end header -->
<%@include file="dh.jsp"  %>
<!-- start page -->
<div id="page">
	<!-- start content -->
	<div id="content">
		<div class="post">
			<h1 class="title">关于本站</h1>
			<p class="byline"><small>Posted on Jan 9th, 2011 by <a href="#">宋文</a> | <a href="#">Edit</a></small></p>
			<div class="entry">
				<p> 
				   博客的标题的得来还是很想了一下，在想的过程中，看自己想的也太多，所以何不简单一点呢？就叫简单生活好了。诚然我们在生活中过的也太复杂，太辛苦，所以在网络上简单一点也好，尽管可能被人骂，被人看不起。如果有人觉得我的博客不好，但愿也只有指教而不是漫骂。
                </p>
			</div>
			<p class="meta"><a href="list_article.jsp" class="more">最新文章列表</a> </p>
		</div>
		<div class="post">
			<%=list_con  %>
			<p class="meta"><a href="list_article.jsp" class="more">最新文章列表</a> </p>
		</div>
	</div>
	<!-- end content -->
	<!-- start sidebar -->
	<%@include file="left.jsp" %>
	<!-- end sidebar -->
</div>
</div>
<!-- end page -->
<%@include file="bottom.jsp" %>
</body>
</html>
