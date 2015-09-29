package com.c2.util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.c2.bean.Course;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DBConnection {
	
	/**
	 * 驱动类名称
	 */
	private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	
	/**
	 * 数据库连接字符串
	 */
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/coursemanagement";
	
	/**
	 * 数据库用户名
	 */
	private static final String USER_NAME = "root";
	
	/**
	 * 数据库密码
	 */
	private static final String PASSWORD = "";
	
	/**
	 * 数据库连接类
	 */
	private static Connection conn;
	
	/**
	 * 数据库操作类
	 */
	private static Statement stmt;
	
	
	
	// 加载驱动
	static{
		try {
			Class.forName(DRIVER_CLASS);
		} catch (Exception e) {
			System.out.println("加载驱动错误");
			System.out.println(e.getMessage());
		}
	}
	
	// 取得连接
	private static Connection getConnection(){
		
		try {
			conn = (Connection) DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			System.out.println("取得连接错误");
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	
	public void ExecuteDel(String sql){
		
		try {
			stmt = (Statement) getConnection().createStatement();
		} catch (Exception e) {
			System.out.println("statement取得错误");
			System.out.println(e.getMessage());
		}
		
		try {
			int rows = stmt.executeUpdate(sql);
			if(rows >= 1){
				System.out.println("成功删除.....");
			} else {
				System.out.println("删除失败.....");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	public ArrayList<Course> getCourseList(String sql){
		
		ArrayList<Course> list = new ArrayList<Course>();
		
		// 取得数据库操作对象
		try {
			stmt = (Statement) getConnection().createStatement();
		} catch (Exception e) {
			System.out.println("statement取得错误");
			System.out.println(e.getMessage());
			return null;
		}
		
		try {
			
			// 查询数据库对象,返回记录集(结果集)
			ResultSet rs = stmt.executeQuery(sql);
			
			// 循环记录集，查看每一行每一列的记录
			while (rs.next()) {
				// 第一列 sno
				
				
				Course stu = new Course();
				int i=1;
				stu.setNianji(rs.getString(i++));
				stu.setZhuanye(rs.getString(i++));
				stu.setRenshu(rs.getString(i++));
				stu.setMingcheng(rs.getString(i++));
				stu.setLeixing(rs.getString(i++));
				stu.setXuefen(rs.getString(i++));
				stu.setXueshi(rs.getString(i++));
				stu.setShiyanxueshi(rs.getString(i++));
				stu.setShangjixueshi(rs.getString(i++));
				stu.setZhouxu(rs.getString(i++));
				stu.setJiaoshi(rs.getString(i++));
				stu.setBeizhu(rs.getString(i++));
				list.add(stu);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
}
