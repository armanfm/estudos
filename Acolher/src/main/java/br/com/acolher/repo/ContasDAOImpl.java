package br.com.acolher.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.acolher.model.Contas;
@Repository
public class ContasDAOImpl implements ContasDAO{
	@PersistenceContext
	private EntityManager em;

	
	
	@Override
	public void inserir(Contas conta) {
		em.persist(conta);
		
	}

	@Override
	public List<Contas> listar() {
		return em.createQuery("select c from Contas c", Contas.class).getResultList();
	}

	@Override
	public Contas recuperarPorId(Integer id) {
		// TODO Auto-generated method stub
		return em.find(Contas.class, id);
	}

	@Override
	public void atualizar(Contas conta) {
		em.merge(conta);
	}

	@Override
	public void excluir(Integer id) {
		em.remove(em.getReference(Contas.class, id));
		
	}

	@Override
	public List<Contas> recuperar() {
		return em.createQuery("select c from Contas c", Contas.class).getResultList();
	}

}
