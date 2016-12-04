package com.personalinfo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.personalinfo.dao.MemorandumDao;
import com.personalinfo.dto.Memorandum;


public class MemorandumServlet extends HttpServlet{
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
    	String M_id = request.getParameter("M_id");
    	String M_theme = request.getParameter("M_theme");
    	String M_time = request.getParameter("M_time");
    	String M_place = request.getParameter("M_place");
    	String M_event = request.getParameter("M_event");
    	String M_status = request.getParameter("M_status");
    	String Uid = request.getParameter("Uid");
    	int intid = 0,uid=0;
    	
    	
    	int opt = 0; //命令参数   1,add  2,update  3,delete
    	int f = 0; //判断参数
    
    	if("add".equals(action)){
    		opt = 1;
    	}else if("update".equals(action)){
    		opt = 2;
    	}else if("delete".equals(action)){
    		opt = 3;
    	}
    	Memorandum  user = null; 
    	MemorandumDao   dao = new MemorandumDao(); //创建数据库操作对象
    	
    	switch(opt){
    	case  1: 
    		if((!Uid.equals(null))||(!Uid.equals(""))){
      		  uid = Integer.parseInt(Uid);
      	    }
    		  user = new Memorandum(M_theme,M_time,M_place,M_event,M_status,uid);//实例化bean对象    	
//    		  user.setM_theme(M_theme);
//    		  user.setM_time(M_time);
//    		  user.setM_place(M_place);
//    		  user.setM_event(M_event);
//    		  user.setM_status(M_status);
//    		  user.setUid(uid);
    		  
    		  f = dao.add(user);
    		  if(f>0){
    			  msg ="添加成功!";
    		  }else{
    			  msg ="添加失败!";
    		  }
    		  break;
    	case  2: 
        	if(M_id!=null||M_id!=""){
        		intid = Integer.parseInt(M_id);
        	}
            user = new Memorandum();//实例化bean对象
            user.setM_id(intid);
  		    user.setM_theme(M_theme);
  		    user.setM_time(M_time);
  		    user.setM_place(M_place);
  		    user.setM_event(M_event);
  		    user.setM_status(M_status);
//            user.setUid(Integer.parseInt(Uid));
            
    		f = dao.update(user);
		      if(f>0){
			     msg ="修改成功!";
		      }else{
			     msg ="修改失败!";
		      } 
		      break;
    	case  3:
    		if(M_id!=null||M_id!=""){
    		intid = Integer.parseInt(M_id);
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
    	out.println("<script language=\"javascript\">alert(\" "+msg+" \");self.location='M_list.jsp'; </script>"); //结果反馈  
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws
    ServletException,IOException{
    	this.doGet(request, response);
    }
}
