package br.edu.ifpb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Enumeration;
import java.util.Map;
import java.util.HashMap;

@WebServlet(urlPatterns = {"/login"},
    initParams = {
        @WebInitParam(name = "AntonioMar", value = "123"),
        @WebInitParam(name = "Antonio", value = "456"),
        @WebInitParam(name = "GlayMar", value = "789"),
    }
)
public class AuthServlet extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
            Map<String, String> users = new HashMap<String, String>();
            ServletConfig config = this.getServletConfig();

            Enumeration<String> namesparam = config.getInitParameterNames();
            PrintWriter out = response.getWriter();

            while(namesparam.hasMoreElements()){
                String person = (String) namesparam.nextElement();
                users.put(person, config.getInitParameter(person));
            }
            String logUser = request.getParameter("userName");
            String LogPass = request.getParameter("UserPass");
            System.out.println(LogPass == users.get(logUser));
            System.out.println(LogPass + ":" +users.get(logUser));
            
            out.println("<html>");
            out.println("<body>");
            if(LogPass.equals(users.get(logUser))){
                out.println("<p> Usuario Autenticado  </p>");
            }else{
                out.println("<p> Usuario N cadastrado ou senha invalida</p>");
            }
            out.println("<body>");
            out.println("<html>");
    }
}

