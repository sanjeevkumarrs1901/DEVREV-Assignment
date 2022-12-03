package com.login;

import java.sql.Statement;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;
 
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
 
        String str = null;
        String name="";
        StringBuffer sb = null;
        JSONObject jObj = null;
        BufferedReader br = null;
        String email="",password="",c="";
        try {
            br = req.getReader();
            sb = new StringBuffer();
 
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            jObj = new JSONObject(sb.toString());
           c=jObj.getString("type");
            email =jObj.getString("username");
            password=jObj.getString("password");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try
        {
        Class.forName("org.postgresql.Driver");
        Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/newdatabase","postgres","Sanjeev@1901");
        Statement st=con.createStatement();
        String query;
        if(c.equals("A"))
             query = "select * from admin where email=\'"+email+"\' AND password=\'"+password+"\';";
        else
        	query = "select * from users where email=\'"+email+"\' AND password=\'"+password+"\';";
        ResultSet rs=st.executeQuery(query);
        int count=0;
        if(rs.next())
        {
        	count++;
        	name=rs.getString(1);
        }
        if(count==1)
        {
        	resp.getWriter().write("true");
        }
        else
        {
        	resp.getWriter().write("false");
        }
        }
        catch(Exception e)
        {
        	System.out.println(e);
        }
    }
}