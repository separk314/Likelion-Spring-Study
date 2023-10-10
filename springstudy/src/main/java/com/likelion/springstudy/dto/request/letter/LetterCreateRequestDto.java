package com.likelion.springstudy.dto.request.letter;

import com.likelion.springstudy.domain.entity.BoxEntity;
import com.likelion.springstudy.domain.entity.LetterEntity;
import com.likelion.springstudy.domain.entity.MemberEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class LetterCreateRequestDto {

    private String title;
    private String content;
    private MemberEntity sender;
    private BoxEntity box;

    public static LetterEntity toLetter(String title, String content, BoxEntity box) {
        return new LetterEntity(title, content, box);
    }
}
