package br.com.projetospringboot3.myproject.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/test")
    public String otherEndpoint() {
        return "Other endpoint";
    }

    @GetMapping("/anothertest")
    public  Integer randomEndpoint() {
        return Math.toIntExact(Math.round(Math.random() * 1000));
    }

}