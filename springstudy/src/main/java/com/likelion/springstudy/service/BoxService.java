package com.likelion.springstudy.service;

import com.likelion.springstudy.domain.entity.BoxEntity;
import com.likelion.springstudy.domain.entity.LetterEntity;
import com.likelion.springstudy.domain.entity.MemberEntity;
import com.likelion.springstudy.dto.request.box.BoxCreateRequestDto;
import com.likelion.springstudy.repository.BoxRepository;
import com.likelion.springstudy.repository.LetterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoxService {

    private final BoxRepository boxRepository;
    private final LetterRepository letterRepository;

    @Transactional
    public String create(BoxCreateRequestDto dto) {
        BoxEntity box = boxRepository.save(
                BoxEntity.builder()
                        .name(dto.getName())
                        .member(dto.getMemberEntity())
                        .build()
        );
        return box.getId().toString();
    }

    public BoxEntity findById(Long boxId) {
        return boxRepository.findById(boxId).get();
    }

    public List<LetterEntity> findLetters(Long boxId) {
        BoxEntity box = boxRepository.findById(boxId).get();
        List<LetterEntity> letters = letterRepository.findAllByBox(box);
        return letters;
    }
}
