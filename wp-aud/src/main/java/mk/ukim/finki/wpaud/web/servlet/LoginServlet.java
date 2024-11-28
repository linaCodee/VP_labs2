package mk.ukim.finki.wpaud.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wpaud.model.User;
import mk.ukim.finki.wpaud.model.exception.InvalidUserCredentialsException;
import mk.ukim.finki.wpaud.service.AuthService;
import mk.ukim.finki.wpaud.service.impl.AuthServiceImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.net.http.HttpClient;

@WebServlet(name = "LoginServlet",urlPatterns = "/servlet/login")
public class LoginServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final AuthService authService;
    public LoginServlet(SpringTemplateEngine springTemplateEngine,AuthService authService){
        this.authService=authService;
        this.springTemplateEngine=springTemplateEngine;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange= JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req,resp);
        WebContext context=new WebContext(webExchange);
        springTemplateEngine.process("login.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");

        User user=null;
        try {
            user=authService.login(username,password);
        }catch (InvalidUserCredentialsException ex){
            IWebExchange webExchange=JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req,resp);
            WebContext context=new WebContext(webExchange);

            context.setVariable("hasErrors",true);
            context.setVariable("error",ex.getMessage());
            springTemplateEngine.process("login.html",context,resp.getWriter());
        }
        req.getSession().setAttribute("user",user);
        resp.sendRedirect("/servlet/thymeleaf/category");
    }
}
