package mk.finki.ukim.mk.lab203078.service.impl;

import mk.finki.ukim.mk.lab203078.model.Album;
import mk.finki.ukim.mk.lab203078.repository.AlbumRepository;
import mk.finki.ukim.mk.lab203078.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public Optional<Album> findById(Long id) {
        return albumRepository.findAlbumById(id);
    }
}
