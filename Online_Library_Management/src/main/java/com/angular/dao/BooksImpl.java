package com.angular.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.angular.beans.Books;

public class BooksImpl implements BooksDAO {
	@Override
	public List<Books> findAll(int count)throws SQLException
	{
		List<Books> ul=new ArrayList<>();
		try {
		Class.forName("org.postgresql.Driver");
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/newdatabase","postgres","Sanjeev@1901");
		PreparedStatement ps=con.prepareStatement("Select * from books where id>\'"+count+"\' LIMIT 10;");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			int id=rs.getInt(1);
			String title=rs.getString(2);
			String author=rs.getString(3);
			String subject=rs.getString(4);
			String date=rs.getString(5);
			Books l=new Books(id,title,author,subject,date);
			ul.add(l);
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return ul;
		
	}

}
