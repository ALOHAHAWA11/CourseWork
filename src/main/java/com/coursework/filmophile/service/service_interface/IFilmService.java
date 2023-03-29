package com.coursework.filmophile.service.service_interface;

import com.coursework.filmophile.dto.FilmDTO;
import com.coursework.filmophile.entity.Film;

import java.util.List;
import java.util.Optional;

public interface IFilmService {
    List<Film> getFilms();

    FilmDTO saveFilm(FilmDTO filmDTO);

    Optional<FilmDTO> getFilm(long id);

    FilmDTO updateFilm(FilmDTO filmDTO);

    long deleteFilm(long id);

}
