package br.com.acolher.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.acolher.model.CadPessoa;

@Repository
public class CadPessoaDAOImpl implements CadPessoaDAO{
	@PersistenceContext
	private EntityManager em;

	@Override
	public void inserir(CadPessoa pessoa) {
		em.persist(pessoa);
		
	}

	@Override
	public List<CadPessoa> listar() {
		return em.createQuery("select p from CadPessoa p", CadPessoa.class).getResultList();
	}

	@Override
	public CadPessoa recuperarPorId(Integer id) {
		return em.find(CadPessoa.class, id);
	}

	@Override
	public void atualizar(CadPessoa pessoa) {
		em.merge(pessoa);
		
	}

	@Override
	public void excluir(Integer id) {
		em.remove(em.getReference(CadPessoa.class, id));
		
	}

	@Override
	public List<CadPessoa> recuperar() {
		return em.createQuery("select p from CadPessoa p", CadPessoa.class).getResultList();
	}


	

}
