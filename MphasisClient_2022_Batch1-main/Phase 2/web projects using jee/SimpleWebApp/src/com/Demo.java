package com;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.PreparableStatement;
/**
 * Servlet implementation class Demo
 */
public class Demo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Demo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.println("Welcome to WEb Application");		// this output display on server console.
		String emailid = request.getParameter("emailid");
		String password = request.getParameter("password");
		//JDBC code to check emailid and passwrod check from database. 
		PrintWriter pw = response.getWriter();	
//		if(name.equals("Raj") && pass.equals("123")) {
//			pw.println("Successfully login");
//		}else {
//			pw.println("Failure try once again");
//		}
		response.setContentType("text/html");
		RequestDispatcher rd1 = request.getRequestDispatcher("Home");	// target is servlet page 
		RequestDispatcher rd2 = request.getRequestDispatcher("index.html");  // target is html page 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database", "root", "root@123");
	PreparedStatement pstmt = con.prepareStatement("select * from login where emailid = ? and password = ?");
	pstmt.setString(1, emailid);
	pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			pw.println("Successfully login");
			rd1.forward(request, response);				// we can see only output of target page.
		}else {
			pw.println("Invalid email id or password");
				rd2.include(request, response);				// source error msg + index page display as one page. 
		}
		}catch (Exception e) {
			pw.println(e);
		}
		//pw.println("Welcome Client to WEb Application"+name);		// this output display on client brower 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher rd2 = request.getRequestDispatcher("index.html");  // target is html page 
		String emailid = request.getParameter("emailid");
				String password = request.getParameter("password");
				try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database", "root", "root@123");
			PreparedStatement pstmt = con.prepareStatement("insert into login values(?,?)");
			pstmt.setString(1, emailid);
			pstmt.setString(2, password);
				int res = pstmt.executeUpdate();
				if(res>0) {
					pw.println("Account created successfully");
						rd2.include(request, response);
				}
				}catch (Exception e) {
					pw.println(e.getMessage());
						rd2.include(request, response);
				}
	}

}
