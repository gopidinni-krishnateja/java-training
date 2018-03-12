package com.jsp.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "Authentication")
public class Authentication extends HttpServlet {
    Connection con;
    private boolean next;

    public void init(){
        String dbName = "jdbc:postgresql://localhost:5432/postgres";
        String userName = "postgres";
        String password = "postgres";
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(dbName, userName, password);
            Statement statement = con.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String auth_id=null;
        String auth_number=null;
        String user_id = request.getParameter("user_id");
        String account_number = request.getParameter("account_number");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            stmt = conn.createStatement();
            String sql =
                    "SELECT user_id,account_number FROM bank WHERE user_id='" + user_id + "' and account_number='" + account_number + "'";

            ResultSet rs = stmt.executeQuery(sql);

            next = rs.next();
            if(!next){
                response.sendRedirect("/registration.jsp");
            }
            while (next) {

                auth_id=rs.getString("user_id");
                auth_number=rs.getString("account_number");
                if(auth_id!=null && auth_number!=null){
                    HttpSession session=request.getSession();
                    session.setAttribute("name",user_id);
                    response.sendRedirect("/view.jsp");
                }

                else{
                    response.sendRedirect("/registration.jsp");
                    System.out.println("Registration Page");
                }

            }
        } catch (Exception e) {
            out.println("An error occured while retrieving " + "all customers: "
                    + e.toString());
        }  finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
            }
        }
        out.close();
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
