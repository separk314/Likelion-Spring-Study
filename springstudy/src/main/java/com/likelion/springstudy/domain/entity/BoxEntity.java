package com.likelion.springstudy.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
@Table(name = "box")
public class BoxEntity {
    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "box")
    private MemberEntity member;

    @OneToMany(mappedBy = "box")
    private List<LetterEntity> letters;
}
