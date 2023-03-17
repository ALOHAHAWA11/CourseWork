package com.coursework.filmophile.service;

import com.coursework.filmophile.dto.FilmDTO;
import com.coursework.filmophile.entity.Film;
import com.coursework.filmophile.service.service_interface.IFilmService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService implements IFilmService {
    @Override
    public List<Film> getFilms() {
        return null;
    }

    @Override
    public FilmDTO saveFilm(FilmDTO filmDTO) {
        return null;
    }

    @Override
    public Optional<Film> getFilm(long id) {
        return Optional.empty();
    }

    @Override
    public FilmDTO updateFilm(FilmDTO filmDTO) {
        return null;
    }

    @Override
    public long deleteFilm(long id) {
        return 0;
    }
}
