package com.jsp.example;

import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class RegistrationTest {

    @Test
    public void testServlet() throws Exception{
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("bank_name")).thenReturn("SBI");
        when(request.getParameter("ifsc_code")).thenReturn("SBIN0024");
        when(request.getParameter("customer_name")).thenReturn("krishna");
        when(request.getParameter("age")).thenReturn("25");
        when(request.getParameter("account_number")).thenReturn("PQRs123456789");
        when(request.getParameter("phone_number")).thenReturn("123232323");
        when(request.getParameter("city")).thenReturn("Hyderabad");
        when(request.getParameter("user_id")).thenReturn("1234");

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer= new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        new Registration().doPost(request,response);
        writer.flush(); // it may not have been flushed yet...
//        assertTrue(stringWriter.toString().contains("My expected string"));
    }

}