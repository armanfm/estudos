package br.com.acolher.service;

import java.util.List;

import br.com.acolher.model.Contas;

public interface ContasService {
	public void inserir(Contas conta);
	
	 public List<Contas> listar();
	 
	 public Contas recuperarPorId(Integer id);

	 public void atualizar(Contas conta);
	
	 public void excluir(Integer id);
	
	 public  List<Contas>recuperar();
}
