package com.jspider.Crud_Operation_Using_Statement.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

import com.jspider.Crud_Operation_Using_Statement.connection.EmployeeConnection;

public class EmployeeController {
	public static void main(String[] args) {
		EmployeeConnection ec=new EmployeeConnection();
		Connection conn=EmployeeConnection.getEmployeeConnection();
	
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.println("enter your choice: \n1. Enter User Data \n2. Delete employee record by id \n3. Update Employee record \n4. Display all employees" );
			int ch=sc.nextInt();
			switch(ch) {
			case 1:try {
				Statement st=conn.createStatement();
				
				int res=st.executeUpdate("insert into employee(id,name,email, dob, doj) values(101,'suman','suman@gmail.com','1991-08-09','2024-12-12')");
				if(res!=0)
					System.err.println(res+" record inserted");
				else
					System.err.println("insertion failed");
			} catch (SQLException e) {
				
				e.printStackTrace();
			
			}
			break;
			
			case 2: try {
					Statement st=conn.createStatement();
					int res=st.executeUpdate("delete from employee where id=102");
					if(res>0)
						System.err.println("record successfully deleted");
					else
						System.err.println("deletion failed");
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			break;
			case 3:try {
					Statement st=conn.createStatement();
					int res=st.executeUpdate("update employee set dob='2000-10-24'where id=102");
					if(res>0)
						System.err.println("record updated successfully");
					else
						System.err.println("updation failed");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			break;
			case 4:				
				try {
					Statement st=conn.createStatement();
					ResultSet set=st.executeQuery("select * from employee");
					while(set.next()) {
						int id=set.getInt("id");
						String name=set.getString("name");
						String email=set.getString("email");
						LocalDate dob=set.getDate("dob").toLocalDate();
						LocalDate doj=set.getDate("doj").toLocalDate();
						System.out.print("id : "+id+" | ");
						System.out.print("name : "+name+" | ");
						System.out.print("email : "+email+" | ");
						System.out.print("dob : "+dob+" | ");
						System.out.println("doj : "+doj+" | ");
						
					}
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
				
			
			
			}
		}
		
	}

}
