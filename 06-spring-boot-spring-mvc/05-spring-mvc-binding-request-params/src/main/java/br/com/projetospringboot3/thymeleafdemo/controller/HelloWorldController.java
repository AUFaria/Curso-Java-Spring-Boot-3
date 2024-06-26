package br.com.projetospringboot3.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	@RequestMapping("/processForm/v2")
	public String toUpperCaseFormDataTransform(HttpServletRequest request, Model model) {

		String name = request.getParameter("studentName");

		name = name.toUpperCase();

		String result = "ATTENTION! " + name;

		model.addAttribute("message", result);

		return "helloworld";
	}

	@RequestMapping("/processForm/v3")
	public String handleRequestParamExample(
			@RequestParam("studentName") String name,
			Model model
	) {

//		String name = request.getParameter("studentName");

		name = name.toUpperCase();

		String result = "ATTENTION! " + name;

		model.addAttribute("message", result);

		return "helloworld";
	}
}
