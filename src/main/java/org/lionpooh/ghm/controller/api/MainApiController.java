package org.lionpooh.ghm.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainApiController {

    @GetMapping("/simple")
    public String simpleRestController() throws Exception {
        return "simple test controller world";
    }
}
