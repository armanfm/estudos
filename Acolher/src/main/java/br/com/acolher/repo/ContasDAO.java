package br.com.acolher.repo;

import java.util.List;

import br.com.acolher.model.Contas;



public interface ContasDAO {
	public void inserir(Contas conta);
	
	 public List<Contas> listar();
	 
	 public Contas recuperarPorId(Integer id);

	 public void atualizar(Contas conta);
	
	 public void excluir(Integer id);
	
	 public  List<Contas>recuperar();

}
