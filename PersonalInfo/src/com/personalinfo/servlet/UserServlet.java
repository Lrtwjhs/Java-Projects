package com.personalinfo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.personalinfo.dao.UserDao;
import com.personalinfo.dto.User;

public class UserServlet extends HttpServlet {
	/**
	 * @author lrtwjhs
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
		String action = request.getParameter("action"); // 页面的命令参数

		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		int intid = 0;

		int opt = 0; // 命令参数 1,add 2,update 3,delete
		int f = 0; // 判断参数

		if ("add".equals(action)) {
			opt = 1;
		} else if ("update".equals(action)) {
			opt = 2;
		} else if ("delete".equals(action)) {
			opt = 3;
		}
		User user = null;
		UserDao dao = new UserDao(); // 创建数据库操作对象

		switch (opt) {
		case 1:
			user = new User();// 实例化bean对象
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			
			f = dao.add(user);
			if (f > 0) {
				msg = "注册成功，前往登陆!";
			} else {
				msg = "注册失败!";
			}
			out.println(
					"<script language=\"javascript\">alert(\" " + msg + " \");self.location='index.jsp'; </script>"); // 结果反馈
			
			break;
		case 2:
			if (id != null || id != "") {
				intid = Integer.parseInt(id);
			}
			user = new User();// 实例化bean对象
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			f = dao.update(user);
			if (f > 0) {
				msg = "修改成功!";
			} else {
				msg = "修改失败!";
			}
			out.println(
					"<script language=\"javascript\">alert(\" " + msg + " \");self.location='welcome.jsp'; </script>"); // 结果反馈
			break;
		case 3:
			if (id != null || id != "") {
				intid = Integer.parseInt(id);
			}
			f = dao.delete(intid);
			if (f > 0) {
				msg = "删除用户成功!";
			} else {
				msg = "删除用户失败!";
			}
			out.println(
					"<script language=\"javascript\">alert(\" " + msg + " \");self.location='welcome.jsp'; </script>"); // 结果反馈
			break;
		default:
			msg = "参数不足，操作失败!";
			out.println(
					"<script language=\"javascript\">alert(\" " + msg + " \");self.location='U_update.jsp'; </script>"); // 结果反馈
			break;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
