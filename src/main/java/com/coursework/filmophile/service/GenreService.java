package com.coursework.filmophile.service;

import com.coursework.filmophile.dto.GenreDTO;
import com.coursework.filmophile.entity.Genre;
import com.coursework.filmophile.repository.FilmRepository;
import com.coursework.filmophile.repository.GenreRepository;
import com.coursework.filmophile.service.service_interface.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService implements IGenreService {
    @Autowired
    private final GenreRepository genreRepository;
    @Autowired
    private final FilmRepository filmRepository;

    public GenreService(GenreRepository genreRepository, FilmRepository filmRepository) {
        this.genreRepository = genreRepository;
        this.filmRepository = filmRepository;
    }

    @Override
    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }

    @Override
    public GenreDTO saveGenre(GenreDTO genreDTO) {
        Genre genre = GenreDTO.toEntity(genreDTO);
        if (genreDTO.getFilms() != null) {
            genre.setFilms(filmRepository.findAllById(genreDTO.getFilms()));
        }
        return GenreDTO.fromEntity(genreRepository.save(genre));
    }

    @Override
    public Optional<GenreDTO> getGenre(long id) {
        if (genreRepository.existsById(id)) {
            return genreRepository.findById(id).map(GenreDTO::fromEntity);
        } else throw new IllegalArgumentException("В базе данных нет записи с id = " + id);
    }

    @Override
    public GenreDTO updateGenre(GenreDTO genreDTO) {
        if (genreRepository.existsById(genreDTO.getId())) {
            Genre modifying = genreRepository.findById(genreDTO.getId()).get();
            modifying.setName(genreDTO.getName());
            if (genreDTO.getFilms() != null) {
                modifying.setFilms(filmRepository.findAllById(genreDTO.getFilms()));
            }
            return GenreDTO.fromEntity(genreRepository.save(modifying));
        }
        else throw new IllegalArgumentException("В базе данных нет записи с id = " + genreDTO.getId());
    }

    @Override
    public long deleteGenre(long id) {
        if (genreRepository.existsById(id)) {
            genreRepository.deleteById(id);
            return id;
        } else throw new IllegalArgumentException("В базе данных нет записи с id = " + id);
    }
}
