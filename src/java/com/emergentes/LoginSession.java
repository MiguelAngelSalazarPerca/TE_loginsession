
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginSession", urlPatterns = {"/LoginSession"})
public class LoginSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses= request.getSession();
        String login = (String) ses.getAttribute("login");
        if (login.equals("ok")) {
            //terminar session
            ses.invalidate();
            response.sendRedirect("index.jsp");
        }
        else{
            ses.setAttribute("error","usuario sin autorizacion");
            response.sendRedirect("login.jsp");
        }
    }
}
