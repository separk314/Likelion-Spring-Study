package com.likelion.springstudy.global.config.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    // 토큰 만들고/검증하고/사인하고/토큰에서 데이터 가져오는 클래스

    @Value("${jwt.secret}")
    private String JWT_SECRET;

    @PostConstruct      // 생성자가 만들어지고 초기화할 때 사용하는 메소드
    protected void init() {
        //base64 라이브러리에서 encodeToString을 이용해서 byte[] 형식을 String 형식으로 변환
        JWT_SECRET = Base64.getEncoder().encodeToString(JWT_SECRET.getBytes(StandardCharsets.UTF_8));
    }

    // 토큰 생성 Authentication: Spring Security에서 인증 정보를 나타내기 위해 사용되는 인터페이스
    public String generateToken(Authentication authentication, Long tokenExpirationTime) {
        final Date now = new Date();

        // 클레임 생성
        final Claims claims = Jwts.claims()
                .setIssuedAt(now)               // 발급 시간
                .setExpiration(new Date(now.getTime() + tokenExpirationTime));      // 만료 시간

        //  getPrincipal: 인증 주체(principal)를 반환, 보통 인증된 사용자 의미. 주로 사용자의 식별자(ID)나 사용자 객체(User)를 포함]
        claims.put("memberId", authentication.getPrincipal());

        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)       // 암호화설정 알고리즘 및 토큰 타입 사용, JWT의 메타데이터를 정의하며, 토큰의 유효성 검증이나 처리 시 필요한 정보를 제공
                .setClaims(claims)
                .signWith(getSigningKey())                          // 서명 추가 메서드.(토큰의 무결성과 신뢰성을 보장하기 위함)
                .compact();                                         // JWT를 문자열로 직렬화되어 변환
    }

    private SecretKey getSigningKey() {
        String encodedKey = Base64.getEncoder().encodeToString(JWT_SECRET.getBytes());       //SecretKey 통해 서명 생성
        return Keys.hmacShaKeyFor(encodedKey.getBytes());   //일반적으로 HMAC (Hash-based Message Authentication Code) 알고리즘 사용
    }

    public JwtValidationType validateToken(String token) {
        try {
            final Claims claims = getBody(token);
            return JwtValidationType.VALID_JWT;
        } catch (MalformedJwtException ex) {
            return JwtValidationType.INVALID_JWT_TOKEN;
        } catch (ExpiredJwtException ex) {
            return JwtValidationType.EXPIRED_JWT_TOKEN;
        } catch (UnsupportedJwtException ex) {
            return JwtValidationType.UNSUPPORTED_JWT_TOKEN;
        } catch (IllegalArgumentException ex) {
            return JwtValidationType.EMPTY_JWT;
        }
    }

    private Claims getBody(final String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public Long getUserFromJwt(String token) {
        // jwt에서 memberId 추출하는 메소드
        Claims claims = getBody(token);
        return Long.valueOf(claims.get("memberId").toString());       // 클레임에서 memberId라는 이름의 클레임 값 추출 -> String으로 변경 -> Long타입으로 변경
    }
}