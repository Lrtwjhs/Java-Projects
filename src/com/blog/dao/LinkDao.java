package com.blog.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.blog.dto.Link;
import com.blog.tools.*;
//table  links
public class LinkDao {
	 DBcon     dba = new DBcon();
	 DataDAO   dao = new DataDAO();
	 String    sql = "";	 
	 // isNull
	 public boolean isNull(){		 
		    sql = "select * from links ";
			return  dao.isExist(sql);
		 }	 
	 // add 
	 public int add(Link link){		 
		 String  name = "";
		 String  url = "";
		 int     blogid = 0;
		 //转换成   str --> 'str' 格式
		 name = dao.changSqlStr(link.getName());
		 url = dao.changSqlStr(link.getUrl());
		 blogid = link.getBlogid();		 
		 sql = "insert into links (name,url,blogid) values ("+name+","+url+","+blogid+")";
		 return  dao.executeUpdate(sql);
	 }	 
	 // update 
	 public int update(Link link){		 
		 String  name = "";
		 String  url = "";
		 int     id=0;
		 //转换成   str --> 'str' 格式
		 name = dao.changSqlStr(link.getName());
		 url = dao.changSqlStr(link.getUrl());
		 id = link.getId();
		 sql = "update links set name="+name+",url=" +url+ "  where id = "+id;
		 return  dao.executeUpdate(sql);
	 }	 
	 // delete 
	 public int delete(int id){		
		 sql = "delete from links  where id = "+id;
		 return  dao.executeUpdate(sql);
	 }
	 // List  
	 public List getList(){		 
		List list = new ArrayList();
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;
		sql = "select id,name,url,blogid from links  limit 10";		
		try {
			conn = dba.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Link link = new Link();
				link.setId(rs.getInt(1));
				link.setName(rs.getString(2));
				link.setUrl(rs.getString(3));
				link.setBlogid(rs.getInt(4));
			
				list.add(link);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return  list;
	 }	 
	 // Link  
	 public Link  getLink(String  id){
		Link link = new Link();
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;
		sql = "select id,name,url,blogid from links where id = " +id;		
		try {
			conn = dba.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				link.setId(rs.getInt(1));
				link.setName(rs.getString(2));
				link.setUrl(rs.getString(3));
				link.setBlogid(rs.getInt(4));
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
		sql = "select id,name,url,blogid from links";		
		try {
			rs = dao.getSumRows(" from links", sql, Offset, MaxLine);	
			this.Total = dao.getTotal();
			this.CPages = dao.getCPages();
			this.TPages = dao.getTPages();
			
			while(rs.next()){
				Link link = new Link();
				link.setId(rs.getInt(1));
				link.setName(rs.getString(2));
				link.setUrl(rs.getString(3));
				link.setBlogid(rs.getInt(4));
			
				list.add(link);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return  list;
	 }	 
	 
}
