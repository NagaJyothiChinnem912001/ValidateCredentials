package com.techpalle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;
import com.techpalle.Student;

public class DAO {
	public ArrayList read() {
		ArrayList<Student> arr=new ArrayList<Student>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata","root","Jyo@912001");
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery("select * from student");
			while(r.next()==true) {
				String email=r.getString(1);
				String pwd=r.getString(2);
				Student s1=new Student(email,pwd);
				arr.add(s1);
			}
			s.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
	public boolean insert(Student stu) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata", "root", "Jyo@912001");
			String query="insert into student values(?,?)";
			PreparedStatement s=con.prepareStatement(query);
			s.setString(1, stu.getEmail());
			s.setString(2, stu.getPwd());
			s.executeUpdate();
			s.close();
			con.close();
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			System.out.println("Invalid data");
			e.printStackTrace();
			return false;
		}
}
}
