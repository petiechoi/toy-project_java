package com.modim.newtech.toyproject.community.member.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


@NoArgsConstructor
@Getter
public class MemberDto {
    @NotEmpty(message = "아이디는 필수 입력 값입니다.")
    @Length(min = 4, max = 10, message = "아이디는 4자 이상, 10자 이하로 입력해주십시오.")
    private String loginId;

    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    @Length(min = 6, max = 16, message = "비밀번호는 6자 이상, 16자 이하로 입력해주십시오.")
    private String loginPassword;

    @NotEmpty(message = "이름은 필수 입력 값입니다.")
    private String name;

    @NotEmpty(message = "이메일은 필수 입력 값입니다.")
    private String email;

    @Builder
    public MemberDto(String loginId,String loginPassword, String name, String email){
        this.loginId = loginId;
        this.loginPassword = loginPassword;
        this.name = name;
        this.email = email;
    }

}
