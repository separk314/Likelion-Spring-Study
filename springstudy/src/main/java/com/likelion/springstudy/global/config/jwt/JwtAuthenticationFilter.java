package com.likelion.springstudy.global.config.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static com.likelion.springstudy.global.config.jwt.JwtValidationType.VALID_JWT;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter  extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {

            try {
                final String token = getJwtFromRequest(request);            // 헤더에서 JWT 토큰 추출
                if (jwtTokenProvider.validateToken(token) == VALID_JWT) {     // 토큰이 존재하고 유효한 토큰일 때만
                    Long memberId = jwtTokenProvider.getUserFromJwt(token);
                    UserAuthentication authentication = new UserAuthentication(memberId.toString(), null, null);       //사용자 객체 생성
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));  // request 정보로 사용자 객체 디테일 설정
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            } catch (Exception exception) {
//                Sentry.captureException(exception);
                throw new ServletException("유효하지 않은 토큰입니다.");
            }
            filterChain.doFilter(request, response);            // 다음 필터로 요청 전달(컨트롤러)

        }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");        // 헤더에서 Authorization값 가져옴. 클라에서 보낸 인증토큰 포함될 수 있음
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {    // 가져온 토큰이 Bearer로 시작하고 비어있지 않은 경우
            return bearerToken.substring("Bearer ".length());                 // Bearer를 제외한 나머지 문장 반환 == 토큰
        }
        return null;
    }

}

