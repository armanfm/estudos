package br.com.acolher.repo;

import java.util.List;

import br.com.acolher.model.Sala;

public interface SalaDAO {
	
	 public void inserir(Sala sala);
		
	 public List<Sala> listar(Integer servicoId);
	 
	 public Sala recuperarPorId(Integer salaId);

	 public void atualizar(Sala sala);
	
	 public void excluir(Integer salaId);
	
	 public  List<Sala>recuperar();
	
	 public Sala recuperarPorServicoIdESalaId
     (Integer servicoId, Integer salaId);

}
