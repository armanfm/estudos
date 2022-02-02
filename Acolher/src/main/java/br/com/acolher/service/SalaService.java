package br.com.acolher.service;

import java.util.List;

import br.com.acolher.model.Sala;

public interface SalaService {
	 public void inserir(Sala sala, Integer servicoId);
		
	 public List<Sala> listar(Integer servicoId);
	 
	 public Sala recuperarPorId(Integer id);

	 public void atualizar(Sala sala);
	
	 public void excluir(Integer id);
	
	 public  List<Sala>recuperar();
	 
	 public Sala recuperarPorLogin(String numero);
	
	 public void atualizarSalaServ(Sala sala,Integer servicoId);
		
	 public void excluirSalaServ(Integer salaId, Integer servicoId);
	 
	 Sala recuperarPorServicoIdESalaId(Integer salaId, Integer servicoId);
}
