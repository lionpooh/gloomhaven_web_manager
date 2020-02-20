package org.lionpooh.ghm;

import org.junit.jupiter.api.Test;
import org.lionpooh.ghm.controller.vo.game.component.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;

import java.util.Set;

@SpringBootTest(args = "--app.test=brute")
@AutoConfigureMockMvc
class GhmApplicationTests {

    @Autowired
    private Character testCharacter;

    @Test
    void contextLoads(@Autowired ApplicationArguments arguments) {
        Set<String> options = arguments.getOptionNames();
        options.stream().forEach(System.out::println);
    }

    @Test
    void ghmTests() {
        String className = testCharacter.getClassName();
        System.out.println(className);
    }

    @TestConfiguration
    static class GhmApplicationConfiguration {
//        @Bean
//        public Character testCharacter() {
//            Character testCharacter = new Character();
//            testCharacter.setRetire(true);
//            testCharacter.setClassName("spell");
//            return testCharacter;
//        }
    }

}
