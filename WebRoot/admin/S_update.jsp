<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.blog.dao.SortDao,com.blog.dto.Sort" %>

<% 
  String   name = "";
  
  String   id = request.getParameter("id"); 
  SortDao  dao = new SortDao();
  
   Sort  l =  dao.getSort(id);  
   int   blogid = l.getBlogid();
         name = l.getName();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>内容页面</title>
    <link href="Css/Style.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
      <form  action="/BlogVer1_0/sort" method="post">
       <table width="100%" cellpadding="0" class="Table1" bordercolor="#4ab902" border="1" cellspacing="0">
        <tr>
          <td height="25" align="right">名称：
          <input  type="hidden" id="id" name="id" value="<%=id %>" >
          <input  type="hidden" id="blogid" name="blogid" value="<%=blogid %>" >
          <input  type="hidden" id="action" name="action" value="update" ></td>
          <td><input type="text" id="name" name="name" value="<%=name %>" ></td>
        </tr>
        
        <tr>
          <td height="25" align="right">&nbsp;</td>
          <td><input type="submit" value="提交" name="Submit"></td>
        </tr>
      </table>
      </form>
      
  </body>
</html>
