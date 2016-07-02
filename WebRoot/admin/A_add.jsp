<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.blog.dao.SortDao ,com.blog.dto.Sort" %>
<%
   String    optstr = "",blogid="";
   SortDao   dao = new SortDao();
   blogid = (String)session.getAttribute("blogid");
  
   List     list =  dao.getList();           
   Iterator  it = list.iterator();
   while(it.hasNext()){
      Sort  l = (Sort)it.next();
      optstr += "<option  value='"+l.getId()+"'>"+l.getName()+"</option>";
   }
   
   java.util.Calendar Datenow = Calendar.getInstance();
   java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   String nowdate = formatter.format(Datenow.getTime());	
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
          <input  type="hidden" id="action" name="action" value="add" >
          <input  type="hidden" id="blogid" name="blogid" value="<%=blogid %>" >
          <input  type="hidden" id="pubtime" name="pubtime" value="<%=nowdate %>" ></td>
          <td><input type="text" id="title" name="title" ></td>
        </tr>
         <tr>
          <td height="25"  width="100" align="right">类别</td>
          <td>
          <select name='sortid'>
             <option value="">请选择</option>
              <%=optstr %>
          </select></td>
        </tr>
        <tr height="165">
          <td  align="right" width="100">内容：</td>
          <td> 
             <textarea    style="width:520px;height:155px"  name="content" id='content'></textarea> </td>
        </tr>
        <tr>
          <td height="25" align="right">&nbsp;</td>
          <td><input type="submit" value="提交" name="Submit"></td>
        </tr>
      </table>
      </form>
    
  </body>
</html>
