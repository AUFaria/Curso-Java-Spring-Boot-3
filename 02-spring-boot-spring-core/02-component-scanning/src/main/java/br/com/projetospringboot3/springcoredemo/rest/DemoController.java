package br.com.projetospringboot3.springcoredemo.rest;

import br.com.projetospringboot3.springcoredemo.common.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Base baseClass;

    @Autowired
    public DemoController(Base targetBaseClass) {
        baseClass = targetBaseClass;
    }

    @GetMapping("/getfield")
    public  String getField() {
        return baseClass.retrieveField();
    }
}
