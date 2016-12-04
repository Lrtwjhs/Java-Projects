<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.personalinfo.dao.UserDao,com.personalinfo.dto.User" %>

<% 

//取得用户ID
String   U_id = (String)session.getAttribute("U_id");
UserDao  dao = new UserDao();
User l = dao.getLink(U_id);
String username = l.getUsername();
String email = l.getEmail();



%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>内容页面</title>
       <link href="css/style.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
  
    <form  action="/PersonalInfo/user?action=update" method="post">
       <table width="100%" cellpadding="0" class="Table1" bordercolor="#438EB9" border="1" cellspacing="0">
        <tr>
          <td height="25" align="right">用户名：                  
          <input type="hidden" id="id" name="id" value="<%=U_id %>">                  
          <td><input type="text" id="username" name="username" value="<%=username%>"></td>
        </tr>
        <tr>
          <td height="25" align="right">新密码：</td>
          <td><input type="password" id="password" name="password"></td>
        </tr>
                <tr>
          <td height="25" align="right">确认密码：</td>
          <td><input type="password"></td>
        </tr>
                       <tr>
          <td height="25" align="right">Email:：</td>
          <td><input type="text" id="email" name="email" value="<%=email%>" ></td>
        </tr>
        
          <td height="25" align="right">&nbsp;</td>
          <td><input type="submit" value="提交" name="Submit"></td>
        </tr>
      </table>
      </form>
     
  </body>
</html>
