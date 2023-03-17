package com.coursework.filmophile.dto;

import com.coursework.filmophile.entity.Film;
import com.coursework.filmophile.entity.Genre;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GenreDTO {
    private long id;
    private String name;
    private List<FilmDTO> films;

    public static GenreDTO fromEntity(Genre genre) {
        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setId(genre.getId());
        genreDTO.setName(genre.getName());
        List<FilmDTO> films = new ArrayList<>();
        for (Film film : genre.getFilms()) {
            films.add(FilmDTO.fromEntity(film));
        }
        genreDTO.setFilms(films);
        return genreDTO;
    }
    public static Genre toEntity(GenreDTO genreDTO) {
        Genre genre = new Genre();
        genre.setId(genreDTO.getId());
        genre.setName(genreDTO.getName());
        List<Film> films = new ArrayList<>();
        for (FilmDTO filmDTO : genreDTO.getFilms()) {
            films.add(FilmDTO.toEntity(filmDTO));
        }
        genre.setFilms(films);
        return genre;
    }

}
