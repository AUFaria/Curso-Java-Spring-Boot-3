package br.com.projetospringboot3.myproject.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

    @Value("${customprop.firstProp}")
    private String firstProp;

    @Value("${customprop.secondProp}")
    private String secondProp;

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

    @GetMapping("/customprops")
    public String customProperties() {
        return "firstProp: " + firstProp + ", " + "secondProp: " + secondProp;
    }

}