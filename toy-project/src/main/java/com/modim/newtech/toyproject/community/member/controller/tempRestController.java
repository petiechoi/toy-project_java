package com.modim.newtech.toyproject.community.member.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class tempRestController {

    // jwt 테스트용 컨트롤러
    @PostMapping("/temp")
    public String temp(){
        return "<h1>통과</h1>";
    }
}
