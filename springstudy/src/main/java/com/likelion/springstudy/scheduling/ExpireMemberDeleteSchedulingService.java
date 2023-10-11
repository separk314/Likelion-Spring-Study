package com.likelion.springstudy.scheduling;

import com.likelion.springstudy.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpireMemberDeleteSchedulingService {

    private final MemberRepository memberRepository;

    @Scheduled(cron = "0 0 0 * * *")    // 매일 0시 0분 0초에 실행
    public void deleteExpiredMember() {
        memberRepository.deleteExpiredMember();
    }
}
