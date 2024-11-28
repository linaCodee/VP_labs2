package mk.finki.ukim.mk.lab203078.service.impl;

import mk.finki.ukim.mk.lab203078.model.Artist;
import mk.finki.ukim.mk.lab203078.repository.ArtistRepository;
import mk.finki.ukim.mk.lab203078.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;
    public ArtistServiceImpl(ArtistRepository artistRepository){
        this.artistRepository=artistRepository;
    }
    @Override
    public List<Artist> listArtists(){
        return artistRepository.findAll();
    }

    @Override
    public Artist findById(Long id) {
        return artistRepository.findById(id).orElse(null);
    }
}
