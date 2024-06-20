package br.com.projetospringboot3.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class DerivedBase implements Base{

    @Override
    public String retrieveField() {
        return "Retrieving field from DerivedBase class";
    }
}
