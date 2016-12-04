package com.personalinfo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.personalinfo.dto.Finance;
import com.personalinfo.dto.Memorandum;
import com.personalinfo.tools.*;


// tb_Memorandum
public class MemorandumDao {
	 DBcon     dba = new DBcon();
	 DataDAO   dao = new DataDAO();
	 String    sql = "";
	 
//	 M_id int(11) AI PK 
//	 M_theme varchar(50) 
//	 M_time datetime 
//	 M_place varchar(25) 
//	 M_event tinytext 
//	 M_status varchar(20) 
//	 Uid int(11)    	

	 // isNull
	 public boolean isNull(){		 
		    sql = "select * from tb_Memorandum ";
			return  dao.isExist(sql);
		 }	
	 
	 // add 
	 public int add(Memorandum Memorandum){	
		 
		 String M_theme = "";
		 String M_time = "";
		 String M_place = "";
		 String M_event = "";
		 String M_status = "";
		 int   Uid = 0;
		//转换成   str --> 'str' 格式
		 M_theme = dao.changSqlStr(Memorandum.getM_theme());
		 M_time = dao.changSqlStr(Memorandum.getM_time());
		 M_place = dao.changSqlStr(Memorandum.getM_place());
		 M_event = dao.changSqlStr(Memorandum.getM_event());
		 M_status = dao.changSqlStr(Memorandum.getM_status());
		 Uid = Memorandum.getUid();		 
		 sql = "insert into tb_Memorandum (M_theme,M_time,M_place,M_event,M_status,Uid) values ("+M_theme+","+M_time+","+M_place+","+M_event+","+M_status+","+Uid+")";
		 return  dao.executeUpdate(sql);
	 }	 
	 
	 // update 
	 public int update(Memorandum Memorandum){
		 int     M_id=0;
		 String M_theme = "";
		 String M_time = "";
		 String M_place = "";
		 String M_event = "";
		 String M_status = "";
		 int   Uid = 0;
		 
		//转换成   str --> 'str' 格式
		 M_id = Memorandum.getM_id();
		 M_theme = dao.changSqlStr(Memorandum.getM_theme());
		 M_time = dao.changSqlStr(Memorandum.getM_time());
		 M_place = dao.changSqlStr(Memorandum.getM_place());
		 M_event = dao.changSqlStr(Memorandum.getM_event());
		 M_status = dao.changSqlStr(Memorandum.getM_status());
//		 Uid = Memorandum.getUid();
//		 sql = "update tb_Memorandum set M_theme="+M_theme+"M_time"+M_time+"M_place"+M_place+"M_event"+M_event+"M_status"+M_status+"where M_id = "+M_id;
		 sql = "update tb_Memorandum set M_theme = "+M_theme+",M_time ="+M_time+",M_place ="+M_place+",M_event ="+M_event+",M_status ="+M_status+"where M_id ="+M_id;
		 return  dao.executeUpdate(sql);
	 }	
	 
	 // delete
	 public int delete(int  M_id){
		 sql = "delete from  tb_Memorandum where M_id = "+M_id;
		 return  dao.executeUpdate(sql);
	 }	 
	 
	 // List  
	 public List getList(){		 
		List list = new ArrayList();
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;
		sql = "select * from tb_Memorandum ";		
		try {
			conn = dba.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Memorandum Memorandum = new Memorandum();
				Memorandum.setM_id(rs.getInt(1));
				Memorandum.setM_theme(rs.getString(2));
				Memorandum.setM_time(rs.getString(3));
				Memorandum.setM_place(rs.getString(4));
				Memorandum.setM_event(rs.getString(5));
				Memorandum.setM_status(rs.getString(6));
				Memorandum.setUid(rs.getInt(7));
			
				list.add(Memorandum);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return  list;
	 }	 
	 
	 // Memorandum  
	 public Memorandum  getMemorandum(String M_id ){
		Memorandum Memorandum = new Memorandum();
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;
		sql = "select * from tb_Memorandum where M_id =" + M_id;		
		try {
			conn = dba.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				Memorandum.setM_id(rs.getInt(1));
				Memorandum.setM_theme(rs.getString(2));
				Memorandum.setM_time(rs.getString(3));
				Memorandum.setM_place(rs.getString(4));
				Memorandum.setM_event(rs.getString(5));
				Memorandum.setM_status(rs.getString(6));
				Memorandum.setUid(rs.getInt(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return  Memorandum;
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
		sql = "select * from tb_Memorandum";		
		try {
			rs = dao.getSumRows(" from tb_Memorandum", sql, Offset, MaxLine);	
			this.Total = dao.getTotal();
			this.CPages = dao.getCPages();
			this.TPages = dao.getTPages();
			
			while(rs.next()){
				Memorandum Memorandum = new Memorandum();
				Memorandum.setM_id(rs.getInt(1));
				Memorandum.setM_theme(rs.getString(2));
				Memorandum.setM_time(rs.getString(3));
				Memorandum.setM_place(rs.getString(4));
				Memorandum.setM_event(rs.getString(5));
				Memorandum.setM_status(rs.getString(6));
				Memorandum.setUid(rs.getInt(7));
			
				list.add(Memorandum);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return  list;
	 }	
	 
}
