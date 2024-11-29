package mk.finki.ukim.mk.lab203078.repository;

import lombok.Data;
import mk.finki.ukim.mk.lab203078.bootstrap.DataHolder2;
import mk.finki.ukim.mk.lab203078.model.Album;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AlbumRepository {
    public List<Album> findAll(){
        return DataHolder2.albums;
    }
    public Optional<Album> findAlbumById(Long id){
        return DataHolder2.albums.stream().filter(r->r.getId().equals(id)).findFirst();
    }
}
