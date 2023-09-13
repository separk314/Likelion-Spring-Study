package com.likelion.springstudy.domain.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
@Table(name = "member") // 테이블명을 명시하지 않으면 클래스명(Member_Entity)을 테이블명으로 사용
public class MemberEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Builder
    public MemberEntity(Long id, String username, String password, String nickname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
    }
}
