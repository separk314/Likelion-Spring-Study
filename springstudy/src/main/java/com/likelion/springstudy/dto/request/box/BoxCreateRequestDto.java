package com.likelion.springstudy.dto.request.box;

import com.likelion.springstudy.domain.entity.BoxEntity;
import com.likelion.springstudy.domain.entity.MemberEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BoxCreateRequestDto {

    private String name;
    private MemberEntity memberEntity;

    public static BoxEntity toBox(String name, MemberEntity memberEntity) {
        return new BoxEntity(name, memberEntity);
    }
}
