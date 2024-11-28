package mk.finki.ukim.mk.lab203078.repository;

import mk.finki.ukim.mk.lab203078.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab203078.model.Artist;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ArtistRepository {
    public List<Artist> findAll(){
        return DataHolder.artist;
    }
    public Optional<Artist> findById(Long id){
        return DataHolder.artist.stream().filter(r->r.getId().equals(id)).findFirst();
    }
}
