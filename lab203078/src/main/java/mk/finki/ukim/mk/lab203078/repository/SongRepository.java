package mk.finki.ukim.mk.lab203078.repository;

import mk.finki.ukim.mk.lab203078.bootstrap.DataHolder2;
import mk.finki.ukim.mk.lab203078.model.Artist;
import mk.finki.ukim.mk.lab203078.model.Song;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class SongRepository {
    public List<Song> findAll(){
        return DataHolder2.songs;
    }
    public Song findByTrackId(String trackId){
        return DataHolder2.songs.stream().filter(r->r.getTrackId().equals(trackId)).findFirst().orElse(null);
    }

    public Artist addArtistToSong(Song song, Artist artist){
        for (Song s:DataHolder2.songs){
            if (s.getTrackId().equals(song.getTrackId())){
                s.addArtist(artist);
                return artist;
            }
        }
        return null;
    }
}
