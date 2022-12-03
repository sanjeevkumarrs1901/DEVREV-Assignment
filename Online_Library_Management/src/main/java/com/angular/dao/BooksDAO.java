package com.angular.dao;

import java.sql.SQLException;
import java.util.List;

import com.angular.beans.Books;

public interface BooksDAO {
	public List<Books> findAll(int count) throws SQLException;

}
