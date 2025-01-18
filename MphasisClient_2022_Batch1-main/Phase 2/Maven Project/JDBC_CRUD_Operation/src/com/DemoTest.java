package com;
import java.sql.*;
import java.util.Scanner;

public class DemoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded successfully");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database", "root", "root@123");
		System.out.println("Database connected...");
		
		Scanner sc = new Scanner(System.in);
		//Statement stmt = con.createStatement();
//		PreparedStatement pstmt = con.prepareStatement("insert into employee values(?,?,?)");
//		System.out.println("Enter the id");
//		int id = sc.nextInt();
//		pstmt.setInt(1, id);
//		System.out.println("Enter the name");
//		String name = sc.next();
			//String name = sc.nextLine();		// Raj Deep 
			//sc.nextLine()			// to hold enter key 
//		pstmt.setString(2, name);
//		System.out.println("Enter the salary");
//		float salary = sc.nextFloat();
//		pstmt.setFloat(3, salary);
//		int res = pstmt.executeUpdate();
//		if(res>0) {
//			System.out.println("Record inserted successfully.");
//		}
		//Insert Query 
//		int res = stmt.executeUpdate("insert into employee values(5,'Mahesh',28000)");
//		if(res>0) {
//			System.out.println("Record inserted successfully");
//		}
		
//		// Delete Query 
//		int res = stmt.executeUpdate("delete from employee where id = 5");
//		if(res>0) {
//			System.out.println("Record deleted successfully");
//		}else {
//			System.out.println("Record not present");
//		}
		
//		PreparedStatement pstmt = con.prepareStatement("delete from employee where id = ?");
//		System.out.println("Enter the id to delete the record");
//		int id = sc.nextInt();
//		pstmt.setInt(1, id);
//		int res = pstmt.executeUpdate();
//		if(res>0) {
//			System.out.println("Record deleted successfully");
//		}else {
//			System.out.println("Record not present");
//		}
		
		// updatet Query 
//		int res = stmt.executeUpdate("update employee set salary = 35000 where id = 1");
//		if(res>0) {
//			System.out.println("Record updated successfully");
//		}else {
//			System.out.println("Record not present");
//		}
//		PreparedStatement pstmt = con.prepareStatement("update employee set salary = ? where id = ?");
//		System.out.println("Enter the id to update the record");
//		int id = sc.nextInt();
//		System.out.println("Enter the salary to update");
//		float salary = sc.nextFloat();
//		pstmt.setFloat(1, salary);
//		pstmt.setInt(2, id);
//		int res = pstmt.executeUpdate();
//		if(res>0) {
//			System.out.println("Record updated successfully");
//		}else {
//			System.out.println("Record not present");
//		}
		
		// Retrieve Query 
		
//		ResultSet rs = stmt.executeQuery("select * from employee");
//		while(rs.next()) {
//			//System.out.println("id is "+rs.getInt("id")+" Name is "+rs.getString("name")+" Salary is "+rs.getFloat("salary"));
//			System.out.println("id is "+rs.getInt(1)+" Name is "+rs.getString(2)+" Salary is "+rs.getFloat(3));
//		}
		
		PreparedStatement pstmt = con.prepareStatement("select * from employee where id = ?");
		System.out.println("Enter the id");
		int id = sc.nextInt();
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			System.out.println("id is "+rs.getInt(1)+" Name is "+rs.getString(2)+" Salary is "+rs.getFloat(3));
		}else {
			System.out.println("Record not present");
		}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
