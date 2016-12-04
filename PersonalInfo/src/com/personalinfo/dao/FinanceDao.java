package com.personalinfo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.personalinfo.dto.Finance;
import com.personalinfo.tools.*;


//tb_Finance
public class FinanceDao {
	 DBcon     dba = new DBcon();
	 DataDAO   dao = new DataDAO();
	 String    sql = "";
	 
	 
//	 F_id int(11) AI PK 
//	 F_time datetime 
//	 F_ievent varchar(20) 
//	 F_pevent varchar(20) 
//	 F_income decimal(9,2) 
//	 F_pay decimal(9,2) 
//	 F_remamoney decimal(18,2) 
//	 Uid int(11)

	 
	 
	 // isNull
	 public boolean isNull(){		 
		    sql = "select * from tb_Finance";
			return  dao.isExist(sql);
		 }	 
	 
	 // add 
	 public int add(Finance Finance){		 
		 String  F_time = "";
		 String F_ievent = "";
		 String F_pevent = "";
		 String F_income = "";
		 String F_pay = "";
		 String F_remamoney = "";
		 int  Uid = 0;
		//转换成   str --> 'str' 格式
		 F_time = dao.changSqlStr(Finance.getF_time());
		 F_ievent = dao.changSqlStr(Finance.getF_ievent());
		 F_pevent = dao.changSqlStr(Finance.getF_pevent());
		 F_income = dao.changSqlStr(Finance.getF_income());
		 F_pay = dao.changSqlStr(Finance.getF_pay());
		 F_remamoney = dao.changSqlStr(Finance.getF_remamoney());
		 Uid = Finance.getUid();		 
		 sql = "insert into tb_Finance (F_time,F_ievent,F_pevent,F_income,F_pay,F_remamoney,Uid) values ("+F_time+","+F_ievent+","+F_pevent+","+F_income+","+F_pay+","+F_remamoney+","+Uid+")";
		 return  dao.executeUpdate(sql);
	 }	 
	 
	 // update 
	 public int update(Finance Finance){		 
		 String  F_time = "";
		 String F_ievent = "";
		 String F_pevent = "";
		 String F_income = "";
		 String F_pay = "";
		 String F_remamoney = "";
		 int     F_id=0;
		 
		//转换成   str --> 'str' 格式
		 F_time = dao.changSqlStr(Finance.getF_time());
		 F_ievent = dao.changSqlStr(Finance.getF_ievent());
		 F_pevent = dao.changSqlStr(Finance.getF_pevent());
		 F_income = dao.changSqlStr(Finance.getF_income());
		 F_pay = dao.changSqlStr(Finance.getF_pay());;
		 F_remamoney = dao.changSqlStr(Finance.getF_remamoney());
		 F_id = Finance.getF_id();
		 sql = "update tb_Finance set F_time="+F_time+",F_ievent=" +F_ievent+",F_pevent=" +F_pevent+",F_income=" +F_income+",F_pay=" +F_pay+",F_remamoney=" +F_remamoney+ " where F_id = "+F_id;
		 return  dao.executeUpdate(sql);
	 }	
	 
	 // delete 
	 public int delete(int F_id){		
		 sql = "delete from tb_Finance  where F_id = "+F_id;
		 return  dao.executeUpdate(sql);
	 }
	 
	 // List  
	 public List getList(){		 
		List list = new ArrayList();
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;
		sql = "select * from tb_Finance";		
		try {
			conn = dba.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Finance Finance = new Finance();
				Finance.setF_id(rs.getInt(1));
				Finance.setF_time(rs.getString(2));
				Finance.setF_ievent(rs.getString(3));
				Finance.setF_income(rs.getString(4));
				Finance.setF_pevent(rs.getString(5));				
				Finance.setF_pay(rs.getString(6));
				Finance.setF_remamoney(rs.getString(7));
				Finance.setUid(rs.getInt(8));
			
				list.add(Finance);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return  list;
	 }	 
	 
	 // Finance  
	 public Finance getFinance(String F_id ){
		Finance Finance = new Finance();
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;
		sql = "select * from tb_Finance where F_id =" + F_id;		
		try {
			conn = dba.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				Finance.setF_id(rs.getInt(1));
				Finance.setF_time(rs.getString(2));
				Finance.setF_ievent(rs.getString(3));
				Finance.setF_income(rs.getString(4));
				Finance.setF_pevent(rs.getString(5));				
				Finance.setF_pay(rs.getString(6));
				Finance.setF_remamoney(rs.getString(7));
				Finance.setUid(rs.getInt(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return  Finance;
	 }
	 
	 //************��ҳ����***************//
	//��ҳ����
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
		
	 // List  ��һ��������  ��ҳ��ݵ���Σ��ڶ����Ƿ�ҳ��Ŀ
	 public List getList(int page,int MaxLine){	
		int   Offset =0;
		if(page<=1){
			page =1;
			Offset = 0;
		}else{
			Offset = (page -1) * MaxLine;
			//������Ϊ2��ҳ�����2*���� 
		}		
		List list = new ArrayList();
		ResultSet rs = null;
		sql = "select * from tb_Finance";		
		try {
			rs = dao.getSumRows(" from tb_Finance", sql, Offset, MaxLine);	
			this.Total = dao.getTotal();
			this.CPages = dao.getCPages();
			this.TPages = dao.getTPages();
			
			while(rs.next()){
				Finance Finance = new Finance();
				Finance.setF_id(rs.getInt(1));
				Finance.setF_time(rs.getString(2));
				Finance.setF_ievent(rs.getString(3));
				Finance.setF_income(rs.getString(4));
				Finance.setF_pevent(rs.getString(5));				
				Finance.setF_pay(rs.getString(6));
				Finance.setF_remamoney(rs.getString(7));
				Finance.setUid(rs.getInt(8));
			
			
				list.add(Finance);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return  list;
	 }	 
	 
}
