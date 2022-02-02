package br.com.acolher.controller;

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
@RequestMapping("/servicos/{servicoId}/salas")
public class SalaServicoController {
	
	@Autowired
    private SalaService salaServ;;

    @GetMapping("/listar")
    public ModelAndView listar(@PathVariable("servicoId") Integer servicoId, ModelMap model) {
        model.addAttribute("sala", salaServ.listar(servicoId));
        model.addAttribute("servicoId", servicoId);
        return new ModelAndView("/sala/list", model);
    }
    @GetMapping("/cadastrar")
    public String preSalvar(@ModelAttribute("sala") Sala sala, @PathVariable("servicoId") Integer servocoId) {
        return "/sala/add";
    }
    @PostMapping("/salvar")
    public String salvar(@PathVariable("servicoId") Integer servicoId, @Valid @ModelAttribute("Sala") Sala sala, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/sala/add";
        }
        salaServ.inserir(sala, servicoId);
        attr.addFlashAttribute("mensagem", "Sala adicionada");
        return "redirect:/servicos/" + servicoId + "/salas/listar";
    }

    
    @GetMapping("/{salaId}/atualizar")
    public ModelAndView preAtualizar(@PathVariable("servicoId") Integer servicoId, @PathVariable("salaId") Integer salaId, ModelMap model) {
        Sala sala = salaServ.recuperarPorServicoIdESalaId(salaId, servicoId);
        model.addAttribute("sala", sala);
        model.addAttribute("servicoId", servicoId);
        return new ModelAndView("/sala/add", model);
    }
    
    
    @PutMapping("/salvar")
    public String atualizar(@PathVariable("servico") Integer servicoId, @Valid @ModelAttribute("sala") Sala sala, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/sala/add";
        }

        salaServ.atualizarSalaServ(sala, servicoId);
        attr.addFlashAttribute("mensagem", "sala atualizada com sucesso.");
        return "redirect:/servicos/" + servicoId + "/salas/listar";
    }

    @GetMapping("/{salaId}/remover")
    public String remover(@PathVariable("servicoId") long servicoId, @PathVariable("salaId") Integer salaId, RedirectAttributes attr) {
       salaServ.excluirSalaServ(salaId, salaId);
        attr.addFlashAttribute("mensagem", "sala excluída com sucesso.");
        return "redirect:/servicos/" + servicoId + "/salas/listar";
    }

}
