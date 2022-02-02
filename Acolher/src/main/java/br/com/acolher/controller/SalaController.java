package br.com.acolher.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.acolher.model.Sala;
import br.com.acolher.service.SalaService;

@Controller
@RequestMapping("/salas")
public class SalaController {

	@Autowired
	SalaService salaServ;
	@GetMapping("/")
	
	
	public String home() {
		return "menu";
	}
	
	@GetMapping("/listar")
	public ModelAndView listar(ModelMap model) {
		List<Sala> salas = salaServ.recuperar();
		model.addAttribute("salas", salas);
		return new ModelAndView("/sala/list", model);
	}

	@GetMapping("/cadastrar")
	public String cadastrar(@ModelAttribute("sala") Sala sala) {
		return "/sala/add";
	}
	
	@GetMapping("/adicionar")
	public String adicionar(@ModelAttribute("sala") Sala sala) {
		return "/servico/add";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid @ModelAttribute("sala") Sala sala, BindingResult result,
			RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "/sala/add";
		} else if (sala.getIdSala() == null) {
			salaServ.inserir(sala, null);
			attr.addFlashAttribute("mensagem", "Sala cadastrada com sucesso");
			return "redirect:/salas/listar";
		} else {
			salaServ.atualizar(sala);
			attr.addFlashAttribute("mensagem", "sala atualizada com sucesso.");
			return "redirect:/salas/listar";
		}
	}
	@GetMapping("/{id}/atualizar")
	public ModelAndView alterar(@PathVariable("id") Integer id, ModelMap model) {
		Sala sala= salaServ.recuperarPorId(id);
		model.addAttribute("sala", sala);
		return new ModelAndView("/sala/add", model);
	}

	@PutMapping("/salvar")
	public String atualizar(@Valid @ModelAttribute("sala") Sala sala, BindingResult result,
			RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "/sala/add";
		} else {

			salaServ.atualizar(sala);
			attr.addFlashAttribute("mensagem", "sala atualizada com sucesso.");
			return "redirect:/salas/listar";
		}
	}

	@GetMapping("/{id}/remover")
	public String remover(@PathVariable("id") Integer id, RedirectAttributes attr) {
		salaServ.excluir(id);
		attr.addFlashAttribute("mensagem", "sala excluída com sucesso.");
		return "redirect:/salas/listar";
	}
}
