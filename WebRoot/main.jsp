<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.blog.dao.ArticleDao,com.blog.dto.Article" %>

<% 
  String   list_con = "",part_msg = "",spage = "",type_str="";
  spage =request.getParameter("pg"); //获取传递来的参数
  String  total = "";
  String  current = "";
  String  totalpage = "";
  
  int      up=1,down=1;  
  int      pgSize = 10; //每页显示的条数
  int      cpage = 0;    //当前显示的条数
  
  if(spage!=null){
      cpage = Integer.parseInt(spage);				
   }
   
  String      cid = request.getParameter("cid");
  ArticleDao  dao = new ArticleDao(); 
  
  List     lista =  dao.getList(cpage,pgSize,cid);           
  Iterator  ita = lista.iterator();
  while(ita.hasNext()){
     Article  l = (Article)ita.next();
     type_str = l.getSort();
     list_con +=  "<h3 class=\"title\"><a href='show_art.jsp?id="+l.getId()+"'>"+l.getTitle()+"</a></h3>"
			   +" <p class=\"byline\"><small>日期:"+l.getPubtime()+" </small></p>"
		       +" <div class=\"entry\"> "
			   ;				
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

  part_msg = "共"+total+"条数据，分"+totalpage+"页，当前为第"+current+"页 <a href='main.jsp?cid="+cid+"&pg="+up+"'> 上一页</a> <a href='main.jsp?cid="+cid+"&pg="+down+"'>下一页 </a>";
  
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title><%=type_str %>·Lrtwjhs</title>

<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<%@include file="nav.jsp"  %>
<div class="cdf"></div>
<div class="container">

<!-- start page -->
<div id="page">
	<!-- start content -->
	<div id="content">
		<div class="post">
    <div class="about" style="font-size:9px;">
      <h3><%=type_str %></h3>
      </br>

			<%=list_con %>
			<p class="meta"><%=part_msg  %></p>
		</div>
	</div>
	<!-- end content -->
</div>
</div>
<!-- end page -->

</br>

<div class="footer">
<div class="footer-wrapper">
<hr>
  <p>&copy;2016 All Rights Reserved &nbsp;&&nbsp; Design by <a href="https://github.com/Lrtwjhs">Lrtwjhs</a>.</p>
</div>
</div>

</body>
</html>
