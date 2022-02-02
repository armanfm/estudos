package br.com.acolher.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.acolher.convert.CurrentUser;
import br.com.acolher.model.Usuario;


@Service
public class CurrentUserDetailsService implements UserDetailsService, ApplicationListener<AuthenticationSuccessEvent> {

	

	@Autowired
	private UsuarioService userService;

	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		
		

		Usuario user;		
		try {			
            user = userService.recuperarPorLogin(login);
        } catch (Exception ex) {
          
            throw new UsernameNotFoundException("Was not found user");
        }

		return new CurrentUser(user);
	}

	@Override
	public void onApplicationEvent(AuthenticationSuccessEvent event) {
		  String userName = ((UserDetails) event.getAuthentication().getPrincipal()).getUsername();
	        
	        Usuario user = userService.recuperarPorLogin(userName);
	        user.setLastLogin(new Date());
	        userService.registerLastLogin(user);
		
	}
	
	
}
