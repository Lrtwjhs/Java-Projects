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
			<p class="byline"><small><%=time %> </small><small>by   admin</small></p>
			</div>
				<p> <%=content %></p>				
				
      </br>
      </br>

<!-- 多说评论框 start -->
  <div class="ds-thread" data-thread-key="" data-title="<%=title %>" data-url=""></div>
<!-- 多说评论框 end -->
<!-- 多说公共JS代码 start (一个网页只需插入一次) -->
<script type="text/javascript">
var duoshuoQuery = {short_name:"javawebtest"};
  (function() {
    var ds = document.createElement('script');
    ds.type = 'text/javascript';ds.async = true;
    ds.src = (document.location.protocol == 'https:' ? 'https:' : 'http:') + '//static.duoshuo.com/embed.js';
    ds.charset = 'UTF-8';
    (document.getElementsByTagName('head')[0] 
     || document.getElementsByTagName('body')[0]).appendChild(ds);
  })();
  </script>
<!-- 多说公共JS代码 end -->

			</div> 	
		</div>
    </div>
		<!-- end page -->
</div>




    <!--注释原评论>
		<div class="post">	
    <p class="meta"><a href="#" class="more">网友评论</a></p>
		     <%=list_con %>						
			 	
		</div>
		  <div class="post">	
      <p class="meta"><a href="#" class="more"> 发布评论</a></p>
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

</div>
 -->

<div class="yw"></div>
<%@include file="bottom.jsp" %>
 
</body>
</html>
