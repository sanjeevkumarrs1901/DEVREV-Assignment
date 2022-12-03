package com.login;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import com.google.gson.Gson;
 
@WebServlet("/AddBooks")
public class AddBooks extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    	StringBuffer sb = null;
        JSONObject jObj = null;
        BufferedReader br = null;
        String str = null,title = null,author=null,subject=null,date=null;
        try {
            br = req.getReader();
            sb = new StringBuffer();
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            jObj = new JSONObject(sb.toString());
            title=jObj.getString("title");
            author=jObj.getString("author");
            subject=jObj.getString("subject");
            date=jObj.getString("date");
        }
        catch(Exception e)
        {
        	System.out.println(e);
        }
    	try
        {
        Class.forName("org.postgresql.Driver");
        Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/newdatabase","postgres","Sanjeev@1901");
        Statement st=con.createStatement();
        String query = "insert into books(title,author,subject,date_published) values(\'"+title+"\',\'"+author+"\',\'"+subject+"\',\'"+date+"\');";
        st.executeUpdate(query);
        resp.getWriter().write("true");
        }
        catch(Exception e)
        {
        	System.out.println(e);
        }
    }
}
 
