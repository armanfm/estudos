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

import br.com.acolher.model.CadPessoa;
import br.com.acolher.service.CadPessoaService;


@Controller
@RequestMapping("/pessoas")
public class CadPessoaController {
	
	@Autowired
	CadPessoaService cadPessoaServ;
	
	
	@GetMapping("/")
	public String home() {
		return "menu";
	}
	
	@GetMapping("/listar")
	public ModelAndView listar(ModelMap model) {
		List<CadPessoa> pessoas = cadPessoaServ.recuperar();
		model.addAttribute("pessoas", pessoas);
		return new ModelAndView("/pessoa/list", model);
	}

	
	@GetMapping("/cadastrar")
	public String cadastrar(@ModelAttribute("pessoa") CadPessoa pessoa) {
		return "/pessoa/add";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid @ModelAttribute("pessoa") CadPessoa pessoa, BindingResult result,
			RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "/pessoa/add";
		} else if (pessoa.getIdPessoa() == null) {
			cadPessoaServ.inserir(pessoa);
			attr.addFlashAttribute("mensagem", "Sala cadastrada com sucesso");
			return "redirect:/pessoas/listar";
		} else {
			cadPessoaServ.atualizar(pessoa);
			attr.addFlashAttribute("mensagem", "sala atualizada com sucesso.");
			return "redirect:/pessoas/listar";
		}
	}
	@GetMapping("/{id}/atualizar")
	public ModelAndView alterar(@PathVariable("id") Integer id, ModelMap model) {
		CadPessoa pessoa= cadPessoaServ.recuperarPorId(id);
		model.addAttribute("pessoa", pessoa);
		return new ModelAndView("/pessoa/add", model);
	}

	@PutMapping("/salvar")
	public String atualizar(@Valid @ModelAttribute("pessoa") CadPessoa pessoa, BindingResult result,
			RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "/pessoa/add";
		} else {

			cadPessoaServ.atualizar(pessoa);
			attr.addFlashAttribute("mensagem", "sala atualizada com sucesso.");
			return "redirect:/pessoas/listar";
		}
	}

	@GetMapping("/{id}/remover")
	public String remover(@PathVariable("id") Integer id, RedirectAttributes attr) {
		cadPessoaServ.excluir(id);
		attr.addFlashAttribute("mensagem", "sala excluída com sucesso.");
		return "redirect:/pessoas/listar";
	}

}
