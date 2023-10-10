package com.likelion.springstudy.service;

import com.likelion.springstudy.domain.entity.LetterEntity;
import com.likelion.springstudy.dto.request.letter.LetterCreateRequestDto;
import com.likelion.springstudy.repository.LetterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LetterService {

    private final LetterRepository letterRepository;

    public String create(LetterCreateRequestDto dto) {
        LetterEntity letter = letterRepository.save(
                LetterEntity.builder()
                        .title(dto.getTitle())
                        .content(dto.getContent())
                        .build()
        );
        return letter.getId().toString();
    }

    public LetterEntity getById(Long letterId) {
        return letterRepository.findById(letterId).get();
    }
}
