package br.com.projetospringboot3.myproject.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }

}
