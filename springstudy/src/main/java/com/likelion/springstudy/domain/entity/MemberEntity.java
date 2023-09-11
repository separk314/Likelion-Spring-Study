package com.likelion.springstudy.domain.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
public class MemberEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false)
    private String nickname;

    private int age;

    private boolean isAdult;

    public MemberEntity(Long id, String name, String nickname, int age) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.age = age;
        this.isAdult = age >= 20;
    }
}
