package com.jsp.example;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebFilter(filterName = "AuthenticationFilter")
public class AuthenticationFilter implements Filter {
    Connection con;
    private boolean next;
    public void init(FilterConfig config) throws ServletException {
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

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("It is In Filter");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String servletPath = request.getServletPath();
        String auth_id=null;
        String auth_number=null;
        String user_id = req.getParameter("user_id");
        String account_number = req.getParameter("account_number");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        Connection conn = null;
        Statement stmt = null;
        if (servletPath.contains("/authenticate") ) {
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
                stmt = conn.createStatement();
                String sql =
                        "SELECT user_id,account_number FROM bank WHERE user_id='" + user_id + "' and account_number='" + account_number + "'";

                ResultSet rs = stmt.executeQuery(sql);

                next = rs.next();
                if(!next){
                    response.sendRedirect("/index.jsp");
                    chain.doFilter(req, resp);
                }
                while (next) {
                    auth_id=rs.getString("user_id");
                    auth_number=rs.getString("account_number");
                    if(auth_id!=null && auth_number!=null){
                        HttpSession session=request.getSession();
                        session.setAttribute("name",user_id);
                        response.sendRedirect("/view.jsp");
                        chain.doFilter(req, resp);
                    }

                    else{
                        response.sendRedirect("/index.jsp");
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
    }



}
