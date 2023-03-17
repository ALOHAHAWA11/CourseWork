package com.coursework.filmophile.repository;

import com.coursework.filmophile.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
