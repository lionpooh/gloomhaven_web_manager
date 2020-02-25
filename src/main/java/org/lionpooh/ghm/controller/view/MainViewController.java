package org.lionpooh.ghm.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainViewController {

    @RequestMapping("/login")
    public String login() throws Exception {
        return "login";
    }

    @RequestMapping("/join")
    public String join() throws Exception {
        //test
        return "join";
    }
    @RequestMapping("/")
    public String main() throws Exception {
        return "main";
    }
}
