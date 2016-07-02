<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.blog.dao.ArticleDao,com.blog.dto.Article" %>

<% 
  String   list_con = "",part_msg = "",spage = "",type_str="";
  spage =request.getParameter("pg"); //获取传递来的参数
  String  total = "";
  String  current = "";
  String  totalpage = "";
  ArticleDao  dao = new ArticleDao();
  
  int      up=1,down=1;  
  int      pgSize = 10; //每页显示的条数
  int      cpage = 0;    //当前显示的条数
  
  if(spage!=null){
      cpage = Integer.parseInt(spage);				
   }
  
  List     lista =  dao.getList(cpage,pgSize);           
  Iterator  ita = lista.iterator();
  while(ita.hasNext()){
     Article  l = (Article)ita.next();
     list_con +=  "<h2 class=\"title\"><a href='show_art.jsp?id="+l.getId()+"' >"+l.getTitle()+"</a></h2>"
			   +" <p class=\"byline\"><small>日期:"+l.getPubtime()+"  </small></p>"
		       +" <div class=\"entry\"> "
			   +"<blockquote><p>&#8220;"+l.getContent()+" &#8221;</p></blockquote></div>";				
  }
  
  total = new Integer(dao.getTotal()).toString();
  current = new Integer(dao.getCPages()).toString();
  totalpage = new Integer(dao.getTPages()).toString();
  
  //分页运算
  up = dao.getCPages()-1;
  down = dao.getCPages()+1;  
  
  if(up<1){
     up = 1;
  }
  
  if(down>=dao.getTPages()){
     down = dao.getTPages();
  }    

  part_msg = "共"+total+"条数据，分"+totalpage+"页，当前为第"+current+"页 <a href='list_article.jsp?pg="+up+"'> 上一页</a> <a href='list_article.jsp?pg="+down+"'>下一页 </a>";
  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>文章列表_红色玫瑰</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<div id="wrapper">
<!-- start header -->
<div id="header">
	<h1>红色玫瑰 </h1>
	<p>Red Roses </p>
</div>
<!-- end header -->
<%@include file="dh.jsp"  %>
<!-- start page -->
<div id="page">
	<!-- start content -->
	<div id="content">	
		<div class="post">
		    <p class="meta"><a href="#" class="more">文章列表</a> </p>
			  <%=list_con  %>
		   <p class="meta"><%=part_msg  %></p>
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
