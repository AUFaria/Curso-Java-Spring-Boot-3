package br.com.projetospringboot3.mvcsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String showMyLoginPage() {
		return "login";
	}

	@GetMapping("/forbidden")
	public String showAccessDenied() {
		return "forbidden";
	}
}
