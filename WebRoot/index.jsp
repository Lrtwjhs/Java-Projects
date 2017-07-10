<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.blog.dao.ArticleDao,com.blog.dto.Article" %>

<% 
  String      list_con = "";
  ArticleDao  dao = new ArticleDao();
  
  List     lista =  dao.getList(0,10);           
  Iterator  ita = lista.iterator();
  while(ita.hasNext()){
     Article  l = (Article)ita.next();
          list_con +=  "<h3 class=\"post-item\"><a href='show_art.jsp?id="+l.getId()+"' >"+l.getTitle()+"</a></h3>"
         +" <p class=\"meta\"><small>"+l.getPubtime()+"  </small></p>"
         ;			
  }
  
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Lrtwjhs</title>
<link rel="icon" href="favicon.ico" type="image/x-icon"> 
<%@include file="head.jsp"  %>
</head>
<body>

<%@include file="nav.jsp"  %>
<div class="container">
<div class="header-title">
<div class="header-title-wrapper">
<div class="avatar">
<img src="images/user.png">
</div>
<h1>Lrtwjhs</h1>
<p class="meta">An interesting place to discover</p>
<p>Hi, there. I'm Lrtwjhs, a student of Information and computing science in Northeastern university at Qinhuangdao. I love developing software and web applications and I blog about them.</p>
</div>
<div class="loadmore">
 <a href="list_article.jsp" class="btn btn-default">More</a>
</div>







<%@include file="bottom.jsp" %>
    

</div>
</body>
</html>
