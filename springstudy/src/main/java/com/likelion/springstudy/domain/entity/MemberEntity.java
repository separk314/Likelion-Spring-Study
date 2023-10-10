package com.likelion.springstudy.domain.entity;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "member") // 테이블명을 명시하지 않으면 클래스명(Member_Entity)을 테이블명으로 사용
public class MemberEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String name;

//    @Column(nullable = false)
//    private String password;

    @Column(nullable = false, length = 20)
    private String nickname;

//    @Column(nullable = true, name = "is_deleted")
//    private Boolean isDeleted;

//    @Column(nullable = true, name = "deleted_at")
//    private LocalDate deleteAt;


    /*
        생성 패턴: 빌더 패턴, 팩토리 메소드 패턴
     */
    @Builder
    public MemberEntity(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }

    // 회원 닉네임 업데이트
    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }
}
