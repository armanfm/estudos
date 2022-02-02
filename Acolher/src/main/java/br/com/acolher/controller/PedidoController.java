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

import br.com.acolher.model.Pedido;
import br.com.acolher.service.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {
	@Autowired
	PedidoService pedidoServ;
	@GetMapping("/")
	public String home() {
		return "menu";
	}
	
	@GetMapping("/listar")
	public ModelAndView listar(ModelMap model) {
		List<Pedido> pedidos = pedidoServ.recuperar();
		model.addAttribute("pedidos", pedidos);
		return new ModelAndView("/pedido/list", model);
	}


	@GetMapping("/cadastrar")
	public String cadastrar(@ModelAttribute("pedido") Pedido pedido) {
		return "/pedido/add";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid @ModelAttribute("pedido") Pedido pedido, BindingResult result,
			RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "/pedido/add";
		} else if (pedido.getIdPedido() == null) {
			pedidoServ.inserir(pedido);
			attr.addFlashAttribute("mensagem", "Sala cadastrada com sucesso");
			return "redirect:/pedidos/listar";
		} else {
			pedidoServ.atualizar(pedido);
			attr.addFlashAttribute("mensagem", "sala atualizada com sucesso.");
			return "redirect:/pedidos/listar";
		}
	}
	
	@GetMapping("/{id}/atualizar")
	public ModelAndView alterar(@PathVariable("id") Integer id, ModelMap model) {
		Pedido pedido= 	pedidoServ.recuperarPorId(id);
		model.addAttribute("pedido", pedido);
		return new ModelAndView("/pedido/add", model);
	}

	@PutMapping("/salvar")
	public String atualizar(@Valid @ModelAttribute("pedido") Pedido pedido, BindingResult result,
			RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "/pedido/add";
		} else {

			pedidoServ.atualizar(pedido);
			attr.addFlashAttribute("mensagem", "sala atualizada com sucesso.");
			return "redirect:/pedidos/listar";
		}
	}

	@GetMapping("/{id}/remover")
	public String remover(@PathVariable("id") Integer id, RedirectAttributes attr) {
		pedidoServ.excluir(id);
		attr.addFlashAttribute("mensagem", "sala excluída com sucesso.");
		return "redirect:/pedidos/listar";
	}

	
	
}
