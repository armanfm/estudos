package br.com.acolher.repo;

import java.util.List;

import br.com.acolher.model.CadPessoa;



public interface CadPessoaDAO {
	 public void inserir(CadPessoa pessoa);
		
	 public List<CadPessoa> listar();
	 
	 public CadPessoa recuperarPorId(Integer id);

	 public void atualizar(CadPessoa user);
	
	 public void excluir(Integer id);
	
	 public  List<CadPessoa>recuperar();



}
