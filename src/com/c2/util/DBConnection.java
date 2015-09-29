package com.c2.util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.c2.bean.Course;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DBConnection {
	
	/**
	 * ����������
	 */
	private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	
	/**
	 * ���ݿ������ַ���
	 */
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/coursemanagement";
	
	/**
	 * ���ݿ��û���
	 */
	private static final String USER_NAME = "root";
	
	/**
	 * ���ݿ�����
	 */
	private static final String PASSWORD = "";
	
	/**
	 * ���ݿ�������
	 */
	private static Connection conn;
	
	/**
	 * ���ݿ������
	 */
	private static Statement stmt;
	
	
	
	// ��������
	static{
		try {
			Class.forName(DRIVER_CLASS);
		} catch (Exception e) {
			System.out.println("������������");
			System.out.println(e.getMessage());
		}
	}
	
	// ȡ������
	private static Connection getConnection(){
		
		try {
			conn = (Connection) DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			System.out.println("ȡ�����Ӵ���");
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	
	public void ExecuteDel(String sql){
		
		try {
			stmt = (Statement) getConnection().createStatement();
		} catch (Exception e) {
			System.out.println("statementȡ�ô���");
			System.out.println(e.getMessage());
		}
		
		try {
			int rows = stmt.executeUpdate(sql);
			if(rows >= 1){
				System.out.println("�ɹ�ɾ��.....");
			} else {
				System.out.println("ɾ��ʧ��.....");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	public ArrayList<Course> getCourseList(String sql){
		
		ArrayList<Course> list = new ArrayList<Course>();
		
		// ȡ�����ݿ��������
		try {
			stmt = (Statement) getConnection().createStatement();
		} catch (Exception e) {
			System.out.println("statementȡ�ô���");
			System.out.println(e.getMessage());
			return null;
		}
		
		try {
			
			// ��ѯ���ݿ����,���ؼ�¼��(�����)
			ResultSet rs = stmt.executeQuery(sql);
			
			// ѭ����¼�����鿴ÿһ��ÿһ�еļ�¼
			while (rs.next()) {
				// ��һ�� sno
				
				
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
