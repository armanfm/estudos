package br.com.acolher.service;

import java.util.List;

import br.com.acolher.model.Servico;

public interface ServicoService {
	 public void inserir(Servico servico);
		
	 public List<Servico> listar(Integer p);
	 
	 public Servico recuperarPorId(Integer id);
	 

	 public void atualizar(Servico servico);
	
	 public void excluir(Integer id);
	
	 public  List<Servico>recuperar();

}
