package com.coursework.filmophile.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "films", schema = "public")
@Getter
@Setter
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String originalName;
    private String name;
    private String annotation;
    @Lob
    private byte[] poster;
    @Temporal(value = TemporalType.DATE)
    private Date dateRelease;
    @ManyToMany
    private List<Genre> genres;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private List<Member> members;

}
