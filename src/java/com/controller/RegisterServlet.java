package com.controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import com.dao.UserDao;
import com.beans.Users;
public class RegisterServlet extends HttpServlet{
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
    {
        PrintWriter out=response.getWriter();
       
        String name=request.getParameter("name");
        int age=Integer.parseInt(request.getParameter("age"));
        String gender=request.getParameter("gender");
        String email=request.getParameter("email");
        String phone_no=request.getParameter("phone_no");
        
        Users obj=new Users();
        obj.setName(name);
        obj.setAge(age);
        obj.setGender(gender);
        obj.setEmail(email);
        obj.setPhone_no(phone_no);
        
        boolean status=UserDao.insertUser(obj);
        if(status)
        {
            out.println("<div class='container'><h1 style='color:green'>Successfully registered</h1></div>");
        }
        else
        {
           out.println("<h1 style='color:red'>error occured</h1>");
          }
    }
    
}
