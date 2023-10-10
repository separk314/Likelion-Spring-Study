package com.likelion.springstudy.service;

import com.likelion.springstudy.domain.entity.LetterEntity;
import com.likelion.springstudy.dto.request.letter.LetterCreateRequestDto;
import com.likelion.springstudy.repository.LetterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
//@Transactional(readOnly = true)
public class LetterService {

    private final LetterRepository letterRepository;

    public String create(LetterCreateRequestDto dto) {
        LetterEntity letter = letterRepository.save(LetterCreateRequestDto.toLetter(dto.getTitle(), dto.getContent(), dto.getBox(), dto.getSender()));
        return letter.getId().toString();
    }
}
