<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.blog.dao.SortDao,com.blog.dto.Sort" %>

<% 
  String   list_con = "",spage = "";
  SortDao  dao = new SortDao();  
  List     list =  dao.getList();           
  Iterator  it = list.iterator();
  while(it.hasNext()){
     Sort  l = (Sort)it.next();
      list_con += "<tr align='center'  height='25'><td>"+l.getId()+"</td><td>"+l.getBlogid()+"</td><td>"+l.getName()
               +"</td><td><a href='S_update.jsp?id="+l.getId()+"'>修改</a> | <a href='/BlogVer1_0/sort?action=delete&id="+l.getId()+"' >删除</a> </td></tr> \n";
    // System.out.println(list_con);
  }
  
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>内容页面</title>
    <link href="Css/Style.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
  
    <table width="100%" cellpadding="0" class="Table1" bordercolor="#4ab902" border="1" cellspacing="0">
      <tr align='center'  height='30'>
      <th>ID</th>
      <th>用户ID</th>
      <th>名称</th>
       <th>管理操作</th></tr>
       <%=list_con %>
      </table>
      <br/>
      
  </body>
</html>
