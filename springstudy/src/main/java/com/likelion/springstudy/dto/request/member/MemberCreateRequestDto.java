package com.likelion.springstudy.dto.request.member;

import com.likelion.springstudy.domain.entity.MemberEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MemberCreateRequestDto {

    private String name;
    private String nickname;

    public static MemberEntity of(String name, String nickname) {
        return new MemberEntity(name, nickname);
    }
}
