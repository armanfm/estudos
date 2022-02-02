package br.com.acolher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.acolher.model.Servico;
import br.com.acolher.repo.ServicoDAOImpl;
@Service
@Transactional
public class ServicoServiceImpl implements ServicoService {

	@Autowired
	ServicoDAOImpl servDAO;
	@Autowired
	CadPessoaServiceImpl pessoaServ;
	
	
	
	@Override
	public void inserir(Servico servico) {
		
		
		
		
		servDAO.inserir(servico);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Servico> listar(Integer p) {

		return servDAO.listar(p);
	}

	@Override
	@Transactional(readOnly = true)
	public Servico recuperarPorId(Integer id) {
				return servDAO.recuperarPorId(id);
	}

	@Override
	public void atualizar(Servico servico) {
		servDAO.atualizar(servico);
		
	}

	@Override
	public void excluir(Integer id) {
		servDAO.excluir(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Servico> recuperar() {
		// TODO Auto-generated method stub
		return servDAO.recuperar();
	}

	

}
