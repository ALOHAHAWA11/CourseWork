package com.coursework.filmophile.service;

import com.coursework.filmophile.dto.MemberDTO;
import com.coursework.filmophile.entity.Member;
import com.coursework.filmophile.service.service_interface.IMemberService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService implements IMemberService {
    @Override
    public List<Member> getMembers() {
        return null;
    }

    @Override
    public MemberDTO saveMember(MemberDTO memberDTO) {
        return null;
    }

    @Override
    public Optional<MemberDTO> getMember(long id) {
        return Optional.empty();
    }

    @Override
    public MemberDTO updateMember(MemberDTO memberDTO) {
        return null;
    }

    @Override
    public long deleteMember(long id) {
        return 0;
    }
}
