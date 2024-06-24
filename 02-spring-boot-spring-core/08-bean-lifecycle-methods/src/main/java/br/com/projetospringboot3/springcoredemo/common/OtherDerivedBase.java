package br.com.projetospringboot3.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class OtherDerivedBase implements Base{

    public OtherDerivedBase() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @PostConstruct
    public void initCustomMethod() {
        System.out.println("@PostConstruct lifecycle method: " + getClass().getSimpleName());
    }

    @PreDestroy
    public void destroyCustomMethod() {
        System.out.println("@PreDestroy lifecycle method: " + getClass().getSimpleName());
    }

    @Override
    public String retrieveField() {
        return "Retrieving field from OtherDerivedBase class";
    }
}
