package com.likelion.springstudy.controller;

import com.likelion.springstudy.domain.entity.LetterEntity;
import com.likelion.springstudy.dto.request.box.BoxCreateRequestDto;
import com.likelion.springstudy.dto.response.box.BoxGetResponseDto;
import com.likelion.springstudy.service.BoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/box")
@RequiredArgsConstructor
public class BoxController {

    private final BoxService boxService;

    @PostMapping
    public void createBox(@RequestBody BoxCreateRequestDto dto) {
        boxService.create(dto);
    }

    @GetMapping("/{boxId}")
    public BoxGetResponseDto getLetters(@PathVariable("boxId") Long boxId) {
        List<LetterEntity> letters = boxService.findLetters(boxId);
        return new BoxGetResponseDto(letters);
    }
}
