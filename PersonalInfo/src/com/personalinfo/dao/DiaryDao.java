package com.personalinfo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.personalinfo.dto.Diary;
import com.personalinfo.dto.Memorandum;
import com.personalinfo.tools.*;

//tb_Diary
public class DiaryDao {
	 DBcon     dba = new DBcon();
	 DataDAO   dao = new DataDAO();
	 String    sql = "";
	 
	 // isNull
	 public boolean isNull(){		 
		    sql = "select * from  tb_Diary ";
			return  dao.isExist(sql);
		 }
	 
	 // add 
	 public int add(Diary diary){		 
			String  D_time = "";
			String  D_weather = "";
			String  D_week = "";
			String D_event = "";
			 int     Uid= 0;
		 
			 //转换成   str --> 'str' 格式
			 D_time = dao.changSqlStr(diary.getD_time());
			 D_weather = dao.changSqlStr(diary.getD_weather());
			 D_week = dao.changSqlStr(diary.getD_week());
			 D_event = dao.changSqlStr(diary.getD_event());
			 Uid = diary.getUid();	
		 sql = "insert into  tb_Diary (D_time,D_weather,D_week,D_event,Uid) values ("+D_time+","+D_weather+","+D_week+","+D_event+","+Uid+")";
		 return  dao.executeUpdate(sql);
	 }	
	 
	 // update 
	 public int update(Diary diary){	
		     int D_id = 0;
			String  D_time = "";
			String  D_weather = "";
			String  D_week = "";
			String  D_event = "";
		 
			//转换成   str --> 'str' 格式
			 D_id = diary.getD_id();
			 D_time = dao.changSqlStr(diary.getD_time());
			 D_weather = dao.changSqlStr(diary.getD_weather());
			 D_week = dao.changSqlStr(diary.getD_week());
			 D_event = dao.changSqlStr(diary.getD_event());
		 sql = "update tb_Diary set D_time="+D_time+",D_weather="+D_weather
		     +",D_week="+D_week+ ",D_event=" + D_event + "where D_id =" + D_id;
		 return  dao.executeUpdate(sql);
	 }	
	 
	// delete 
	 public int delete(int D_id){		 
		 sql = "delete from tb_Diary where D_id ="+D_id;
		 return  dao.executeUpdate(sql);
	 }
	 
	 // List  
	 public List getList(){		 
		List list = new ArrayList();
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;
		sql = "select *  from  tb_Diary";		
		try {
			conn = dba.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Diary diary = new Diary();
				diary.setD_id(rs.getInt(1));
				diary.setD_time(rs.getString(2));
				diary.setD_weather(rs.getString(3));
				diary.setD_week(rs.getString(4));
				diary.setD_event(rs.getString(5));
				diary.setUid(rs.getInt(6));
			
				list.add(diary);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return  list;
	 }
	 
	 // diary  
	 public Diary  getDiary(String  D_id){
		Diary diary = new Diary();
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;
		sql = "select *  from tb_Diary where D_id = " + D_id;
		
		try {
			conn = dba.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				diary.setD_id(rs.getInt(1));
				diary.setD_time(rs.getString(2));
				diary.setD_weather(rs.getString(3));
				diary.setD_week(rs.getString(4));
				diary.setD_event(rs.getString(5));
				diary.setUid(rs.getInt(6));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return  diary;
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
		sql = "select * from tb_Diary ";		
		try {
			rs = dao.getSumRows(" from tb_Diary", sql, Offset, MaxLine);	
			this.Total = dao.getTotal();
			this.CPages = dao.getCPages();
			this.TPages = dao.getTPages();
			
			while(rs.next()){
				Diary diary = new Diary();
				diary.setD_id(rs.getInt(1));
				diary.setD_time(rs.getString(2));
				diary.setD_weather(rs.getString(3));
				diary.setD_week(rs.getString(4));
				diary.setD_event(rs.getString(5));
				diary.setUid(rs.getInt(6));
			
				list.add(diary);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return  list;
	 }	
	
}
