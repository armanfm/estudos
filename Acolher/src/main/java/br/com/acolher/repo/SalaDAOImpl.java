package br.com.acolher.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.acolher.model.Sala;

@Repository
public class SalaDAOImpl implements SalaDAO {
	@PersistenceContext
	private EntityManager em;

	
	
	
	@Override
	public void inserir(Sala sala) {
		em.persist(sala);
		
	}

	

	@Override
	public Sala recuperarPorId(Integer salaId) {
		return em.find(Sala.class, salaId);
	}

	@Override
	public void atualizar(Sala sala) {
		em.merge(sala);
		
	}

	@Override
	public void excluir(Integer salaId) {
		em.remove(em.getReference(Sala.class,salaId));
		
	}

	@Override
	public List<Sala> recuperar() {
		return em.createQuery("select p from Sala p", Sala.class).getResultList();
	}

	@Override
	public List<Sala> listar(Integer servicoId) {
		 return em.createQuery("select s from Sala s where s.serv.idServico = :servicoId", Sala.class)
		                  .setParameter("servicoId", servicoId)
		                  .getResultList();
		 
		
	}

	@Override
	public Sala recuperarPorServicoIdESalaId(Integer servicoId, Integer salaId) {
		  return em.createQuery("select s from Sala s where s.serv.idServico = :servicoId and s.idSala = :salaId"
				  , Sala.class)
			                  .setParameter("servicoId", servicoId)
			                  .setParameter("salaId", salaId)
			                  .getSingleResult();
	}



	



	
	

}
