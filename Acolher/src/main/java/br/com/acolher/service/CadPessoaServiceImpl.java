package br.com.acolher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.acolher.model.CadPessoa;
import br.com.acolher.repo.CadPessoaDAOImpl;
import br.com.acolher.repo.CadPessoaRepoJPA;
@Service
@Transactional
public class CadPessoaServiceImpl implements CadPessoaService{
	@Autowired
	CadPessoaDAOImpl cadPessoDAO;
	@Autowired
	CadPessoaRepoJPA cadPessoaRRepo;
	
	
	@Override
	public void inserir(CadPessoa pessoa) {
		cadPessoDAO.inserir(pessoa);
		
	}
	@Override
	@Transactional(readOnly = true)
	public List<CadPessoa> listar() {
		// TODO Auto-generated method stub
		return cadPessoDAO.listar();
	}
	@Override
	@Transactional(readOnly = true)
	public CadPessoa recuperarPorId(Integer id) {
		// TODO Auto-generated method stub
		return cadPessoDAO.recuperarPorId(id);
	}
	@Override
	public void atualizar(CadPessoa pessoa) {
		cadPessoDAO.atualizar(pessoa);
		
	}
	@Override
	public void excluir(Integer id) {
		cadPessoDAO.excluir(id);
		
	}
	@Override
	@Transactional(readOnly = true)
	public List<CadPessoa> recuperar() {
		// TODO Auto-generated method stub
		return cadPessoDAO.recuperar();
	}

	
	@Override

	
	public CadPessoa recuperarPorLogin(String nome) {
		// TODO Auto-generated method stub
		return cadPessoaRRepo.findByNome(nome);
	}
	
	


	
}
