package com.coursework.filmophile.dto;

import com.coursework.filmophile.entity.Film;
import com.coursework.filmophile.entity.Genre;
import com.coursework.filmophile.entity.Member;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class MemberDTO {
    private long id;
    private String name;
    private Date birthdate;
    private String information;
    private List<FilmDTO> films;

    public static MemberDTO fromEntity(Member member) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(member.getId());
        memberDTO.setName(member.getName());
        memberDTO.setInformation(member.getInformation());
        memberDTO.setBirthdate(member.getBirthdate());
        List<FilmDTO> films = new ArrayList<>();
        for (Film film : member.getFilms()) {
            films.add(FilmDTO.fromEntity(film));
        }
        memberDTO.setFilms(films);
        return memberDTO;
    }
    public static Member toEntity(MemberDTO memberDTO) {
        Member member = new Member();
        member.setId(memberDTO.getId());
        member.setName(memberDTO.getName());
        member.setInformation(memberDTO.getInformation());
        member.setBirthdate(memberDTO.getBirthdate());
        List<Film> films = new ArrayList<>();
        for (FilmDTO filmDTO : memberDTO.getFilms()) {
            films.add(FilmDTO.toEntity(filmDTO));
        }
        member.setFilms(films);
        return member;
    }


}
