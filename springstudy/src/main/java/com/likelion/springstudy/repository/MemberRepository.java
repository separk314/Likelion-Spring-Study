package com.likelion.springstudy.repository;


import com.likelion.springstudy.domain.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    /*
        JpaRepository<MemberEntity, Long>: JPA가 기본적인 CRUD 메소드를 제공
        - MemberEntity: 엔티티 클래스
        - Long: 엔티티 클래스의 PK 타입
     */

//    default MemberEntity findByIdOrThrow(Long id) {
//        return findById(id).orElseThrow(() => new EntityNotFOundException("해당하는 회원을 찾을 수 없음"));
//    }
}