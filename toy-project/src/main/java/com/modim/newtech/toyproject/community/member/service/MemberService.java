package com.modim.newtech.toyproject.community.member.service;

import com.modim.newtech.toyproject.community.configuration.jwt.JwtTokenProvider;
import com.modim.newtech.toyproject.community.member.dto.MemberDto;
import com.modim.newtech.toyproject.community.member.model.Member;
import com.modim.newtech.toyproject.community.member.model.Role;
import com.modim.newtech.toyproject.community.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public Long join(MemberDto memberDto){
        if (memberRepository.findByLoginId(memberDto.getLoginId()).orElse(null) != null) {
            throw new RuntimeException("이미 가입된 유저입니다.");
        }

        Member member = Member.builder()
                .loginId(memberDto.getLoginId())
                .loginPassword(passwordEncoder.encode(memberDto.getLoginPassword()))  //비밀번호 인코딩
                .name(memberDto.getName())
                .email(memberDto.getEmail())
                .register_date(LocalDateTime.now().toString())
                .role(Role.USER)
                .build();
        return memberRepository.save(member).getId();
    }

    public String login(MemberDto memberDto) {
        Member member = memberRepository.findByLoginId(memberDto.getLoginId())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 ID 입니다."));
        return jwtTokenProvider.createToken(member.getLoginId(), Role.USER.name());
    }
}
