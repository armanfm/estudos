package br.com.acolher.service;

import java.util.List;

import br.com.acolher.model.Usuario;


public interface UsuarioService {
	

	
	 public void inserir(Usuario user);
	
	 public List<Usuario> listar();
	 
	 public Usuario recuperarPorId(Integer id);

	 public void atualizar(Usuario user);
	
	 public void excluir(Integer id);
	 
	 public  List<Usuario>recuperar();
	 

	 public Usuario recuperarPorLogin(String login);

	public void registerLastLogin(Usuario user);
	 
	 
	

}
