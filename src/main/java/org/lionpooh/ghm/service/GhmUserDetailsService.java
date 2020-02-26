package org.lionpooh.ghm.service;

import lombok.extern.slf4j.Slf4j;
import org.lionpooh.ghm.controller.vo.Member;
import org.lionpooh.ghm.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Slf4j
@Service
public class GhmUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Autowired
    public GhmUserDetailsService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> memberOptional = memberRepository.findById(username);
        if(!memberOptional.isPresent()) {
            log.error("user email not found");
            throw new UsernameNotFoundException("user email not found");
        }
        return refineUser(memberOptional.get());
    }

    private User refineUser(Member member)   {
        User user = new User(
                member.getEmail(),
                member.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
        return user;
    }
}
