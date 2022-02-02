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

import br.com.acolher.model.Usuario;
import br.com.acolher.service.UsuarioService;

@Controller
@RequestMapping("/")
public class UsuarioController {

	@Autowired
	UsuarioService userServ;

	@GetMapping("/")
	public String home() {
		return "menu";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/usuarios/listar")
	public ModelAndView listar(ModelMap model) {
		List<Usuario> usuarios = userServ.recuperar();
		model.addAttribute("usuarios", usuarios);
		return new ModelAndView("/usuario/list", model);
	}

	@GetMapping("usuarios/cadastrar")
	public String cadastrar(@ModelAttribute("usuario") Usuario user) {
		return "/usuario/add";
	}

	@PostMapping("usuarios/salvar")
	public String salvar(@Valid @ModelAttribute("usuario") Usuario user, BindingResult result,
			RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "/usuario/add";
		} else if (user.getId() == null) {
			userServ.inserir(user);
			attr.addFlashAttribute("mensagem", "usuário cadastrado com sucesso");
			return "redirect:/usuarios/listar";
		} else {
			userServ.atualizar(user);
			attr.addFlashAttribute("mensagem", "usuário atualizado com sucesso.");
			return "redirect:/usuarios/listar";
		}

	}

	@GetMapping("usuarios/{id}/atualizar")
	public ModelAndView alterar(@PathVariable("id") Integer id, ModelMap model) {
		Usuario usuario = userServ.recuperarPorId(id);
		model.addAttribute("usuario", usuario);
		return new ModelAndView("/usuario/add", model);
	}

	@PutMapping("/usuarios/salvar")
	public String atualizar(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result,
			RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "/usuario/add";
		} else {

			userServ.atualizar(usuario);
			attr.addFlashAttribute("mensagem", "usuário atualizado com sucesso.");
			return "redirect:/usuarios/listar";
		}
	}

	@GetMapping("/usuarios/{id}/remover")
	public String remover(@PathVariable("id") Integer id, RedirectAttributes attr) {
		userServ.excluir(id);
		attr.addFlashAttribute("mensagem", "usuário excluído com sucesso.");
		return "redirect:/usuarios/listar";
	}

}
