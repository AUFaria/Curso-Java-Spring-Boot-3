package br.com.projetospringboot3.springcoredemo.common;

public class DistinctBase implements Base{

    public DistinctBase() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String retrieveField() {
        return "Retrieving field from DistinctBase class";
    }
}
