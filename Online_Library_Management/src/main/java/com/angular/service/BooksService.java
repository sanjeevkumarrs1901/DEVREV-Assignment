package com.angular.service;

import java.util.List;

import com.angular.beans.Books;

public interface BooksService
{
	public List<Books> findAll(int count);
}
