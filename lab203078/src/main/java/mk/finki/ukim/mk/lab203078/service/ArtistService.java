package mk.finki.ukim.mk.lab203078.service;

import mk.finki.ukim.mk.lab203078.model.Artist;

import java.util.List;

public interface ArtistService {
    List<Artist> listArtists();
    Artist findById(Long id);
}
