<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.blog.dao.UserDao" %>

<%
String username = request.getParameter("userid");
String password = request.getParameter("passwd");
int  isUser = 0;
UserDao  dao = new UserDao();
isUser = dao.isUser(username,password);

//  System.out.println("user and pwd"+username+"----"+password+"========="+isUser);

if(isUser>0){
   session.setAttribute("blogid",new Integer(isUser).toString());//绑定用户id
   response.sendRedirect("main.jsp");
}else{
  out.println("<script language=\"javascript\">alert(\" 用户名或者密码有错误 \");self.location='index.jsp'; </script>");
}


%>
