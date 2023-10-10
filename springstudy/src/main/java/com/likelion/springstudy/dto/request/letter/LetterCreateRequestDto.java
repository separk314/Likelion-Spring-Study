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

    public static LetterEntity toLetter(String title, String content) {
        return new LetterEntity(title, content);
    }
}
