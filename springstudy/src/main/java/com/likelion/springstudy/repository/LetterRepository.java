package com.likelion.springstudy.repository;

import com.likelion.springstudy.domain.entity.BoxEntity;
import com.likelion.springstudy.domain.entity.LetterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LetterRepository extends JpaRepository<LetterEntity, Long> {
    List<LetterEntity> findAllByBox(BoxEntity box);
}
