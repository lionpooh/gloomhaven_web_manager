package org.lionpooh.ghm.controller.api;

import org.lionpooh.ghm.Exception.MemberServiceException;
import org.lionpooh.ghm.controller.vo.Member;
import org.lionpooh.ghm.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MainApiController {

    private final MemberService memberService;

    public MainApiController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/simple")
    public String simpleRestController() throws Exception {
        return "simple test controller world";
    }

    // 다른 방법?
    @PostMapping("/member/join")
    public ResponseEntity memberJoin(@RequestBody Member member) throws Exception{
        try {
            Member memberCreated = memberService.memberSignup(member);
            return ResponseEntity.status(HttpStatus.CREATED).body(memberCreated);
        } catch (MemberServiceException memberServiceException) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (Exception exception) {
            throw exception;
        }
    }

}
