package br.com.acolher.service;

import java.util.List;

import br.com.acolher.model.CadPessoa;

public interface CadPessoaService {
	public void inserir(CadPessoa pessoa);
	
	 public List<CadPessoa> listar();
	 
	 public CadPessoa recuperarPorId(Integer id);

	 public void atualizar(CadPessoa pessoa);
	
	 public void excluir(Integer id);
	
	 public  List<CadPessoa>recuperar();

	public CadPessoa recuperarPorLogin(String login);


}
