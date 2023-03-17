package com.coursework.filmophile.service.service_interface;

import com.coursework.filmophile.dto.MemberDTO;
import com.coursework.filmophile.entity.Member;

import java.util.List;
import java.util.Optional;

public interface IMemberService {
    List<Member> getMembers();
    MemberDTO saveMember(MemberDTO memberDTO);
    Optional<MemberDTO> getMember(long id);
    MemberDTO updateMember(MemberDTO memberDTO);
    long deleteMember(long id);
}
