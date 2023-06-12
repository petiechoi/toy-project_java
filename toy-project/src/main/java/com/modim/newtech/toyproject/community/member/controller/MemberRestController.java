package com.modim.newtech.toyproject.community.member.controller;

import com.modim.newtech.toyproject.community.member.dto.MemberDto;
import com.modim.newtech.toyproject.community.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberRestController {

    private final MemberService memberService;

    // 회원가입 API
    @PostMapping("/join")
    public Long join(@Valid @RequestBody MemberDto memberDto) {
        return memberService.join(memberDto);
    }

    // 로그인 API
    @PostMapping("/login")
    public String login(@RequestBody MemberDto memberDto) {
        return memberService.login(memberDto);
    }

    @GetMapping("/hi")
    public String hi(){
        return "hi";
    }
}
