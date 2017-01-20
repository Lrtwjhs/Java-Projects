package com.blog.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.blog.dto.User;
import com.blog.tools.*;
//blog
public class UserDao {
	 DBcon     dba = new DBcon();
	 DataDAO   dao = new DataDAO();
	 String    sql = "";
	 
	 // Invalidate 
	 public int  isUser(String username,String password){		 
		    sql = "select id from blog  where username= '"+username
		        + "' and password ='"+password+"'";
		    
		    int        flag = 0;//默认为false		
			Connection conn = null;
			Statement  stmt = null;
			ResultSet  rs = null;			
			try {
				conn = dba.getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				if(rs.next())flag =rs.getInt(1);
			} catch (SQLException e) {
				System.out.println("DataDAO--isExist()"+e.getMessage());
			}finally{
				DBcon.close(conn,null,stmt,rs);
			}
			return flag;
		 }
	 
	 // add 
	 public int add(User link){		 
		 String  username = "";
		 String  password = "";
		 String  subject = "";
		 String  email = "";		
		 String  image = "";
		 int     visitcount = 0;

		 username = dao.changSqlStr(link.getUsername());
		 password = dao.changSqlStr(link.getPassword());
		 subject = dao.changSqlStr(link.getSubject());
		 email = dao.changSqlStr(link.getEmail());
		 image = dao.changSqlStr(link.getImage());
		 visitcount = link.getVisitcount();	 
		 sql = "insert into  blog (username,password,subject,email,image,visitcount) values ("
			 + username + ","+password+","+ subject + ","+email+","+image+","+visitcount+")";
		 return  dao.executeUpdate(sql);
	 }	 
	 // update 
	 public int update(User link){		 
		 String  username = "";
		 String  password = "";
		 String  subject = "";
		 String  email = "";		
		// String  image = "";
		// int     visitcount = 0;
		 int     id = 0;

		 username = dao.changSqlStr(link.getUsername());
		 password = dao.changSqlStr(link.getPassword());
		 subject = dao.changSqlStr(link.getSubject());
		 email = dao.changSqlStr(link.getEmail());
		// image = dao.changSqlStr(link.getImage());
		// visitcount = link.getVisitcount();
		 id = link.getId();
		 sql = "update blog set username="+username+",password="+password
		     +",subject="+subject+",email="+email+"  where id = "+id;
		 return  dao.executeUpdate(sql);
	 }
	 
	// update logo  更新logo
	 public int updateLogo(String image,String id){ 
		 sql = "update blog set image='"+image+"' where id = "+id;
		 return  dao.executeUpdate(sql);
	 }
	 
	 // updateVister 
	 public int updateVisiter(int id){
		 sql = "update blog set visitcount += 1 where id = "+id;
		 return  dao.executeUpdate(sql);
	 }
	 
	 // delete 
	 public int delete(int id){
		 sql = "delete from  blog  id = "+id;
		 return  dao.executeUpdate(sql);
	 }
	 
	 // List  
	 public List getList(){		 
		List list = new ArrayList();
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;
		sql = "select id,username,password,subject,email,image,visitcount from blog";
		
		try {
			conn = dba.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				User link = new User();
				link.setId(rs.getInt(1));
                link.setUsername(rs.getString(2));
                link.setPassword(rs.getString(3));
                link.setSubject(rs.getString(4));
                link.setEmail(rs.getString(5));
                link.setImage(rs.getString(6));
                link.setVisitcount(rs.getInt(7));
				
				list.add(link);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return  list;
	 }
	 
	 // Link  
	 public User  getLink(String  id){
		 User link = new User();
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;
		sql = "select id,name,url,blogid from blog where id = " +id;
		
		try {
			conn = dba.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				link.setId(rs.getInt(1));
                link.setUsername(rs.getString(2));
                link.setPassword(rs.getString(3));
                link.setSubject(rs.getString(4));
                link.setEmail(rs.getString(5));
                link.setImage(rs.getString(6));
                link.setVisitcount(rs.getInt(7));
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
				sql = "select id,username,password,subject,email,image,visitcount from blog";
				
				try {
					rs = dao.getSumRows(" from blog", sql, Offset, MaxLine);	
					this.Total = dao.getTotal();
					this.CPages = dao.getCPages();
					this.TPages = dao.getTPages();
					
					while(rs.next()){
						User link = new User();
						link.setId(rs.getInt(1));
		                link.setUsername(rs.getString(2));
		                link.setPassword(rs.getString(3));
		                link.setSubject(rs.getString(4));
		                link.setEmail(rs.getString(5));
		                link.setImage(rs.getString(6));
		                link.setVisitcount(rs.getInt(7));
						
						list.add(link);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    return  list;
			 }
}
