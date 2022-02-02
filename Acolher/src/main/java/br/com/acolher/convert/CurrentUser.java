package br.com.acolher.convert;

import org.springframework.security.core.authority.AuthorityUtils;

import br.com.acolher.model.Perfil;
import br.com.acolher.model.Usuario;





public class CurrentUser extends org.springframework.security.core.userdetails.User{
	
	
	
	 private Usuario user;

	    public CurrentUser(Usuario user) {
	        super(user.getLogin(), user.getSenha(), AuthorityUtils.createAuthorityList(user.getPerfil().toString()));
	        this.user = user;
	    }
	    
	    public Usuario getUser() {
	        return user;
	    }
	    
	    

	    public Integer getId() {
	        return user.getId();
	    }

	    public Perfil getPerfil() {
	        return user.getPerfil();
	    }

}
