package com.coursework.filmophile.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "members", schema = "public")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Temporal(value = TemporalType.DATE)
    private Date birthdate;
    private String information;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "film_id")
    private List<Film> films;
}
