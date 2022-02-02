package br.com.acolher.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acolher.model.Usuario;





public interface UserRepoJPA extends JpaRepository<Usuario, Long> {
	
	
	public Usuario findByLogin(String email);
}
