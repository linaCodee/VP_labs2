package mk.finki.ukim.mk.lab203078.service;

import ch.qos.logback.core.pattern.SpacePadder;
import mk.finki.ukim.mk.lab203078.model.Album;
import mk.finki.ukim.mk.lab203078.model.Artist;
import mk.finki.ukim.mk.lab203078.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    Song findByTrackId(Long trackId);
    void deleteById(Long id);
    public Optional<Song> save(String title, String genre, Integer releasedYear, Album album);
}
