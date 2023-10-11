package com.likelion.springstudy.controller;

import com.likelion.springstudy.dto.request.member.MemberCreateRequestDto;
import com.likelion.springstudy.dto.response.member.MemberGetResponseDto;
import com.likelion.springstudy.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController     // Rest: ResponseBody에서 객체를 JSON으로 변환(serializer)
@RequestMapping("/api/member")
@RequiredArgsConstructor    // final로 정의된 생성자(의존성 주입)
public class MemberController {

    private final MemberService memberService;  // 의존성 주입을 위해 private final

    @PostMapping
    public ResponseEntity<String> signIn(@RequestBody MemberCreateRequestDto dto) {
        return ResponseEntity.ok(memberService.create(dto)); // 200 OK
    }

    /**
     * 특정 사용자 정보 조회 API
     */
    @GetMapping("/{memberId}")
    public ResponseEntity<MemberGetResponseDto> getMember(@PathVariable("memberId") Long memberId) {
        // ResponseEntity: HTTP 상태 코드를 포함한 응답을 생성하는데 사용, Spring에서 제공(추상화 잘 되어있음)

        return ResponseEntity.ok(memberService.getById(memberId));
    }

    /**
     * 회원 삭제(회원 탈퇴)
     */
    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> withdrawMembership(@PathVariable("memberId") Long memberId) {
        memberService.deleteById(memberId);
        return ResponseEntity.ok().build();
    }

    @PostMapping    // 클라이언트(기능적) 관점에서 PATCH가 아닌 POST가 적절
    public ResponseEntity<Void> recoverMembership(@PathVariable("memberId") Long memberId) {
        memberService.recoverMemberInfo(memberId);
        return ResponseEntity.ok().build();
    }
}
