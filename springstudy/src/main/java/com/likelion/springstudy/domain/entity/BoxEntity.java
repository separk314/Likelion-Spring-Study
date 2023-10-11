package com.likelion.springstudy.domain.entity;

import com.likelion.springstudy.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "box")
public class BoxEntity extends BaseTimeEntity {

    private static final int DEFAULT_LETTER_LIMIT = 20;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // id를 path에 쓰면 위험하기 때문에 대신 code를 사용한다
    @Column(unique = true)
    private String code;

    @Column(nullable = false)
    private String name;

    private int letterLimit = DEFAULT_LETTER_LIMIT;

    /*
        양방향 연관관계: Letters 조회하는 경우가 많을 때 사용
        mappedBy = "box": LetterEntity의 box 필드에 의해 매핑됨
     */
    @OneToMany(mappedBy = "box")
    private final List<LetterEntity> letters = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @Builder
    public BoxEntity(String name, MemberEntity member) {
        this.name = name;
        this.member = member;
    }
}
