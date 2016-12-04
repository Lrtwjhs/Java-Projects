package com.personalinfo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.personalinfo.dto.User;
import com.personalinfo.tools.*;

//Users
public class UserDao {
	DBcon dba = new DBcon();
	DataDAO dao = new DataDAO();
	String sql = "";

	// Invalidate
	public int isUser(String username, String password) {
		sql = "select U_id from Users  where U_username= '" + username + "' and U_password ='" + password + "'";

		int flag = 0;// 默认为false
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = dba.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next())
				flag = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println("DataDAO--isExist()" + e.getMessage());
		} finally {
			DBcon.close(conn, null, stmt, rs);
		}
		return flag;
	}

	// add
	public int add(User link) {
		String username = "";
		String password = "";
		String email = "";

		username = dao.changSqlStr(link.getUsername());
		password = dao.changSqlStr(link.getPassword());
		email = dao.changSqlStr(link.getEmail());
		sql = "insert into  Users (U_username,U_password,U_email) values (" + username + "," + password + "," + email
				+ ")";
		return dao.executeUpdate(sql);
	}

	// update
	public int update(User link) {
		int id = 0;
		String username = "";
		String password = "";
		String email = "";

		id = link.getId();
		username = dao.changSqlStr(link.getUsername());
		password = dao.changSqlStr(link.getPassword());
		email = dao.changSqlStr(link.getEmail());

//		sql = "update Users set U_username=" + username + ",U_password=" + password  + "  where U_id = " + id;
		sql  = "update Users set U_username=" +username+",U_password=" + password + "where U_id=" + id;
		return dao.executeUpdate(sql);
	}

	// delete
	public int delete(int id) {
		sql = "delete from  Users  where U_id = " + id;
		return dao.executeUpdate(sql);
	}

	// List
	public List getList() {
		List list = new ArrayList();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		sql = "select U_id,U_username,U_password,U_email Users from Users";

		try {
			conn = dba.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				User link = new User();
				link.setId(rs.getInt(1));
				link.setUsername(rs.getString(2));
				link.setPassword(rs.getString(3));
				link.setEmail(rs.getString(4));
				list.add(link);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// Link
	public User getLink(String id) {
		User link = new User();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		sql = "select U_id,U_username,U_password,U_email from Users where U_id = " +id;

		try {
			conn = dba.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				link.setId(rs.getInt(1));
				link.setUsername(rs.getString(2));
				link.setPassword(rs.getString(3));
				link.setEmail(rs.getString(5));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return link;
	}

	// ************分页方法***************//
	// 分页参数
	private int Total;
	private int TPages;
	private int CPages;



	public int getTotal() {
		return Total;
	}

	public void setTotal(int total) {
		Total = total;
	}

	public int getTPages() {
		return TPages;
	}

	public void setTPages(int tPages) {
		TPages = tPages;
	}

	public int getCPages() {
		return CPages;
	}

	public void setCPages(int cPages) {
		CPages = cPages;
	}

	// List
	public List getList(int page, int MaxLine) {
		int Offset = 0;
		if (page <= 1) {
			page = 1;
			Offset = 0;
		} else {
			Offset = (page - 1) * MaxLine;
			// 如果参数为2，页码就是2*条数
		}
		List list = new ArrayList();
		ResultSet rs = null;
		sql = "select *  from Users";

		try {
			rs = dao.getSumRows(" from Users", sql, Offset, MaxLine);
			this.Total = dao.getTotal();
			this.CPages = dao.getCPages();
			this.TPages = dao.getTPages();

			while (rs.next()) {
				User link = new User();
				link.setId(rs.getInt(1));
				link.setUsername(rs.getString(2));
				link.setPassword(rs.getString(3));
				link.setEmail(rs.getString(4));

				list.add(link);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
