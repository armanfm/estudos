package br.com.acolher.controller;


import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import br.com.acolher.convert.CurrentUser;



@ControllerAdvice
public class CurrentUserController {



    @ModelAttribute("currentUser")
    public CurrentUser getCurrentUserAdvice(Authentication authentication) {


        return (authentication == null) ? null : (CurrentUser) authentication.getPrincipal();
    }
}
