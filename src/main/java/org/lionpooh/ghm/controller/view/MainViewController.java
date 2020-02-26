package org.lionpooh.ghm.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainViewController {

    @GetMapping("/member/login")
    public String login() throws Exception {
        return "/member/login";
    }

    @GetMapping("/join")
    public String join() throws Exception {
        //test
        return "/member/join";
    }
    @RequestMapping("/")
    public String main(Model model) throws Exception {

//        model.addAttribute("member", )
        return "main";
    }
}
