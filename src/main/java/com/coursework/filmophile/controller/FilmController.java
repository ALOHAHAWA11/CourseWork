package com.coursework.filmophile.controller;

import com.coursework.filmophile.dto.FilmDTO;
import com.coursework.filmophile.entity.Film;
import com.coursework.filmophile.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/film")
public class FilmController {

    @Autowired
    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public List<Film> getFilms() {
        return filmService.getFilms();
    }

    @PostMapping
    public FilmDTO saveFilm(@RequestBody FilmDTO filmDTO) {
        return filmService.saveFilm(filmDTO);
    }

    @GetMapping(path = "/{id}")
    public Optional<FilmDTO> getFilm(@PathVariable long id) {
        return filmService.getFilm(id);
    }

    @PutMapping
    public FilmDTO updateFilm(@RequestBody FilmDTO filmDTO) {
        return filmService.updateFilm(filmDTO);
    }

    @DeleteMapping(path = "/{id}")
    public long deleteFilm(@PathVariable long id) {
        return filmService.deleteFilm(id);
    }
}
