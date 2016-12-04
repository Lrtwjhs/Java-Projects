package com.personalinfo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.personalinfo.dao.ContactDao;
import com.personalinfo.dto.Contact;

public class ContactServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");

		PrintWriter out = response.getWriter();
		String msg = "";
		String action = request.getParameter("action");// 页面的命令参数
		String C_id = request.getParameter("C_id");
		String C_name = request.getParameter("C_name");
		String C_tel = request.getParameter("C_tel");
		String C_email = request.getParameter("C_email");
		String C_job = request.getParameter("C_job");
		String C_city = request.getParameter("C_city");
		String C_remark = request.getParameter("C_remark");
		String Uid = request.getParameter("Uid");

		int intid = 0, uid = 0;

		int opt = 0; // 命令参数 1,add 2,update 3,delete
		int f = 0; // 判断参数

		if ("add".equals(action)) {
			opt = 1;
		} else if ("update".equals(action)) {
			opt = 2;
		} else if ("delete".equals(action)) {
			opt = 3;
		}
		Contact user = null;
		ContactDao dao = new ContactDao();// 创建数据库操作对象
		switch (opt) {
		case 1:
			if ((!Uid.equals(null)) || (!Uid.equals(""))) {
				uid = Integer.parseInt(Uid);
			}
			user = new Contact();// 实例化bean对象

			user.setC_name(C_name);
			user.setC_tel(C_tel);
			user.setC_email(C_email);
			user.setC_job(C_job);
			user.setC_city(C_city);
			user.setC_remark(C_remark);
			user.setC_Uid(uid);

			f = dao.add(user);
			if (f > 0) {
				msg = "添加成功!";
			} else {
				msg = "添加失败!";
			}
			break;
		case 2:
			// (!C_id.equals(null))||(!C_id.equals(""))
			// (C_id!=null||(!C_id.equals(""))
    		if(C_id!=null||C_id!=""){
        		intid = Integer.parseInt(C_id);
        	} 
			user = new Contact();// 实例化bean对象
			user.setC_id(intid);
			user.setC_name(C_name);
			user.setC_tel(C_tel);
			user.setC_email(C_email);
			user.setC_job(C_job);
			user.setC_city(C_city);
			user.setC_remark(C_remark);

			f = dao.update(user);
			if (f > 0) {
				msg = "修改成功!";
			} else {
				msg = "修改失败!";
			}
			break;
		case 3:
			if (C_id != null || C_id != "") {
				intid = Integer.parseInt(C_id);
			}
			f = dao.delete(intid);
			if (f > 0) {
				msg = "删除成功!";
			} else {
				msg = "删除失败!";
			}
			break;
		default:
			msg = "参数不足，操作失败!";
			break;
		}
		out.println("<script language=\"javascript\">alert(\" " + msg + " \");self.location='C_list.jsp'; </script>"); // 缁撴灉鍙嶉
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
