<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.blog.dao.ArticleDao,com.blog.dto.Article" %>
<%@ page language="java" import="com.blog.dao.FeedbackDao,com.blog.dto.Feedback" %>


<%
   String    title = "",content="",time="",list_con="";
   int       sid = 0,blogid=0;
   String    id = request.getParameter("id");
   
   ArticleDao   dao = new ArticleDao();  
   Article      art =  dao.getArticle(id); 
                blogid = art.getBlogid();
                sid = art.getSortid();
                title  = art.getTitle();
                content = art.getContent();              
                time = art.getPubtime();
                
   java.util.Calendar Datenow = Calendar.getInstance();
   java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   String nowdate = formatter.format(Datenow.getTime());	
   
   FeedbackDao  fdao = new FeedbackDao();
   List   list3 = fdao.getList(id);
   Iterator  it3 = list3.iterator();
   while(it3.hasNext()){
     Feedback  fk=(Feedback)it3.next();
     list_con += " <div class=\"entry\"><p>"+fk.getContent()+" </p></div>"
		        +" <p class=\"byline\"><small>日期:"+fk.getPubtime()+" 作者: <a href=\"#\">"
		        + fk.getUname()+"</a>| <a href=\"#\">"+fk.getIp()+"</a> </small></p>";				
  }
  if(list_con==""){
     list_con=" <div class=\"entry\"><p>暂无评论!</p></div>";
  }
   
 %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Article·Lrtwjhs</title>

<script type="text/javascript" src="nicEdit.js"></script>
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript">
	bkLib.onDomLoaded(function() { nicEditors.allTextAreas() });
</script>
<%@include file="head.jsp"  %>
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
    <div class="about">
			<h2 class="title"><%=title %></h2>
			<p class="byline"><small><%=time %> </small></p>
			</div>
				<p> <%=content %></p>				
				
      </br>
      </br>

            <%@include file="comment.jsp" %>

			</div> 	
		</div>
    </div>
		<!-- end page -->
</div>


<div class="yw"></div>
<%@include file="bottom.jsp" %>
 
</body>
</html>
