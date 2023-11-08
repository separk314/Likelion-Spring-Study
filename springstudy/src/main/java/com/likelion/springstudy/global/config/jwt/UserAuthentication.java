package com.likelion.springstudy.global.config.jwt;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserAuthentication extends UsernamePasswordAuthenticationToken {
    /*
        사용자의 인증 정보를 저장하고 전달하는 class
        - principle 객체: 주체(사용자 id)
        - credentials 객체: 비밀번호, 토큰
        - authorities 객체: 가지고 있는 권한 정보
     */

    // 사용자 인증 객체 생성
    public UserAuthentication(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }
}