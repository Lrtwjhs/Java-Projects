package com.blog.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.blog.dto.Article;
import com.blog.tools.*;
//table  article
public class ArticleDao {
	 DBcon     dba = new DBcon();
	 DataDAO   dao = new DataDAO();
	 String    sql = "";	 
	 // isNull
	 public boolean isNull(){		 
		    sql = "select * from  article ";
			return  dao.isExist(sql);
		 }
	 // add 
	 public int add(Article article){		 
		 String  title = "";
		 String  content = "";
		 String  pubtime = "";
		 int     blogid = 0;
		 int     sortid = 0;
		 
		 //转换成   str --> 'str' 格式
		 title = dao.changSqlStr(article.getTitle());
		 content = dao.changSqlStr(article.getTitle());
		 pubtime = dao.changSqlStr(article.getPubtime());
		 blogid = article.getBlogid();	
		 sortid = article.getSortid();
		 sql = "insert into  article (title,content,pubtime,blogid,sortid) values ("+title+","+content+","+pubtime+","+blogid+","+sortid+")";
		 return  dao.executeUpdate(sql);
	 }	 
	 // update 
	 public int update(Article article){		 
		 String  title = "";
		 String  content = "";
		 String  pubtime = "";
		 int     sortid = 0;
		 int     id = 0;
		 
		 //转换成   str --> 'str' 格式
		 title = dao.changSqlStr(article.getTitle());
		 content = dao.changSqlStr(article.getContent());
		 pubtime = dao.changSqlStr(article.getPubtime());
		 id = article.getId();	
		 sortid = article.getSortid();
		 sql = "update article set title="+title+",content="+content
		     +",pubtime="+pubtime+",sortid="+sortid+"  where id ="+id;
		 return  dao.executeUpdate(sql);
	 }		
	// delete 
	 public int delete(int id){		 
		 sql = "delete from article   where id ="+id;
		 return  dao.executeUpdate(sql);
	 }
	 // List  
	 public List getList(){		 
		List list = new ArrayList();
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;
		sql = "select a.id,a.title,a.content,a.pubtime,a.blogid,a.sortid,s.name from  article a,sort s where a.sortid = s.id";		
		try {
			conn = dba.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Article article = new Article();
				article.setId(rs.getInt(1));
				article.setTitle(rs.getString(2));
				article.setContent(rs.getString(3));
				article.setPubtime(rs.getString(4));
				article.setBlogid(rs.getInt(5));
				article.setSortid(rs.getInt(6));
				article.setSort(rs.getString(7));
			
				list.add(article);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return  list;
	 }
	 
	 // article  
	 public Article  getArticle(String  id){
		Article article = new Article();
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;
		sql = "select a.id,a.title,a.content,a.pubtime,a.blogid,a.sortid,s.name from  article a,sort s where a.sortid = s.id and a.id = " +id;
		
		try {
			conn = dba.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				article.setId(rs.getInt(1));
				article.setTitle(rs.getString(2));
				article.setContent(rs.getString(3));
				article.setPubtime(rs.getString(4));
				article.setBlogid(rs.getInt(5));
				article.setSortid(rs.getInt(6));
				article.setSort(rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return  article;
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
				sql = "select a.id,a.title,a.content,a.pubtime,a.blogid,a.sortid,s.name from  article a,sort s where a.sortid = s.id";		
				try {
					rs = dao.getSumRows(" from article", sql, Offset, MaxLine);	
					this.Total = dao.getTotal();
					this.CPages = dao.getCPages();
					this.TPages = dao.getTPages();
					
					while(rs.next()){
						Article article = new Article();
						article.setId(rs.getInt(1));
						article.setTitle(rs.getString(2));
						article.setContent(rs.getString(3));
						article.setPubtime(rs.getString(4));
						article.setBlogid(rs.getInt(5));
						article.setSortid(rs.getInt(6));
					    article.setSort(rs.getString(7));
					    
						list.add(article);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    return  list;
		 }	
		
		// List  
		public List getList(String blogid,int page,int MaxLine){	
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
				sql = "select id,title,content,pubtime,blogid,sortid from article where blogid = "+blogid;		
				try {
					rs = dao.getSumRows(" from article where blogid = "+blogid, sql, Offset, MaxLine);	
					this.Total = dao.getTotal();
					this.CPages = dao.getCPages();
					this.TPages = dao.getTPages();
					
					while(rs.next()){
						Article article = new Article();
						article.setId(rs.getInt(1));
						article.setTitle(rs.getString(2));
						article.setContent(rs.getString(3));
						article.setPubtime(rs.getString(4));
						article.setBlogid(rs.getInt(5));
						article.setSortid(rs.getInt(6));
					
						list.add(article);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    return  list;
		 }	
		
		// List  
		public List getList(int page,int MaxLine,String sortid){	
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
				sql = "select a.id,a.title,a.content,a.pubtime,a.blogid,a.sortid,s.name from article a,sort s where a.sortid = s.id and  a.sortid = "+sortid;		
				try {
					rs = dao.getSumRows(" from article where sortid = "+sortid, sql, Offset, MaxLine);	
					this.Total = dao.getTotal();
					this.CPages = dao.getCPages();
					this.TPages = dao.getTPages();
					
					while(rs.next()){
						Article article = new Article();
						article.setId(rs.getInt(1));
						article.setTitle(rs.getString(2));
						article.setContent(rs.getString(3));
						article.setPubtime(rs.getString(4));
						article.setBlogid(rs.getInt(5));
						article.setSortid(rs.getInt(6));
						article.setSort(rs.getString(7));
					
						list.add(article);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    return  list;
		 }	
}
