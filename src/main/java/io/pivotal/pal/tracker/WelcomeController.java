package io.pivotal.pal.tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    private String message;



    public WelcomeController(String a_welcome_message) {
        this.message = a_welcome_message;
    }

    @GetMapping("/")
    public String sayHello() {
        return this.message;
    }
}
