package mk.finki.ukim.mk.lab203078.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab203078.model.Artist;
import mk.finki.ukim.mk.lab203078.model.Song;
import mk.finki.ukim.mk.lab203078.service.impl.ArtistServiceImpl;
import mk.finki.ukim.mk.lab203078.service.impl.SongServiceImpl;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.ArrayList;

import static jakarta.servlet.http.HttpServletResponse.*;

@WebServlet(name = "SongDetailsServlet",urlPatterns = "/detailsForSongs")
public class SongDetailsServlet extends HttpServlet {
    private final SongServiceImpl songService;
    private final ArtistServiceImpl artistService;
    private final SpringTemplateEngine springTemplateEngine;

    public SongDetailsServlet(SongServiceImpl songService, ArtistServiceImpl artistService, SpringTemplateEngine springTemplateEngine) {
        this.songService = songService;
        this.artistService = artistService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String trackId=req.getParameter("trackId");
        String artistId=req.getParameter("artistId");

        Song song=songService.findByTrackId(Long.parseLong(trackId));
        Artist artist=artistService.findById(Long.parseLong(artistId));
        song.addArtist(artist);

        IWebExchange iWebExchange= JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req,resp);
        WebContext context=new WebContext(iWebExchange);

        context.setVariable("details",song);
        springTemplateEngine.process("songDetails.html",context,resp.getWriter());
    }
}
