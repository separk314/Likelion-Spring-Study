package com.likelion.springstudy.controller;

import com.likelion.springstudy.domain.entity.LetterEntity;
import com.likelion.springstudy.dto.request.letter.LetterCreateRequestDto;
import com.likelion.springstudy.service.LetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("api/letter")
@RequiredArgsConstructor
public class LetterController {

    private final LetterService letterService;

    @PostMapping
    public ResponseEntity<Void> sendLetter(@RequestBody LetterCreateRequestDto dto) {
        String letterId = letterService.create(dto);
        URI location = URI.create("api/letter/" + letterId);    // redirect url을 반환
        return ResponseEntity.created(location).build();    // redirect url을 반환
    }

    @GetMapping("/{letterId}")
    public ResponseEntity<LetterEntity> getLetter(@PathVariable("letterId") Long letterId) {
        return ResponseEntity.ok(letterService.getById(letterId));
    }
}
