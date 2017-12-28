package com.zou.utils;

import java.io.InputStream;
import java.sql.*;

import java.util.Properties;

public class DBUtils {
	private static String driver = null;
	private static String url = null;
	private static String password = null;
	private static String user = null;
	
	//加载驱动
	static{
		InputStream in = DBUtils.class.getClassLoader().getResourceAsStream("db.properties");
		Properties prop = new Properties();
		try {
			prop.load(in);
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			password = prop.getProperty("password");
			user = prop.getProperty("user");
			
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//创建连接
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//释放资源
	
	public static void release(ResultSet rs,Statement sm, Connection con){
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs=null;
		}
		if (sm!=null) {
			try {
				sm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void release(ResultSet rs,PreparedStatement psm, Connection con){
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs=null;
		}
		if (psm!=null) {
			try {
				psm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void release(PreparedStatement psm, Connection con) {
		if (psm!=null) {
			try {
				psm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}


}
