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
import br.com.acolher.model.Sala;
import br.com.acolher.model.Servico;
import br.com.acolher.service.CadPessoaService;
import br.com.acolher.service.SalaService;
import br.com.acolher.service.ServicoService;


@Controller
@RequestMapping("/servicos")
public class ServicoController {
	@Autowired
	ServicoService servicoServ;
	@Autowired
	CadPessoaService pessoaServ;
	@Autowired
	SalaService salaServ;
	
		

	
	@GetMapping("/listar")
	public ModelAndView listar(ModelMap model) {
		List<Servico> servicos = servicoServ.recuperar();
		model.addAttribute("servicos", servicos);
		return new ModelAndView("/servico/list", model);
		
		
	}
	
	
	

	@GetMapping("/cadastrar")
	public String cadastrar(@ModelAttribute("servico") Servico servico, ModelMap model) {
		List<CadPessoa> clientes = pessoaServ.recuperar();
		model.addAttribute("clientes", clientes);	
		return "/servico/add";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid @ModelAttribute("servico") Servico servico, BindingResult result,
			RedirectAttributes attr, CadPessoa cliente) {

		if (result.hasErrors()) {
			return "/servico/add";
		} else if (servico.getIdServico() == null) {
				System.out.println("teste");
			servicoServ.inserir(servico);
			attr.addFlashAttribute("mensagem", "Serviço cadastrado com sucesso");
			return "redirect:/servicos/listar";
		} else {
			servicoServ.atualizar(servico);
			attr.addFlashAttribute("mensagem", "Serviço atualizada com sucesso.");
			return "redirect:/servicos/listar";
		}
	}
	@GetMapping("/{id}/atualizar")
	public ModelAndView alterar(@PathVariable("id") Integer id, ModelMap model) {
		Servico servico= servicoServ.recuperarPorId(id);
		model.addAttribute("servico", servico);
		return new ModelAndView("/sevico/add", model);
	}

	@PutMapping("/salvar")
	public String atualizar(@Valid @ModelAttribute("servico") Servico servico, BindingResult result,
			RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "/servico/add";
		} else {

			servicoServ.atualizar(servico);
			attr.addFlashAttribute("mensagem", "sala atualizada com sucesso.");
			return "redirect:/servicos/listar";
		}
	}

	@GetMapping("/{id}/remover")
	public String remover(@PathVariable("id") Integer id, RedirectAttributes attr) {
		servicoServ.excluir(id);
		attr.addFlashAttribute("mensagem", "Serviço excluído com sucesso.");
		return "redirect:/servicos/listar";
	}
	

	
	
}
