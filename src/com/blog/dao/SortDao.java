package com.blog.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.blog.dto.Sort;
import com.blog.tools.*;
// table  sort
public class SortDao {
	 DBcon     dba = new DBcon();
	 DataDAO   dao = new DataDAO();
	 String    sql = "";
	 
//		编号  	    id		    int      	 
//		名称	        name		VARCHAR (40) 	
//		用户编号    	blogid		int     	

	 // isNull
	 public boolean isNull(){		 
		    sql = "select * from sort ";
			return  dao.isExist(sql);
		 }	 
	 // add 
	 public int add(Sort Sort){		 
		 String  name = "";
		 int     blogid = 0;
		 //转换成   str --> 'str' 格式
		 name = dao.changSqlStr(Sort.getName());
		 blogid = Sort.getBlogid();		 
		 sql = "insert into  sort (name,blogid) values ("+name+","+blogid+")";
		 return  dao.executeUpdate(sql);
	 }	 
	 // update 
	 public int update(Sort Sort){		 
		 String  name = "";
		 int     id=0;
		 //转换成   str --> 'str' 格式
		 name = dao.changSqlStr(Sort.getName());
		 id = Sort.getId();
		 sql = "update sort set name="+name+"  where id = "+id;
		 return  dao.executeUpdate(sql);
	 }	 
	 // delete
	 public int delete(int  id){
		 sql = "delete from  sort where id = "+id;
		 return  dao.executeUpdate(sql);
	 }	 
	 // List  
	 public List getList(){		 
		List list = new ArrayList();
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;
		sql = "select id,name,blogid from sort";		
		try {
			conn = dba.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Sort Sort = new Sort();
				Sort.setId(rs.getInt(1));
				Sort.setName(rs.getString(2));
				Sort.setBlogid(rs.getInt(3));
			
				list.add(Sort);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return  list;
	 }	 
	 // List  
	 public List getIndexList(){		 
		List list = new ArrayList();
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;
		sql = "select  s.id,s.name,s.blogid,count(*) as c  from "
			+ " article a,sort s where a.sortid = s.id  group by a.sortid;";		
		try {
			conn = dba.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Sort Sort = new Sort();
				Sort.setId(rs.getInt(1));
				Sort.setName(rs.getString(2));
				Sort.setBlogid(rs.getInt(3));
			    Sort.setCount(rs.getString(4));
			    
				list.add(Sort);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return  list;
	 }	 
	 // Sort  
	 public Sort  getSort(String  id){
		Sort Sort = new Sort();
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;
		sql = "select id,name,blogid from sort where id = " +id;		
		try {
			conn = dba.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				Sort.setId(rs.getInt(1));
				Sort.setName(rs.getString(2));
				Sort.setBlogid(rs.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return  Sort;
	 }
	 
}
