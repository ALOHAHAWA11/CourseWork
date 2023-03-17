package com.coursework.filmophile.service;

import com.coursework.filmophile.dto.GenreDTO;
import com.coursework.filmophile.entity.Genre;
import com.coursework.filmophile.service.service_interface.IGenreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService implements IGenreService {
    @Override
    public List<Genre> getGenres() {
        return null;
    }

    @Override
    public GenreDTO saveGenre(GenreDTO genreDTO) {
        return null;
    }

    @Override
    public Optional<GenreDTO> getGenre(long id) {
        return Optional.empty();
    }

    @Override
    public GenreDTO updateGenre(GenreDTO genreDTO) {
        return null;
    }

    @Override
    public long delereGenre(long id) {
        return 0;
    }
}
