<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.personalinfo.dao.UserDao,com.personalinfo.dto.User" %>

<%

String   U_id = (String)session.getAttribute("U_id");



%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>内容页面</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
  </head>
  
<body>
  
    <form  action="/PersonalInfo/contact" method="post">
       <table width="100%" cellpadding="0" class="Table1" bordercolor="#438EB9" border="1" cellspacing="0">
        <tr>
          <td height="25" align="right">姓名：
          <input  type="hidden" id="action" name="action" value="add" >
          <input  type="hidden" id="Uid" name="Uid" value="<%=U_id %>" >
          </td>
          <td><input type="text" id="C_name" name="C_name" ></td>
        </tr>
        <tr>
          <td height="25" align="right">电话：</td>
          <td><input type="text" id="C_tel" name="C_tel" onkeyup="this.value=this.value.replace(/\D/g,'')" ></td>
        </tr>
        <tr>
          <td height="25" align="right">Email：</td>
          <td><input type="text" id="C_email" name="C_email"  ></td>
        </tr>
                <tr>
          <td height="25" align="right">职业：</td>
          <td><input type="text" id="C_job" name="C_job" ></td>
        </tr>
                <tr>
          <td height="25" align="right">所在城市：</td>
          <td><input type="text" id="C_city" name="C_city" ></td>
        </tr>
                <tr>
          <td height="25" align="right">备注：</td>
          <td><input type="text" id="C_remark" name="C_remark" ></td>
        </tr>
                
        <tr>
          <td height="25" align="right">&nbsp;</td>
          <td><input type="submit" value="提交" name="Submit"></td>
        </tr>
      </table>
      </form>
    
  </body>
</html>
