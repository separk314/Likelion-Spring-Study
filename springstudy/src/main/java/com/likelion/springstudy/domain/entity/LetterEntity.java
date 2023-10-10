package com.likelion.springstudy.domain.entity;

import com.likelion.springstudy.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "letter")
public class LetterEntity extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false)
    private String content;

//    @Column(nullable = false, name = "photo_url")
//    private String photoUrl;

    /*
        Letter에서만 box_id를 가짐: 단방향 연간관계
        - JOIN 관계를 조회하는 두 가지 방법: 즉시로딩(EAGER), 지연로딩(LAZY)
        1. 즉시로딩: Letter를 가져올 때 Letter의 Box 정보까지 가져옴(일반적인 JOIN)
        2. 지연로딩: Letter를 가져올 때 Box 정보를 가져오지 않음. 실제 데이터가 필요한 상황에서 가져옴.
        - 즉시로딩은 성능 상의 이슈가 있을 수 있음. 지연로딩을 권장

        Box에서 List<Letter>를 가짐: 양방향 연관관계(Box에서 Letter 조회를 많이 하는 경우)
        - 양방향 연관관계를 권장하지는 않지만 작은 서비스에서는 큰 문제가 되지 않음
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "box_id")    // 실제로는 box_id 컬럼이 생성됨
    private BoxEntity box;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private MemberEntity sender;

    public LetterEntity(String title, String content, BoxEntity box, MemberEntity sender) {
        this.title = title;
        this.content = content;
        this.box = box;
        this.sender = sender;
    }
}
