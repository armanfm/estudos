package br.com.acolher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.acolher.model.Usuario;
import br.com.acolher.repo.UserRepoJPA;
import br.com.acolher.repo.UsuarioDAO;





@Service
@Transactional

public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioDAO userDAO;

	@Autowired
	UserRepoJPA userRepo;
	
	@Override
	
	public void inserir(Usuario user) {
		
	
	
			
			String senha = new BCryptPasswordEncoder().encode(user.getSenha());

			user.setSenha(senha);

			userDAO.inserir(user);
			
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> listar() {

		return userDAO.listar();
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario recuperarPorId(Integer id) {
		// TODO Auto-generated method stub
		return  userDAO.recuperarPorId(id);
	}

	@Override
	
	public void atualizar(Usuario user) {
		
		String senha = new BCryptPasswordEncoder().encode(user.getSenha());

		user.setSenha(senha);

	
		userDAO.atualizar(user);
		
	}

	@Override
	
	public void excluir(Integer id) {
		 userDAO.excluir(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> recuperar() {
		return userDAO.recuperar();
	}



	@Override
	public Usuario recuperarPorLogin(String login) {
		return  userRepo.findByLogin(login);
	}

	@Override
	public void registerLastLogin(Usuario user) {
		userRepo.saveAndFlush(user);
		
	}

}