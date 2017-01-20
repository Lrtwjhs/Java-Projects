<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>内容页面</title>
    <link href="Css/Style.css" rel="stylesheet" type="text/css" />
  </head>
  
<body>
  
    <form  action="/Blog/user" method="post">
       <table width="100%" cellpadding="0" class="Table1" bordercolor="#4ab902" border="1" cellspacing="0">
        <tr>
          <td height="25" align="right">用户名：<input  type="hidden" id="action" name="action" value="add" ></td>
          <td><input type="text" id="username" name="username" ></td>
        </tr>
        <tr>
          <td height="25" align="right">密码：</td>
          <td><input type="text" id="password" name="password" ></td>
        </tr>
        <tr>
          <td height="25" align="right">博客标题：<input  type="hidden" id="image" name="image" value="image/default.jpg" ></td>
          <td><input type="text" id="subject" name="subject" ></td>
        </tr>
        <tr>
          <td height="25" align="right">电子邮件：<input  type="hidden" id="visitcount" name="visitcount" value="0" ></td>
          <td><input type="text" id="email" name="email" ></td>
        </tr>
                
        <tr>
          <td height="25" align="right">&nbsp;</td>
          <td><input type="submit" value="提交" name="Submit"></td>
        </tr>
      </table>
      </form>
    
  </body>
</html>
