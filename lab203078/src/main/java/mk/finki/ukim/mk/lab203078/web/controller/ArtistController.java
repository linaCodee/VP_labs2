package mk.finki.ukim.mk.lab203078.web.controller;

import mk.finki.ukim.mk.lab203078.service.ArtistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ArtistController {
    private  final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @RequestMapping("/artists")
    public String getArtistsPage(@RequestParam(required = false) String error, Model model){
        model.addAttribute("song",artistService.listArtists());
        return "artistsList";
    }
}
