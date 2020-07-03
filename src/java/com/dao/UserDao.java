package com.dao;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import com.beans.Users;
public class UserDao {
static String url="jdbc:mysql://localhost:3306/datacamp";
static String username="root";
static String password="arya";
public static Connection getconnection() throws ClassNotFoundException, SQLException
{
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection conn=DriverManager.getConnection(url,username,password);
      return conn;
}
public static boolean insertUser(Users obj)
{
    
    boolean flag=false;
    int counter=0;
   
    try
        {
            Connection conn;
            conn=getconnection();
            String query="insert into users(name,age,gender,email,phone_no) values(?,?,?,?,?);";
            PreparedStatement ps;
            ps=conn.prepareStatement(query);
            ps.setString(1,obj.getName());
            ps.setInt(2,obj.getAge());
            ps.setString(3,obj.getGender());
            ps.setString(4,obj.getEmail());
            ps.setString(5,obj.getPhone_no());
            counter=ps.executeUpdate();
            if(counter==1)
            {
                flag=true;
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
    return flag;
}

public static boolean getUser()
{
return false;
}

public static boolean deleteUser(int id){return false;}

}
