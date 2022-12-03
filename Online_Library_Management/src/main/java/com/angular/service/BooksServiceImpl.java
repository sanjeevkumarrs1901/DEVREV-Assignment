package com.angular.service;


import java.util.ArrayList;
import java.util.List;

import com.angular.beans.Books;
import com.angular.dao.BooksDAO;
import com.angular.dao.BooksImpl;

public class BooksServiceImpl implements BooksService
{
	private BooksDAO ld=new BooksImpl();
    @Override
    public List<Books> findAll(int count)
    {
    	List<Books> list=new ArrayList<>();
    	try
    	{
    		list=ld.findAll(count);
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    	return list;
    }
}
