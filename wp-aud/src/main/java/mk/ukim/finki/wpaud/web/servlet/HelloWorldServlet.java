package mk.ukim.finki.wpaud.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="hello",urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String surname=req.getParameter("surname");

        if (surname==null && name==null){
            name="";
            surname="";
        }

        PrintWriter writer=resp.getWriter();
        writer.format("<html><head><body><h3>Hi %s %s!</h3></body></head></html>",name,surname);
        writer.flush();
    }
}
