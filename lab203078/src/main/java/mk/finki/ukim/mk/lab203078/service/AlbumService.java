package mk.finki.ukim.mk.lab203078.service;

import mk.finki.ukim.mk.lab203078.model.Album;

import java.util.List;
import java.util.Optional;

public interface AlbumService {
    public List<Album> findAll();
    public Optional<Album> findById(Long id);
}
