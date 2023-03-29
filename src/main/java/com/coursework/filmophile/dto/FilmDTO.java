package com.coursework.filmophile.dto;

import com.coursework.filmophile.entity.Film;
import com.coursework.filmophile.entity.Genre;
import com.coursework.filmophile.entity.Member;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class FilmDTO {
    private long id;
    private String originalName;
    private String name;
    private String annotation;
    private byte[] poster;
    private Date dateRelease;
    private List<Long> genres;
    private List<Long> members;

    public static FilmDTO fromEntity(Film film) {
        FilmDTO filmDTO = new FilmDTO();
        filmDTO.setId(film.getId());
        filmDTO.setOriginalName(film.getOriginalName());
        filmDTO.setName(film.getName());
        filmDTO.setAnnotation(film.getAnnotation());
        filmDTO.setPoster(film.getPoster());
        filmDTO.setDateRelease(film.getDateRelease());
        if (film.getGenres() != null) {
            List<Long> genres = new ArrayList<>();
            for (Genre genre : film.getGenres()) {
                genres.add(genre.getId());
            }
            filmDTO.setGenres(genres);
        }
        if (film.getMembers() != null) {
            List<Long> members = new ArrayList<>();
            for (Member member : film.getMembers()) {
                members.add(member.getId());
            }
            filmDTO.setMembers(members);
        }
        return filmDTO;
    }

    public static Film toEntity(FilmDTO filmDTO) {
        Film film = new Film();
        film.setId(filmDTO.getId());
        film.setOriginalName(filmDTO.getOriginalName());
        film.setName(filmDTO.getName());
        film.setAnnotation(filmDTO.getAnnotation());
        film.setPoster(filmDTO.getPoster());
        film.setDateRelease(filmDTO.getDateRelease());

        return film;
    }
}
