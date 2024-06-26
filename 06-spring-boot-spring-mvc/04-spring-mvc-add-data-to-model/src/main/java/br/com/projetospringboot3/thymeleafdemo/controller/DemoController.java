package br.com.projetospringboot3.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/hello")
	public String helloWorld(Model model) {

		model.addAttribute("date", java.time.LocalDateTime.now());

		return "helloworld";
	}
}
