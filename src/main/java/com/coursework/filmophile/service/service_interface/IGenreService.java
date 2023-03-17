package com.coursework.filmophile.service.service_interface;

import com.coursework.filmophile.dto.GenreDTO;
import com.coursework.filmophile.entity.Genre;

import java.util.List;
import java.util.Optional;

public interface IGenreService {
    List<Genre> getGenres();

    GenreDTO saveGenre(GenreDTO genreDTO);

    Optional<GenreDTO> getGenre(long id);

    GenreDTO updateGenre(GenreDTO genreDTO);

    long delereGenre(long id);
}
