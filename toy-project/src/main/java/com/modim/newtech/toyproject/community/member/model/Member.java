package com.modim.newtech.toyproject.community.member.model;

import com.modim.newtech.toyproject.community.member.dto.MemberDto;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    @Comment("로그인 아이디")
    private String loginId;

    @Comment("비밀번호")
    @Setter
    private String loginPassword;

    @Comment("이름")
    private String name;

    @Comment("이메일")
    private String email;

    @Comment("가입날짜")
    private String register_date;

    @Enumerated(EnumType.STRING)
    private Role role;

    public static Member createMember(MemberDto memberDto, PasswordEncoder passwordEncoder){
        Member member = Member.builder()
                .loginId(memberDto.getLoginId())
                .loginPassword(passwordEncoder.encode(memberDto.getLoginPassword()))
                .name(memberDto.getName())
                .email(memberDto.getEmail())
                .register_date(LocalDateTime.now().toString())
                .role(Role.USER)
                .build();
        return member;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.loginId;
    }

    @Override
    public boolean isAccountNonLocked() {
        //return false;
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //return false;
        return true;
    }

    @Override
    public boolean isEnabled() {
        //return false;
        return true;
    }

    @Override
    public boolean isAccountNonExpired() {
        //return false;
        return true;
    }
}
