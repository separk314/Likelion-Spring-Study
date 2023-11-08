package com.likelion.springstudy.repository;

import com.likelion.springstudy.domain.entity.BoxEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoxRepository extends JpaRepository<BoxEntity, Long> {
}
