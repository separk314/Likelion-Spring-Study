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
@Getter @Setter
@Table(name = "member") // 테이블명을 명시하지 않으면 클래스명(Member_Entity)을 테이블명으로 사용
public class MemberEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true, length = 20)
    private String nickname;

    @CreatedDate
    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false, name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(nullable = true, name = "is_deleted")
    private Boolean isDeleted;

    @Column(nullable = true, name = "deleted_at")
    private LocalDate deleteAt;

    @OneToOne(mappedBy = "member")
    private BoxEntity box;

    @OneToMany(mappedBy = "sender")
    private List<LetterEntity> lettersSent;

    @Builder
    public MemberEntity(Long id, String username, String password, String nickname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
    }
}
