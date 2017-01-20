package com.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.dao.FeedbackDao;
import com.blog.dto.Feedback;


public class FeedbackServlet extends HttpServlet{
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

//   	 编号	    id 		    int    
//   	 昵称	        uname		VARCHAR (20) 	
//   	 IP          IP		    VARCHAR (30) 
//   	 内容            	content		TEXT(2000) 	
//   	 发布日期	    pubtime		DATETIME 	
//   	 文章编号    	articleid	int     
    	String id = request.getParameter("id");
    	String uname = request.getParameter("uname");
    	String ip = request.getRemoteAddr();//获取ip
    	String content = request.getParameter("content");
    	String pubtime = request.getParameter("pubtime");
    	String articleid = request.getParameter("articleid");
    	int intid = 0,aid=0;
    	
    	int opt = 0; //命令参数   1,add  2,update  3,delete
    	int f = 0; //判断参数
    
    	if("add".equals(action)){
    		opt = 1;
    	}else if("update".equals(action)){
    		opt = 2;
    	}else if("delete".equals(action)){
    		opt = 3;
    	}
    	
    	FeedbackDao   dao = new FeedbackDao(); //创建数据库操作对象
    	
    	switch(opt){
    	case  1:
    		if(articleid!=null||articleid!=""){
        		aid = Integer.parseInt(articleid);
        	 }
    		  Feedback  user = new Feedback(aid,content,intid,ip,pubtime,uname);//实例化bean对象    	
    		  f = dao.add(user);
    		  if(f>0){
    			  msg ="添加成功!";
    		  }else{
    			  msg ="添加失败!";
    		  }
    		  out.println("<script language=\"javascript\">alert(\" "+msg+" \");self.location='show_art.jsp?id="+articleid+"'; </script>"); //结果反馈  
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
		     out.println("<script language=\"javascript\">alert(\" "+msg+" \");history.back();'; </script>"); //结果反馈  
		      break;
        default :msg = "参数不足，操作失败!";
             out.println("<script language=\"javascript\">alert(\" "+msg+" \");history.back();'; </script>"); //结果反馈  
        break;
    	}
    	
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws
    ServletException,IOException{
    	this.doGet(request, response);
    }
}
