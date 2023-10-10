package com.likelion.springstudy.dto.response.box;

import com.likelion.springstudy.domain.entity.LetterEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BoxGetResponseDto {
    List<LetterEntity> letters;

    public static BoxGetResponseDto of(List<LetterEntity> letters) {
        return new BoxGetResponseDto(letters);
    }
}
