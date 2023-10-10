package com.likelion.springstudy.dto.response.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.likelion.springstudy.domain.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data   // Getter, Setter 등등..
@AllArgsConstructor
public class MemberGetResponseDto {
//    @JsonProperty("멤버 이름")  // JSON으로 변환할 때, key값을 "멤버 이름"으로 변환
    private String username;
    private String nickname;

    public static MemberGetResponseDto of(MemberEntity member) {
        return new MemberGetResponseDto(member.getUsername(), member.getNickname());
    }
}