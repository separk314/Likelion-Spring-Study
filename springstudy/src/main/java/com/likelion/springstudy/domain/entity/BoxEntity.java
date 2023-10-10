package com.likelion.springstudy.domain.entity;

import com.likelion.springstudy.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "box")
public class BoxEntity extends BaseTimeEntity {

//    private static final int DEFAULT_LETTER_LIMIT = ;
//    private int letterLimit = DEFAULT_LETTER_LIMIT;

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    /*
        양방향 연관관계: Letters 조회하는 경우가 많을 때 사용
        mappedBy = "box": LetterEntity의 box 필드에 의해 매핑됨
     */
    @OneToMany(mappedBy = "box")
    private final List<LetterEntity> letters = new ArrayList<>();

    @OneToOne(mappedBy = "box")
    private MemberEntity member;
}
