package com.jsp.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

@WebServlet(name = "Registration")
public class Registration extends HttpServlet {
    Connection con;
    public void init() throws ServletException {
        String dbName = "jdbc:postgresql://localhost:5432/postgres";
        String userName = "postgres";
        String password = "postgres";
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(dbName, userName, password);
            System.out.println("Got Connection");
            Statement statement = con.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bank_name = request.getParameter("bank_name");
        String ifsc_code = request.getParameter("ifsc_code");
        String customer_name = request.getParameter("customer_name");
        String age = request.getParameter("age");
        String account_number = request.getParameter("account_number");
        String phone_number = request.getParameter("phone_number");
        String city = request.getParameter("city_name");
        String user_id = request.getParameter("user_id");
        try {
            String sql =
                    "insert into bank values (?,?,?,?,?,?,?,?)";
            PreparedStatement pst =
                    con.prepareStatement(sql);
            pst.setString(1, bank_name);
            pst.setString(2, ifsc_code);
            pst.setString(3, customer_name);
            pst.setString(4, age);
            pst.setString(5, account_number);
            pst.setString(6, phone_number);
            pst.setString(7, city);
            pst.setString(8, user_id);
            int numRowsChanged = pst.executeUpdate();
            System.out.println("Inserted SuccessFully");
            pst.close();

            response.sendRedirect("/index.jsp");

        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            try {
                if (con != null) con.close();
            } catch (Exception  e){

            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
