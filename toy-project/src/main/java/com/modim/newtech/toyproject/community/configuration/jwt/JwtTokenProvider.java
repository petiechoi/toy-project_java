package com.modim.newtech.toyproject.community.configuration.jwt;

import com.modim.newtech.toyproject.community.member.service.MemberDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    //@Value("${jwt.key}")
    private String key = "VlwEyVBsYt9V7zq57TejMnVUyzblYcfPQye08f7MGVA9XkHa";

    private final MemberDetailsService memberDetailsService;
    private long tokenValidTime = 30 * 60 * 1000L;     // 토큰 유효시간 30분

    @PostConstruct
    protected  void init(){
        key = Base64.getEncoder().encodeToString(key.getBytes());
    }

    // jwt 토큰 생성
    //public String createToken(String userPk, List<String> roles){
    public String createToken(String userPk, String roles){
        Claims claims = Jwts.claims().setSubject(userPk);
        claims.put("roles", roles);
        Date now = new Date();

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + tokenValidTime))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }

    // 인증 정보 조회
    public Authentication getAuthentication(String token) {
        UserDetails userDetails = memberDetailsService.loadUserByUsername(this.getUserPk(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    // 토큰에서 회원 정보 추출
    public String getUserPk(String token) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject();
    }

    // 토큰 유효성, 만료일자 확인
    public boolean validateToken(String jwtToken) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(key).parseClaimsJws(jwtToken);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    // Request의 Header에서 token 값 가져오기
    public String resolveToken(HttpServletRequest request) {
        return request.getHeader("Authorization");
    }




}
