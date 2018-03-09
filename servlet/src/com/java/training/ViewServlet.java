package com.java.training;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "ViewServlet")
public class ViewServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>All Customers</title></head>");
        out.println("<body>");
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            stmt = conn.createStatement();
            String sql =
                    "SELECT * FROM bank";

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                out.print("<table width=100% border=1>");
                out.print("<caption>Result:</caption>");

                /* Printing column names */
                ResultSetMetaData rsmd=rs.getMetaData();
                int total=rsmd.getColumnCount();
                out.print("<tr>");
                for(int i=1;i<=total;i++)
                {
                    out.print("<th>"+rsmd.getColumnName(i)+"</th>");
                }

                out.print("</tr>");


                while(rs.next())
                {
                    out.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7));

                }

                out.print("</table>");

            }
        } catch (Exception e) {
            out.println("An error occured while retrieving " + "all bank: "
                    + e.toString());
        }  finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
            }
        }

        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
