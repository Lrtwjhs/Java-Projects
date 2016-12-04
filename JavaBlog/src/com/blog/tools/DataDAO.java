package com.blog.tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataDAO {	
	
	 DBcon   dba = new DBcon();	
	//判断是否有数据存在
	public boolean  isExist(String select_sql){	
		boolean     flag = false;//默认为false		
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs = null;			
		try {
			conn = dba.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(select_sql);
			
			if(rs.next())flag =true;
		} catch (SQLException e) {
			System.out.println("DataDAO--isExist()"+e.getMessage());
		}finally{
			DBcon.close(conn,null,stmt,rs);
		}
		return flag;
	}
	
	//删除和更新操作
	public  int  executeUpdate(String update_sql){	
		int        flag = 0;//默认为false		
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs = null;			
		try {
			conn = dba.getConnection();
			stmt = conn.createStatement();
			flag = stmt.executeUpdate(update_sql);
		} catch (SQLException e) {
			System.out.println("DataDAO-- executeUpdate()"+e.getMessage());
		}finally{
			DBcon.close(conn,null,stmt,rs);
		}
		return flag;
	}
	
	//字符串处理
	public String changSqlStr(String str){
		String sqlstr = "";
		if(str!=null||str!=""){
			sqlstr="'"+str+"'";
		}
		return sqlstr;
	}
	
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
	
	public ResultSet  getSumRows(String fwsql,String QuerySql,int Offset,int MaxLine){			
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs = null;	
		String     SQL =  "SELECT Count(*) AS total " + fwsql;
		 // System.out.println("----1----"+SQL);
		try {
			conn = dba.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			
			if(rs.next()) this.Total = rs.getInt(1); //获取总记录数				
			 // 设置当前页数和总页数
		    this.TPages = (int)Math.ceil((double)this.Total/MaxLine); 
		    this.CPages = (int)Math.floor((double)Offset/MaxLine+1); 
		    // 根据条件判断，取出所需记录
		    if (this.Total > 0) { 
		      SQL = QuerySql + " LIMIT " + Offset + " , " + MaxLine; 
		    //  System.out.println("----2----"+SQL);
		      rs = stmt.executeQuery(SQL);     
		    }    
		} catch (SQLException e) {
			System.out.println("DataDAO--getSumRows()"+e.getMessage());
		}
		return rs;
	}
	
	
}
