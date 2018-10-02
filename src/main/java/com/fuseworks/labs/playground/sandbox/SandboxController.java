package com.fuseworks.labs.playground.sandbox;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class SandboxController {

    @GetMapping
    public String home() {
        return "Welcome home!";
    }
}
