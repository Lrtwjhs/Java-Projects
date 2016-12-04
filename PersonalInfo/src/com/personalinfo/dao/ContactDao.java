package com.personalinfo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.personalinfo.dto.Contact;
import com.personalinfo.dto.Finance;
import com.personalinfo.tools.*;


//tb_Contacts
public class ContactDao {
	DBcon dba = new DBcon();
	DataDAO dao = new DataDAO();
	String sql = "";

	// isNull
	public boolean isNull() {
		sql = "select * from  tb_Contacts ";
		return dao.isExist(sql);
	}

	// add
	public int add(Contact contacts) {
		int Uid = 0;
		String C_name = "";
		String C_tel = "";
		String C_email = "";
		String C_job = "";
		String C_city = "";
		String C_remark = "";

		 //转换成   str --> 'str' 格式
		Uid = contacts.getUid();
		C_name = dao.changSqlStr(contacts.getC_name());
		C_tel = dao.changSqlStr(contacts.getC_tel());
		C_email = dao.changSqlStr(contacts.getC_email());
		C_job = dao.changSqlStr(contacts.getC_job());
		C_city = dao.changSqlStr(contacts.getC_city());
		C_remark = dao.changSqlStr(contacts.getC_remark());
		sql = "insert into tb_Contacts (Uid,C_name,C_tel,C_email,C_job,C_city,C_remark) values (" + Uid + "," + C_name + "," + C_tel + "," + C_email + "," + C_job + "," + C_city + "," + C_remark
				+ ")";
		return dao.executeUpdate(sql);
	}

	// update
	public int update(Contact contacts) {
		int C_id = 0;
		String C_name = "";
		String C_tel = "";
		String C_email = "";
		String C_job = "";
		String C_city = "";
		String C_remark = "";

		//转换成   str --> 'str' 格式
		C_id = contacts.getC_id();
		C_name = dao.changSqlStr(contacts.getC_name());
		C_tel = dao.changSqlStr(contacts.getC_tel());
		C_email = dao.changSqlStr(contacts.getC_email());
		C_job = dao.changSqlStr(contacts.getC_job());
		C_city = dao.changSqlStr(contacts.getC_city());
		C_remark = dao.changSqlStr(contacts.getC_remark());
	sql = "update tb_Contacts set C_name=" + C_name + ",C_tel=" + C_tel + ",C_email=" + C_email + ",C_job=" + C_job
				+ ",C_city=" + C_city + ",C_remark=" + C_remark + "where C_id =" + C_id;
		return dao.executeUpdate(sql);
	}

	// delete
	public int delete(int C_id) {
		sql = "delete from tb_Contacts   where C_id =" + C_id;
		return dao.executeUpdate(sql);
	}
	 
	 // List  
	 public List<Contact> getList(String C_id){	
		 Contact contacts = new Contact();
		 int Uid = contacts.getUid();
		List<Contact> list = new ArrayList<Contact>();
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;
		sql = "select *  from tb_Contacts where C_id = " + C_id ;		
		try {
			conn = dba.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
			   Contact Contactst = new Contact();
			   Contactst.setC_id(rs.getInt(1));
			   Contactst.setC_name(rs.getString(2));
			   Contactst.setC_tel(rs.getString(3));
			   Contactst.setC_email(rs.getString(4));
			   Contactst.setC_job(rs.getString(5));
			   Contactst.setC_city(rs.getString(6));
			   Contactst.setC_remark(rs.getString(7));
			   Contactst.setC_Uid(rs.getInt(8));
			   
			   list.add(Contactst);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return  list;
	 }
	 
	 // Contacts  
	 public Contact getContacts(String  C_id){
		Contact Contactst = new Contact();
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;
		sql = "select * from tb_Contacts where C_id = " + C_id;		
		try {
			conn = dba.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				
				   Contactst.setC_id(rs.getInt(1));
				   Contactst.setC_name(rs.getString(2));
				   Contactst.setC_tel(rs.getString(3));
				   Contactst.setC_email(rs.getString(4));
				   Contactst.setC_job(rs.getString(5));
				   Contactst.setC_city(rs.getString(6));
				   Contactst.setC_remark(rs.getString(7));
				   Contactst.setC_Uid(rs.getInt(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return  Contactst;
	 }
	 
	 //************分页方法***************//
	//分页参数
		private int  Total ;
		private int  TPages ;
		private int  CPages;	
		/**
		 * @return the total
		 */
		public int getTotal() {
			return Total;
		}
		/**
		 * @param total the total to set
		 */
		public void setTotal(int total) {
			Total = total;
		}
		/**
		 * @return the tPages
		 */
		public int getTPages() {
			return TPages;
		}
		/**
		 * @param pages the tPages to set
		 */
		public void setTPages(int pages) {
			TPages = pages;
		}

		/**
		 * @return the cPages
		 */
		public int getCPages() {
			return CPages;
		}
		/**
		 * @param pages the cPages to set
		 */
		public void setCPages(int pages) {
			CPages = pages;
		}
		
	 // List  第一个参数是  分页数据的名次，第二个是分页数目
	 public List getList(int page,int MaxLine){	
		int   Offset =0;
		if(page<=1){
			page =1;
			Offset = 0;
		}else{
			Offset = (page -1) * MaxLine;
			//如果参数为2，页码就是2*条数 
		}		
		List list = new ArrayList();
		ResultSet rs = null;
		 Contact contacts = new Contact();
		 int Uid = contacts.getUid();		 
		sql = "select * from tb_Contacts";		
		try {
			rs = dao.getSumRows(" from tb_Contacts", sql, Offset, MaxLine);	
			this.Total = dao.getTotal();
			this.CPages = dao.getCPages();
			this.TPages = dao.getTPages();
			
			while(rs.next()){
				   Contact Contactst = new Contact();
				   Contactst.setC_id(rs.getInt(1));
				   Contactst.setC_name(rs.getString(2));
				   Contactst.setC_tel(rs.getString(3));
				   Contactst.setC_email(rs.getString(4));
				   Contactst.setC_job(rs.getString(5));
				   Contactst.setC_city(rs.getString(6));
				   Contactst.setC_remark(rs.getString(7));
				   Contactst.setC_Uid(rs.getInt(8));
				   
				   list.add(Contactst);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return  list;
	 }	 
	 
	
}
