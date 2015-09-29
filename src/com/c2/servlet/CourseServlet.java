package com.c2.servlet;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.ArrayList;  
 

import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

import com.c2.bean.Course;  
import com.c2.util.DBConnection;
 
  
public class CourseServlet extends HttpServlet {  
 
  
   public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
        this.doPost(request, response);  
    }  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
        DBConnection db = new DBConnection();  
         
        String sql = "select * from Course";  
          
        ArrayList<Course> list = db.getCourseList(sql);  
          
        request.setAttribute("list", list);  
        request.getRequestDispatcher("index.jsp").forward(request, response);  
    }  
        
  }  
