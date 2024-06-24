package br.com.projetospringboot3.springcoredemo.config;

import br.com.projetospringboot3.springcoredemo.common.Base;
import br.com.projetospringboot3.springcoredemo.common.DistinctBase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseConfig {

    @Bean("distinctBeanId")
    public Base distinctBase() {
        return new DistinctBase();
    }
}
