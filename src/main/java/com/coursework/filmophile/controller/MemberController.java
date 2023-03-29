package com.coursework.filmophile.controller;

import com.coursework.filmophile.dto.MemberDTO;
import com.coursework.filmophile.entity.Member;
import com.coursework.filmophile.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/member")
public class MemberController {
    @Autowired
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<Member> getMembers() {
        return memberService.getMembers();
    }

    @PostMapping
    public MemberDTO createMember(@RequestBody MemberDTO memberDTO) {
        return memberService.saveMember(memberDTO);
    }

    @GetMapping(path = "/{id}")
    public Optional<MemberDTO> getMember(@PathVariable long id) {
        return memberService.getMember(id);
    }

    @PutMapping
    public MemberDTO updateMember(@RequestBody MemberDTO memberDTO) {
        return memberService.updateMember(memberDTO);
    }

    @DeleteMapping(path = "/{id}")
    public long deleteMember(@PathVariable long id) {
        return memberService.deleteMember(id);
    }
}

