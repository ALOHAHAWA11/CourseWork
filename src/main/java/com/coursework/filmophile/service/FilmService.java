package com.coursework.filmophile.service;

import com.coursework.filmophile.dto.FilmDTO;
import com.coursework.filmophile.entity.Film;
import com.coursework.filmophile.entity.Genre;
import com.coursework.filmophile.entity.Member;
import com.coursework.filmophile.repository.FilmRepository;
import com.coursework.filmophile.repository.GenreRepository;
import com.coursework.filmophile.repository.MemberRepository;
import com.coursework.filmophile.service.service_interface.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService implements IFilmService {
    @Autowired
    private final GenreRepository genreRepository;
    @Autowired
    private final MemberRepository memberRepository;
    @Autowired
    private final FilmRepository filmRepository;

    public FilmService(GenreRepository genreRepository, MemberRepository memberRepository,
                       FilmRepository filmRepository) {
        this.genreRepository = genreRepository;
        this.memberRepository = memberRepository;
        this.filmRepository = filmRepository;
    }

    @Override
    public List<Film> getFilms() {
        return filmRepository.findAll();
    }

    @Override
    public FilmDTO saveFilm(FilmDTO filmDTO) {
        Film film = FilmDTO.toEntity(filmDTO);
        if (filmDTO.getGenres() != null) {
            film.setGenres(genreRepository.findAllById(filmDTO.getGenres()));
        }
        if (filmDTO.getMembers() != null) {
            film.setMembers(memberRepository.findAllById(filmDTO.getMembers()));
        }
        return FilmDTO.fromEntity(filmRepository.save(film));
    }

    @Override
    public Optional<FilmDTO> getFilm(long id) {
        if (filmRepository.existsById(id)) {
            return filmRepository.findById(id).map(FilmDTO::fromEntity);
        } else throw new IllegalArgumentException("В базе данных нет записи с id = " + id);
    }

    @Override
    public FilmDTO updateFilm(FilmDTO filmDTO) {
        if (filmRepository.existsById(filmDTO.getId())) {
            Film modifying = filmRepository.findById(filmDTO.getId()).get();
            modifying.setName(filmDTO.getName());
            modifying.setAnnotation(filmDTO.getAnnotation());
            modifying.setOriginalName(filmDTO.getOriginalName());
            modifying.setPoster(filmDTO.getPoster());
            modifying.setDateRelease(filmDTO.getDateRelease());
            if (filmDTO.getMembers() != null) {
                modifying.setMembers(memberRepository.findAllById(filmDTO.getMembers()));
            }
            if (filmDTO.getGenres() != null) {
                modifying.setGenres(genreRepository.findAllById(filmDTO.getGenres()));
            }
            return FilmDTO.fromEntity(filmRepository.save(modifying));
        }
        else throw new IllegalArgumentException("В базе данных нет записи с id = " + filmDTO.getId());
    }

    @Override
    public long deleteFilm(long id) {
        if (filmRepository.existsById(id)) {
            filmRepository.deleteById(id);
            return id;
        } else throw new IllegalArgumentException("В базе данных нет записи с id = " + id);
    }
}
