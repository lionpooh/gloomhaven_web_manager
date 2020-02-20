package org.lionpooh.ghm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GhmApplication implements CommandLineRunner {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(GhmApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
    }
}


