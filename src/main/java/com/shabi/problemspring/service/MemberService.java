package com.shabi.problemspring.service;

import com.shabi.problemspring.domain.member.Member;
import com.shabi.problemspring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long save(Member member) {
        memberRepository.save(member);
        return member.getId();
    }

    @Transactional
    public void remove(Member member) {
        memberRepository.remove(member);
    }

    @Transactional
    public Member update(Long id, String loginId, String password) {
        Member member = memberRepository.findOne(id);
        member.update(loginId, password);
        return member;
    }

    public Member findOne(Long id) {
        return memberRepository.findOne(id);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }
}
