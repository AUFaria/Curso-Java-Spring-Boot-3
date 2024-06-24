package br.com.projetospringboot3.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class AnotherDerivedBase implements  Base{

    public AnotherDerivedBase() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String retrieveField() {
        return "Retrieving field from AnotherDerivedBase class";
    }
}
