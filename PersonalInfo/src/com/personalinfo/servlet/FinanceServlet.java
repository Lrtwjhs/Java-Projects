package com.personalinfo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.personalinfo.dao.FinanceDao;
import com.personalinfo.dto.Finance;


public class FinanceServlet extends HttpServlet{
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
    	String F_id = request.getParameter("F_id");	
    	String F_time = request.getParameter("F_time");
    	String F_ievent = request.getParameter("F_ievent");
    	String F_pevent = request.getParameter("F_pevent");
    	String F_income = request.getParameter("F_income");
    	String F_pay = request.getParameter("F_pay");
    	String F_remamoney = request.getParameter("F_remamoney");
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
    	Finance  user = null;
    	FinanceDao   dao = new FinanceDao(); //创建数据库操作对象
    	
    	switch(opt){
    	case  1:
    		if((!Uid.equals(null))||(!Uid.equals(""))){
    		  uid = Integer.parseInt(Uid);
    	    } 
    		user =  new Finance();//实例化bean对象 
    		user.setF_time(F_time);
    		user.setF_ievent(F_ievent);
    		user.setF_pevent(F_pevent);
    		user.setF_income(F_income);
    		user.setF_pay(F_pay);
    		user.setF_remamoney(F_remamoney);
    		user.setUid(uid);
    		
    		f = dao.add(user);
    		  if(f>0){
    			  msg ="添加成功!";
    		  }else{
    			  msg ="添加失败!";
    		  }
    		  break;
    	case  2:
    		if(F_id!=null||F_id!=""){
        		intid = Integer.parseInt(F_id);
        	}
    		user =  new Finance();//实例化bean对象
    		user.setF_id(intid);
    		user.setF_time(F_time);
    		user.setF_ievent(F_ievent);
    		user.setF_pevent(F_pevent);
    		user.setF_income(F_income);
    		user.setF_pay(F_pay);
    		user.setF_remamoney(F_remamoney);
    		
    		f = dao.update(user);
		      if(f>0){
			     msg ="修改成功!";
		      }else{
			     msg ="修改失败!";
		      } 
		      break;
    	case  3:
    		if(F_id!=null||F_id!=""){
        		intid = Integer.parseInt(F_id);
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
    	out.println("<script language=\"javascript\"> alert(\" "+msg+" \");self.location='F_list.jsp'; </script>"); //结果反馈  
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws
    ServletException,IOException{
    	this.doGet(request, response);
    }
}
