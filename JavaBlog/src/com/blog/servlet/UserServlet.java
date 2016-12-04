package com.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.dao.UserDao;
import com.blog.dto.User;

public class UserServlet extends HttpServlet{
    public void init(ServletConfig config)throws ServletException{
    	
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws
    ServletException,IOException{
    	request.setCharacterEncoding("utf-8");
    	response.setContentType("text/html; charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        
    	PrintWriter  out = response.getWriter();
    	String   msg = "";
    	String action = request.getParameter("action"); //页面的命令参数
    	
    	String id = request.getParameter("id");
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	String subject = request.getParameter("subject");
    	String email = request.getParameter("email");
    	String image = request.getParameter("image");
    	int intid = 0;
    	
    	
    	int opt = 0; //命令参数   1,add  2,update  3,delete
    	int f = 0; //判断参数
    
    	if("add".equals(action)){
    		opt = 1;
    	}else if("update".equals(action)){
    		opt = 2;
    	}else if("delete".equals(action)){
    		opt = 3;
    	}
    	User  user = null;
    	UserDao   dao = new UserDao(); //创建数据库操作对象
    	
    	switch(opt){
    	case  1: 
    		user = new User(intid,username,password,subject,email,image,1);//实例化bean对象    	
    		  f = dao.add(user);
    		  if(f>0){
    			  msg ="添加成功!";
    		  }else{
    			  msg ="添加失败!";
    		  }
    		  break;
    	case  2:
    		if(id!=null||id!=""){
        		intid = Integer.parseInt(id);
        	}
    		user = new User(intid,username,password,subject,email,image,1);//实例化bean对象    	
    		f = dao.update(user);
		      if(f>0){
			     msg ="修改成功!";
		      }else{
			     msg ="修改失败!";
		      } 
		      break;
    	case  3:
    		if(id!=null||id!=""){
        		intid = Integer.parseInt(id);
        	}
    		f = dao.delete(intid);
		     if(f>0){
			     msg ="删除成功!";
		      }else{
			     msg ="删除失败!";
		      }  
		      break;
        default :msg = "参数不足，操作失败!"; break;
    	}
    	out.println("<script language=\"javascript\">alert(\" "+msg+" \");self.location='admin/U_list.jsp'; </script>"); //结果反馈  
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws
    ServletException,IOException{
    	this.doGet(request, response);
    }
}
