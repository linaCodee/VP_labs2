package mk.finki.ukim.mk.lab203078.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab203078.repository.ArtistRepository;
import mk.finki.ukim.mk.lab203078.service.ArtistService;
import mk.finki.ukim.mk.lab203078.service.impl.ArtistServiceImpl;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "ArtistServlet",urlPatterns = "/artists")
public class ArtistServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final ArtistRepository artistRepository;
    public ArtistServlet(SpringTemplateEngine springTemplateEngine, ArtistRepository artistRepository){
        this.springTemplateEngine=springTemplateEngine;
        this.artistRepository=artistRepository;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange= JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req,resp);
        WebContext context=new WebContext(webExchange);

        String trackId=req.getParameter("songId");
        context.setVariable("trackId",trackId);
        context.setVariable("artistList",artistRepository.findAll());
        springTemplateEngine.process("artistsList.html",context,resp.getWriter());
    }
}
