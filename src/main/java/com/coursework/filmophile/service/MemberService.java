package com.coursework.filmophile.service;

import com.coursework.filmophile.dto.GenreDTO;
import com.coursework.filmophile.dto.MemberDTO;
import com.coursework.filmophile.entity.Genre;
import com.coursework.filmophile.entity.Member;
import com.coursework.filmophile.repository.FilmRepository;
import com.coursework.filmophile.repository.MemberRepository;
import com.coursework.filmophile.service.service_interface.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService implements IMemberService {
    @Autowired
    private final FilmRepository filmRepository;
    @Autowired
    private final MemberRepository memberRepository;

    public MemberService(FilmRepository filmRepository, MemberRepository memberRepository) {
        this.filmRepository = filmRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    @Override
    public MemberDTO saveMember(MemberDTO memberDTO) {
        Member member = MemberDTO.toEntity(memberDTO);
        if (memberDTO.getFilms() != null) {
            member.setFilms(filmRepository.findAllById(memberDTO.getFilms()));
        }
        return MemberDTO.fromEntity(memberRepository.save(member));
    }

    @Override
    public Optional<MemberDTO> getMember(long id) {
        if (memberRepository.existsById(id)) {
            Optional<MemberDTO> memberDTO = memberRepository.findById(id).map(MemberDTO::fromEntity);
            return memberDTO;
        } else throw new IllegalArgumentException("В базе данных нет записи с id = " + id);
    }

    @Override
    public MemberDTO updateMember(MemberDTO memberDTO) {
        if (memberRepository.existsById(memberDTO.getId())) {
            Member modifying = memberRepository.findById(memberDTO.getId()).get();
            modifying.setName(memberDTO.getName());
            modifying.setInformation(memberDTO.getInformation());
            modifying.setBirthdate(memberDTO.getBirthdate());
            if (memberDTO.getFilms() != null) {
                modifying.setFilms(filmRepository.findAllById(memberDTO.getFilms()));
            }
            return MemberDTO.fromEntity(memberRepository.save(modifying));
        }
        else throw new IllegalArgumentException("В базе данных нет записи с id = " + memberDTO.getId());
    }

    @Override
    public long deleteMember(long id) {
        if (memberRepository.existsById(id)) {
            memberRepository.deleteById(id);
            return id;
        } else throw new IllegalArgumentException("В базе данных нет записи с id = " + id);
    }
}
