package com.blog.tools;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Properties;


/**
 * <p>
 * Title:数据链接类
 * </p>
 * <p>
 * Description:处理数据库的链接问题
 * </p>
 * <p>
 * Copyright: Copyright (c) 2009
 * </p>
 * <p>
 * Company: 9956
 * </p>
 * @author Lrtwjhs
 * @version 1.0
 */

public class DBcon {
	
	/**
	 * 从环境返回连接对象
	 * @return connection
	 * @throws SQLException
	 */

	// jdbc连接
	public synchronized Connection getConnection() {
		Connection conn = null;
		String connect = "";// 库名
		String user = ""; // 用户名
		String password = ""; // 密码
		String driver = "";

		// 读配置文件获得数据库连接参数
		InputStream is = getClass().getResourceAsStream("db.properties");
		Properties dbProps = new Properties();
		try {
			dbProps.load(is);

			driver = dbProps.getProperty("driver");
			connect = dbProps.getProperty("connection");
			user = dbProps.getProperty("user");
			password = dbProps.getProperty("password");
		} catch (IOException e) {
			// TODO 自动生成 catch 块
			System.out.println("DBCon():read db.properties error"
					+ e.getMessage());
		}

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(connect, user, password);
			return conn;
		} catch (Exception ex) {
			System.out.println("DBCon():Connection:" + ex.getMessage());
			conn = null;
			return null;
		}
	}
    public static void close(Connection conn,PreparedStatement pstm,Statement st,ResultSet rs){
    	try{
    		if(conn != null)	conn.close();
    		if(pstm != null)	pstm.close();
    		if(st != null)	  st.close();
    		if(rs != null)    rs.close();
    		
    	}catch(Exception e){
    		System.out.println("DBcon() close()"+e.getMessage());
    	}
    }

}
