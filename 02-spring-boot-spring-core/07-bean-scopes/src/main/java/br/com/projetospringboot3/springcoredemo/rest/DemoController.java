package br.com.projetospringboot3.springcoredemo.rest;

import br.com.projetospringboot3.springcoredemo.common.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Base firstBaseClass;
    private Base secondBaseClass;

    @Autowired
    public DemoController(
            @Qualifier("otherDerivedBase") Base firstTargetBaseClass,
            @Qualifier("otherDerivedBase") Base secondTargetBaseClass
    ) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        firstBaseClass = firstTargetBaseClass;
        secondBaseClass = secondTargetBaseClass;
    }

    @GetMapping("/getfield")
    public  String getField() {
        return firstBaseClass.retrieveField();
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans: firstBaseClass == secondBaseClass, " + (firstBaseClass == secondBaseClass);
    }
}
