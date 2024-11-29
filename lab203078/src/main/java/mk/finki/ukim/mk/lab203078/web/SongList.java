 package mk.finki.ukim.mk.lab203078.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab203078.repository.SongRepository;
import org.springframework.stereotype.Controller;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "SongList",urlPatterns = {"/song"})
public class SongList extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final SongRepository songRepository;

    public SongList(SpringTemplateEngine springTemplateEngine, SongRepository songRepository) {
        this.springTemplateEngine = springTemplateEngine;
        this.songRepository = songRepository;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange=JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req,resp);
        WebContext context=new WebContext(webExchange);

        context.setVariable("songs",songRepository.findAll());
        springTemplateEngine.process("songsList.html",context,resp.getWriter());
    }
}