<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
   session.setAttribute("blogid","");
   session.removeAttribute("blogid");
out.println("<script language=\"javascript\">alert(\"成功退出!\");self.location='../index.jsp'; </script>");
%>
