package br.com.acolher.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.acolher.model.Pedido;
@Repository
public class PedidoDAOImpl implements PedidoDAO{
	@PersistenceContext
	private EntityManager em;
	@Override
	public void inserir(Pedido pedido) {
		em.persist(pedido);
		
	}

	@Override
	public List<Pedido> listar() {
		return em.createQuery("select p from Pedido p", Pedido.class).getResultList();
	}

	@Override
	public Pedido recuperarPorId(Integer id) {
		return em.find(Pedido.class, id);
	}

	@Override
	public void atualizar(Pedido pedido) {
		em.merge(pedido);
		
	}

	@Override
	public void excluir(Integer id) {
		em.remove(em.getReference(Pedido.class, id));
		
	}

	@Override
	public List<Pedido> recuperar() {
		return em.createQuery("select p from Pedido p", Pedido.class).getResultList();
	}

}
