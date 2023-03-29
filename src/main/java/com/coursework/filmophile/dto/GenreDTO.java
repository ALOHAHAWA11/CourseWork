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
    private List<Long> films;

    public static GenreDTO fromEntity(Genre genre) {
        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setId(genre.getId());
        genreDTO.setName(genre.getName());
        if (genre.getFilms() != null) {
            List<Long> films = new ArrayList<>();
            for (Film film : genre.getFilms()) {
                films.add(film.getId());
            }
            genreDTO.setFilms(films);
        }
        return genreDTO;
    }
    public static Genre toEntity(GenreDTO genreDTO) {
        Genre genre = new Genre();
        genre.setId(genreDTO.getId());
        genre.setName(genreDTO.getName());
        return genre;
    }

}
