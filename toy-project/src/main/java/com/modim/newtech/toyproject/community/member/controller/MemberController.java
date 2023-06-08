package com.modim.newtech.toyproject.community.member.controller;

import com.modim.newtech.toyproject.community.configuration.jwt.JwtTokenProvider;
import com.modim.newtech.toyproject.community.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    @GetMapping("/signup")
    public String signup() {
        return "member/signup";
    }

    @GetMapping("/login")
    public String login() {
        return "member/login";
    }



}
