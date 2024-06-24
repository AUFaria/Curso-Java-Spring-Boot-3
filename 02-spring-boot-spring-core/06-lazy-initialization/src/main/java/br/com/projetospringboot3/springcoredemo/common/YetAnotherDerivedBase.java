package br.com.projetospringboot3.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class YetAnotherDerivedBase implements Base{

    public YetAnotherDerivedBase() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String retrieveField() {
        return "Retrieving field from YetAnotherDerivedBase class";
    }
}
