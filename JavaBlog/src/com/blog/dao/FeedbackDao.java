package com.blog.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.blog.dto.Feedback;
import com.blog.tools.*;
//table  feedback 
public class FeedbackDao {
	 DBcon     dba = new DBcon();
	 DataDAO   dao = new DataDAO();
	 String    sql = "";	 
	 // isNull
	 public boolean isNull(){		 
		    sql = "select * from feedback ";
			return  dao.isExist(sql);
		 }
	 // delete
	 public int delete(int id){		 
		    sql = "delete from  feedback  where id ="+id;
			return  dao.executeUpdate(sql);
		 }
	 // add 
	 public int add(Feedback link){		 
		 String  uname = "";
		 String  ip = "";
		 String  content = "";
		 String  pubtime = "";
		 int     articleid = 0;
		 
		 uname = dao.changSqlStr(link.getUname());
		 ip = dao.changSqlStr(link.getIp());
		 content = dao.changSqlStr(link.getContent());
		 pubtime = dao.changSqlStr(link.getPubtime());
		 articleid = link.getArticleid();		 
		 sql = "insert into  feedback (uname,IP,content,pubtime,articleid) values ("+uname
		     +","+ip+","+content+","+pubtime+","+articleid+")";
		 return  dao.executeUpdate(sql);
	 }
	 // List  
	 public List getList(String  articleid){		 
		List list = new ArrayList();
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;
		sql = "select id,uname,IP,content,pubtime,articleid from feedback where articleid=" + articleid;		
		try {
			conn = dba.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Feedback link = new Feedback();
			    link.setId(rs.getInt(1));
			    link.setUname(rs.getString(2));
			    link.setIp(rs.getString(3));
			    link.setContent(rs.getString(4));
			    link.setPubtime(rs.getString(5));
			    link.setArticleid(rs.getInt(6));			    
				list.add(link);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return  list;
	 }	 
	 // Feedback  
	 public Feedback  getLink(String  id){
		Feedback link = new Feedback();
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;
		sql = "select id,uname,IP,content,pubtime,articleid where id = " +id;		
		try {
			conn = dba.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				    link.setId(rs.getInt(1));
				    link.setUname(rs.getString(2));
				    link.setIp(rs.getString(3));
				    link.setContent(rs.getString(4));
				    link.setPubtime(rs.getString(5));
				    link.setArticleid(rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return  link;
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
			
			 // List  
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
				sql = "select id,uname,IP,content,pubtime,articleid from feedback";		
				try {
					rs = dao.getSumRows(" from feedback", sql, Offset, MaxLine);	
					this.Total = dao.getTotal();
					this.CPages = dao.getCPages();
					this.TPages = dao.getTPages();
					
					while(rs.next()){
						Feedback link = new Feedback();
					    link.setId(rs.getInt(1));
					    link.setUname(rs.getString(2));
					    link.setIp(rs.getString(3));
					    link.setContent(rs.getString(4));
					    link.setPubtime(rs.getString(5));
					    link.setArticleid(rs.getInt(6));			    
						list.add(link);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    return  list;
			 }	
		 
}
