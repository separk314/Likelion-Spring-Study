package com.likelion.springstudy.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration  // Configuration 파일
@EnableJpaAuditing
public class JpaAuditingConfig {
}
