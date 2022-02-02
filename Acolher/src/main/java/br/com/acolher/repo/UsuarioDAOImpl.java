package br.com.acolher.repo;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import br.com.acolher.model.Usuario;




@Repository

public  class UsuarioDAOImpl  implements UsuarioDAO {
	
	@PersistenceContext
	private EntityManager em;


	@Override
	public void inserir(Usuario user) {
		
	
		String senha = new BCryptPasswordEncoder().encode(user.getSenha());
	
		user.setSenha(senha);
	
		em.persist(user);
		
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return em.createQuery("select u from usuario u", Usuario.class).getResultList();
	}

	@Override
	 public Usuario recuperarPorId(Integer id){
		return em.find(Usuario.class, id);
	}

	@Override
	public void atualizar(Usuario user) {
		em.merge(user);
		
	}

	@Override
	public void excluir(Integer id) {
		em.remove(em.getReference(Usuario.class, id));
		
	}

	@Override
	public  List<Usuario>recuperar(){
		return em.createQuery("select u from Usuario u",
		        Usuario.class).getResultList();
	}



	


	

	



}
