package com.coursework.filmophile.controller;

import com.coursework.filmophile.dto.GenreDTO;
import com.coursework.filmophile.entity.Genre;
import com.coursework.filmophile.service.GenreService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/genre")
public class GenreController {
    @Autowired
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public List<Genre> getGenres() {
        return genreService.getGenres();
    }

    @PostMapping
    public GenreDTO createGenre(@RequestBody GenreDTO genreDTO) {
        return genreService.saveGenre(genreDTO);
    }

    @GetMapping(path = "/{id}")
    public Optional<GenreDTO> getGenre(@PathVariable long id) {
        return genreService.getGenre(id);
    }

    @PutMapping
    public GenreDTO updateGenre(@RequestBody GenreDTO genreDTO) {
        return genreService.updateGenre(genreDTO);
    }

    @DeleteMapping(path = "/{id}")
    public long deleteGenre(@PathVariable long id) {
        return genreService.deleteGenre(id);
    }

}
