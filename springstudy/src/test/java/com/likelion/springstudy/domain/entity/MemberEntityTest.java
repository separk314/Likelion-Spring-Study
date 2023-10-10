package com.likelion.springstudy.domain.entity;

import com.likelion.springstudy.repository.MemberRepository;
import org.apache.catalina.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberEntityTest {


    private MemberRepository memberJpaRepository;

    @DisplayName("MemberEntity 객체 생성 테스트")
    @Test
    void test() {
        // given
        MemberEntity member = new MemberEntity(1L, "username", "password", "nickname");
//        memberJpaRepository.save(member);

        // when
//        MemberEntity testMember = memberJpaRepository.findById(1L).get();

        // then
//        Assertions.assertTrue(member.getId()).isEqualTo(member.getId());
    }

}
