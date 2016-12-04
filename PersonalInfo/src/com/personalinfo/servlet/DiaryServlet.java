package com.personalinfo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.personalinfo.dao.DiaryDao;
import com.personalinfo.dto.Diary;


public class DiaryServlet extends HttpServlet{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
    	String D_id = request.getParameter("D_id");
    	String D_time = request.getParameter("D_time");
    	String D_weather = request.getParameter("D_weather");
    	String D_week = request.getParameter("D_week");
    	String D_event = request.getParameter("D_event");   	
    	String Uid = request.getParameter("Uid");
   	    int intid = 0,uid=0;
    	
    	
    	int opt = 0; //命令参数   1,add  2,update  3,delete
    	int f = 0;   //判断参数
    
    	if("add".equals(action)){
    		opt = 1;
    	}else if("update".equals(action)){
    		opt = 2;
    	}else if("delete".equals(action)){
    		opt = 3;
    	}
    	Diary  user =  null;
    	DiaryDao   dao = new DiaryDao(); //创建数据库操作对象
    	
    	switch(opt){
    	case  1:
    		if((!Uid.equals(null))||(!Uid.equals(""))){
        		uid = Integer.parseInt(Uid);
        	}
    		  user =  new Diary();//实例化bean对象    	

    		  user.setD_time(D_time);
    		  user.setD_weather(D_weather);
    		  user.setD_week(D_week);
    		  user.setD_event(D_event);
    		  user.setUid(uid);
    		  
    		  f = dao.add(user);
    		  if(f>0){
    			  msg ="添加成功!";
    		  }else{
    			  msg ="添加失败!";
    		  }
    		  break;
    	case  2:
    		if(D_id!=null||D_id!=""){
        		intid = Integer.parseInt(D_id);
        	}     	
        	  user =  new Diary();//实例化bean对象    	
        	  user.setD_id(intid);
    		  user.setD_time(D_time);
    		  user.setD_weather(D_weather);
    		  user.setD_week(D_week);
    		  user.setD_event(D_event);
        	  
    		  f = dao.update(user);
		      if(f>0){
			     msg ="修改成功!";
		      }else{
			     msg ="修改失败!";
		      } 
		      break;
    	case  3:
    		if(D_id!=null||D_id!=""){
        		intid = Integer.parseInt(D_id);
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
    	out.println("<script language=\"javascript\">alert(\" "+msg+" \");self.location='D_list.jsp'; </script>"); //结果反馈  
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws
    ServletException,IOException{
    	this.doGet(request, response);
    }
}
