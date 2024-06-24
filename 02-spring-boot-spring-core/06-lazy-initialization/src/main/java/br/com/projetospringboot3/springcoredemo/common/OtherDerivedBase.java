package br.com.projetospringboot3.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class OtherDerivedBase implements Base{

    public OtherDerivedBase() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String retrieveField() {
        return "Retrieving field from OtherDerivedBase class";
    }
}
