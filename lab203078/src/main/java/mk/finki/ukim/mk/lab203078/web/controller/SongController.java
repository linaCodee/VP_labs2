package mk.finki.ukim.mk.lab203078.web.controller;

import mk.finki.ukim.mk.lab203078.model.Album;
import mk.finki.ukim.mk.lab203078.model.Artist;
import mk.finki.ukim.mk.lab203078.model.Song;
import mk.finki.ukim.mk.lab203078.model.exceptions.InvalidAlbumIdException;
import mk.finki.ukim.mk.lab203078.repository.AlbumRepository;
import mk.finki.ukim.mk.lab203078.repository.ArtistRepository;
import mk.finki.ukim.mk.lab203078.repository.SongRepository;
import mk.finki.ukim.mk.lab203078.service.AlbumService;
import mk.finki.ukim.mk.lab203078.service.ArtistService;
import mk.finki.ukim.mk.lab203078.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SongController {
    private final AlbumService albumService;
    private final ArtistService artistService;
    private final SongService songService;

    public SongController(AlbumService albumService, ArtistService artistService, SongService songService) {
        this.albumService = albumService;
        this.artistService = artistService;
        this.songService = songService;
    }

    @RequestMapping("/songs")
    public String getSongsPage(@RequestParam(required = false) String error, Model model){
        model.addAttribute("song",songService.listSongs());
        return "songsList";
    }

    @RequestMapping("/songs/add")
    public String addSong(Model model){
        List<Artist> artists=this.artistService.listArtists();
        List<Album> albums=this.albumService.findAll();
        model.addAttribute("artists",artists);
        model.addAttribute("albums",albums);
        return "addSong";
    }

    @PostMapping("/songs/save")
    public String saveSong(@RequestParam(required = false) String title,
                           @RequestParam(required = false) Long trackId,
                           @RequestParam(required = false) String genre,
                           @RequestParam(required = false) Integer releasedYear,
                           @RequestParam(required = false) Long albumId){

        Album album= albumService.findById(albumId).orElseThrow(() -> new InvalidAlbumIdException(albumId));

        if (trackId==null){
            this.songService.save(title,genre,releasedYear,album);
            return "redirect:/songs";
        }
        Song song=this.songService.findByTrackId(trackId);
        song.setTitle(title);
        song.setGenre(genre);
        song.setReleaseYear(releasedYear);
        song.setAlbum(albumService.findById(albumId).orElseThrow(()->new InvalidAlbumIdException(albumId)));
        return "redirect:/songs";
    }

    @GetMapping("/songs/delete/{id}")
    public String deleteSong(@PathVariable Long id){
        this.songService.deleteById(id);
        return "redirect:/songs";
    }

    @GetMapping("/songs/edit-form/{songId}")
    public String editFormSong(@PathVariable Long songId,Model model){
        Song song=songService.findByTrackId(songId);
        List<Artist> artists=this.artistService.listArtists();
        List<Album> albums=this.albumService.findAll();
        model.addAttribute("artists",artists);
        model.addAttribute("albums",albums);
        model.addAttribute("song",song);
        return "addSong";
    }
    @GetMapping("/songs/edit/{songId}")
    public String editSong(@PathVariable Long id,
                           @PathVariable(required = false) String title,
                           @PathVariable(required = false) String genre,
                           @PathVariable(required = false) Integer releaseYear,
                           @PathVariable(required = false) Long albumId){
        Song song=this.songService.findByTrackId(id);
        song.setTitle(title);
        song.setGenre(genre);
        song.setReleaseYear(releaseYear);
        song.setAlbum(albumService.findById(albumId).orElseThrow(()->new InvalidAlbumIdException(albumId)));
        return "redirect:/songs";
    }




}
