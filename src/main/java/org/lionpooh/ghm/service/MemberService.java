package org.lionpooh.ghm.service;

import org.lionpooh.ghm.Exception.MemberServiceException;
import org.lionpooh.ghm.controller.vo.Member;
import org.lionpooh.ghm.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member memberSignup(Member member) throws MemberServiceException {

//        email 중복 체크
        Optional<Member> memberEmailCheck = memberRepository.findById(member.getEmail());
        if (memberEmailCheck.isPresent()) {
            throw new MemberServiceException("duplicate email");
        }
        return memberRepository.save(member);
    }

    public Member memberSignIn(Member member) throws MemberServiceException {
        Optional<Member> memberLogin = memberRepository.findById(member.getEmail());

        if (!memberLogin.isPresent()) throw new MemberServiceException();

        return memberLogin.get();
    }


}
