package br.com.acolher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.acolher.model.Contas;
import br.com.acolher.repo.ContasDAOImpl;
@Service
@Transactional
public class ContasServiceImpl implements ContasService{

	@Autowired
	ContasDAOImpl contasDAO;
	@Override
	public void inserir(Contas conta) {
		contasDAO.inserir(conta);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Contas> listar() {
		// TODO Auto-generated method stub
		return contasDAO.listar();
	}
	@Override
	@Transactional(readOnly = true)
	public Contas recuperarPorId(Integer id) {
		// TODO Auto-generated method stub
		return contasDAO.recuperarPorId(id);
	}

	@Override
	public void atualizar(Contas conta) {
		contasDAO.atualizar(conta);
		
	}

	@Override
	public void excluir(Integer id) {
		contasDAO.excluir(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Contas> recuperar() {
		// TODO Auto-generated method stub
		return contasDAO.recuperar();
	}

}
