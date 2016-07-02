<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.blog.dao.ArticleDao,com.blog.dto.Article" %>
<%@ page language="java" import="com.blog.dao.SortDao ,com.blog.dto.Sort" %>

<%
   String    title = "",content="",nowdate="";
   int       sid = 0,blogid=0;
   String    id = request.getParameter("id");
   
   ArticleDao   dao = new ArticleDao();  
   Article      art =  dao.getArticle(id); 
                blogid = art.getBlogid();
                sid = art.getSortid();
                title  = art.getTitle();
                content = art.getContent();
                nowdate = art.getPubtime();               
            
   String      optstr = "",selected="";
   SortDao     sdao = new SortDao();
  
   List     list =  sdao.getList();           
   Iterator  it = list.iterator();
   while(it.hasNext()){
      Sort  l = (Sort)it.next();
      if(l.getId()==sid){
        selected = "<option  value='"+l.getId()+"' selected>"+l.getName()+"</option>";
      }else{
         selected = "<option  value='"+l.getId()+"' >"+l.getName()+"</option>";
      }
      optstr += selected;
   }
   
 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>内容页面</title>
    <link href="Css/Style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="../nicEdit.js"></script>
    <script type="text/javascript">
	   bkLib.onDomLoaded(function() { nicEditors.allTextAreas() });
    </script>
  </head>
  
<body>
  
    <form  action="/BlogVer1_0/article" method="post">
       <table width="100%" cellpadding="0" class="Table1" bordercolor="#4ab902" border="1" cellspacing="0">
        <tr>
          <td height="25" width="100" align="right">标题：
          <input  type="hidden" id="action" name="action" value="update" >
          <input  type="hidden" id="blogid" name="blogid" value="<%=blogid %>" >
           <input  type="hidden" id="id" name="id" value="<%=id %>" >
          <input  type="hidden" id="pubtime" name="pubtime" value="<%=nowdate %>" ></td>
          <td><input type="text" id="title" name="title" value="<%=title %>" ></td>
        </tr>
         <tr>
          <td height="25"  width="100" align="right">类别</td>
          <td>
          <select name='sortid'>
              <%=optstr %>
          </select></td>
        </tr>
        <tr height="165">
          <td  align="right" width="100">内容：</td>
          <td> 
             <textarea    style="width:520px;height:155px"  name="content" id='content'><%=content %></textarea> </td>
        </tr>
        <tr>
          <td height="25" align="right">&nbsp;</td>
          <td><input type="submit" value="提交" name="Submit"></td>
        </tr>
      </table>
      </form>
    
  </body>
</html>
