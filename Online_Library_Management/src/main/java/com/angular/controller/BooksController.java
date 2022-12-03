package com.angular.controller;

import java.io.BufferedReader;
import java.io.IOException;


import java.io.PrintWriter;
import java.util.List;

import org.json.JSONObject;

import com.angular.beans.Books;
import com.angular.service.BooksService;
import com.angular.service.BooksServiceImpl;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet("/BooksController")
public class BooksController extends HttpServlet 
{
    private static final long serialVersionUID=1L;
    private BooksService ls;
    int count=10;
    @Override
    public void init() throws ServletException
    {
    	super.init();
    	ls=new BooksServiceImpl();
    }
    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
    {
    	StringBuffer sb = null;
        JSONObject jObj = null;
        BufferedReader br = null;
        String str = null;
        try {
            br = req.getReader();
            sb = new StringBuffer();
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            jObj = new JSONObject(sb.toString());
           count=jObj.getInt("count");
        }
        catch(Exception e)
        {
        	System.out.println(e);
        }
    	List <Books> list=ls.findAll(count);
    	PrintWriter out=resp.getWriter();
    	Gson gson=new Gson();
    	if(list.size()>0)
    	{
    		String jd=gson.toJson(list);
    		out.print(jd);
    	}
    	out.close();
    }
}
