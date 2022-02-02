package br.com.acolher.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.acolher.model.Servico;
@Repository
public class ServicoDAOImpl implements ServicoDAO{
	
	@PersistenceContext
	private EntityManager em;
	@Override
	public void inserir(Servico servico) {
		em.persist(servico);// TODO Auto-generated method stub
		
	}

	@Override
	public List<Servico> listar(Integer p) {
		return em.createQuery("select s from Servico s where s.cliente.idPessoa = :id", Servico.class)
				.setParameter("id", p).getResultList();
	}
	@Override
	public Servico recuperarPorId(Integer id) {
		// TODO Auto-generated method stub
		return em.find(Servico.class, id);
	}

	@Override
	public void atualizar(Servico servico) {
		em.merge(servico);
		
	}

	@Override
	public void excluir(Integer id) {
		em.remove(em.getReference(Servico.class, id));
		
	}

	@Override
	public List<Servico> recuperar() {
		return em.createQuery("select s from Servico s", Servico.class).getResultList();
	}
}
