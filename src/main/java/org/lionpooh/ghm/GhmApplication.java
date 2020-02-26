package org.lionpooh.ghm;

import org.lionpooh.ghm.controller.vo.Member;
import org.lionpooh.ghm.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@SpringBootApplication
public class GhmApplication implements CommandLineRunner {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(GhmApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
//        String password = passwordEncoder.encode("password");
//        Member member = new Member();
//        member.setEmail("lionpooh37@gmail.com");
//        member.setPassword(password);
//        memberRepository.save(member);
    }
}


