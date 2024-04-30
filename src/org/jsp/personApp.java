package org.jsp;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class personApp {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("1.saveUser");
		System.out.println("2.Update person");
		System.out.println("3.Delete person");
		System.out.println("4. person Login");
		System.out.println("5.Fetch All records");
		System.out.println("Enter your choice");
		int choice = s.nextInt();
        Connection con=null;
		PreparedStatement  pst=null;
		String qry="create table user(id int not null,name varchar(45) null,phone bigint(20) null ,password varchar(45) null,primary key(id))";
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root", "USH@rani7981660340");
	    switch(choice) {
	    case 1:{
	    	pst=con.prepareStatement("insert  into person values(?,?,?)");
	    	System.out.println("Enter id,name,phone and password");
	    	int id=s.nextInt();
	    	String name=s.next();
	    	long phone=s.nextLong();
	    	String password=s.next();
	    	pst.setInt(1, id);
	    	pst.setString(2, name);
	    	pst.setLong(3, phone);
	    	pst.setString(4, password);
	    	int r=pst.executeUpdate();
	    	System.out.println("person saved succesfully");
	    }
	    
	    }
	 	}
	catch(ClassNotFoundException |SQLException e) {
		e.printStackTrace();
	}
	finally {
		if(con!=null) {
		try {
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	}
	if(pst!=null) {
		try {
			pst.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
		

	}

}
