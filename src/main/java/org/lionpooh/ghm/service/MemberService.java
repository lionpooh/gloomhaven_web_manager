package org.lionpooh.ghm.service;

import org.lionpooh.ghm.Exception.MemberServiceException;
import org.lionpooh.ghm.controller.vo.Member;
import org.lionpooh.ghm.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sun.security.util.Password;

import java.util.Optional;

@Service
public class MemberService {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    @Autowired
    MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }


    // 해당 메소드를 포인트 컷 할 방법이 필요
    public Member memberSignup(Member member) throws Exception {
//        email 중복 체크
        Optional<Member> memberEmailCheck = memberRepository.findById(member.getEmail());
        if (memberEmailCheck.isPresent()) {
            throw new MemberServiceException("duplicate email");
        } else {
            String password = member.getPassword();
            password = passwordEncoder.encode(password);
            member.setPassword(password);
        }

        return memberRepository.save(member);
    }

//    public Member memberSignIn(Member member) throws MemberServiceException {
//        Optional<Member> memberLogin = memberRepository.findById(member.getEmail());
//
//        if (!memberLogin.isPresent()) throw new MemberServiceException();
//
//        return memberLogin.get();
//    }


}
