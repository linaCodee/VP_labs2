package mk.finki.ukim.mk.lab203078.service.impl;

import mk.finki.ukim.mk.lab203078.model.Artist;
import mk.finki.ukim.mk.lab203078.model.Song;
import mk.finki.ukim.mk.lab203078.repository.ArtistRepository;
import mk.finki.ukim.mk.lab203078.repository.SongRepository;
import mk.finki.ukim.mk.lab203078.service.ArtistService;
import mk.finki.ukim.mk.lab203078.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    public SongServiceImpl(SongRepository songRepository){
        this.songRepository=songRepository;
    }
    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        return songRepository.addArtistToSong(song,artist);
    }

    @Override
    public Song findByTrackId(String trackId) {
        return listSongs().stream().filter(r->r.getTrackId().equals(trackId)).findFirst().orElse(null);
    }


}
