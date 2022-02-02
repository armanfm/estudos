package br.com.acolher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.acolher.model.Contas;
import br.com.acolher.service.ContasService;

@Controller
@RequestMapping("/contas")
public class ContasController {
	@Autowired
	ContasService contasServ;
	
	@GetMapping("/")
	public String home() {
		return "menu";
	}
	
	@GetMapping("/listar")
	public ModelAndView listar(ModelMap model) {
		List<Contas> contas = contasServ.recuperar();
		model.addAttribute("contas", contas);
		return new ModelAndView("/financeiro/list", model);
	}

	@GetMapping("/cadastrar")
	public String cadastrar(@ModelAttribute("contas") Contas contas) {
		return "/financeiro/add";
	}
	
}
