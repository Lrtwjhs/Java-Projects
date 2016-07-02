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

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title><%=title %>_红色玫瑰</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<script type="text/javascript" src="nicEdit.js"></script>
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript">
	bkLib.onDomLoaded(function() { nicEditors.allTextAreas() });
</script>

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
			<h2 class="title"><%=title %></h2>
			<p class="byline"><small><%=time %> </small></p>
			<div class="entry">
				<p> <%=content %></p>				
			</div>					
			 <p class="meta"><a href="#" class="more">网友评论</a></p>	
		</div>
		
		<div class="post">	
		     <%=list_con %>						
			 <p class="meta"><a href="#" class="more"> 发布评论</a></p>	
		</div>
		  <div class="post">	
		       <div class="entry">
				  <p>
	     <form  action="feedback" method="post"> 
	      <li>  昵称：
           <input  type="hidden" id="articleid" name="articleid" value="<%=id %>" >
           <input  type="hidden" id="pubtime" name="pubtime" value="<%=nowdate %>" >
           <input type='hidden' name = "action" value="add">
           <input type='text' name = "uname" value=""> 
           </li>           
        <li>
                      内容：<textarea    style="width:520px;height:155px"  name="content" id='content'></textarea>
        </li>           
        <li> <input type="submit" value="提交" name="Submit"> </li>
				  </form>
				  </p>				
			   </div>	
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
