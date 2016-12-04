<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
   session.setAttribute("U_id","");
   session.removeAttribute("U_id");
out.println("<script language=\"javascript\">alert(\"成功退出!\");self.location='login.jsp'; </script>");
%>