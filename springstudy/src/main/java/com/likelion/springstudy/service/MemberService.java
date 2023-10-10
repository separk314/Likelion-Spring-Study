package com.likelion.springstudy.service;

import com.likelion.springstudy.domain.entity.MemberEntity;
import com.likelion.springstudy.dto.response.member.MemberGetResponseDto;
import com.likelion.springstudy.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    public MemberGetResponseDto getById(Long memberId) {
        MemberEntity member = memberRepository.findById(memberId).get();
        /*
            findById: Optional<MemberEntity> 객체를 반환
            방법 1. .orElseThrow(() -> new EntityNotFOundException("해당하는 회원을 찾을 수 없음")): Optional 객체가 비어있을 경우, 예외를 발생시킴
            방법 2. MemberRepository에서 orElseThrow() 메소드를 정의
         */

        return MemberGetResponseDto.of(member);
    }
}
