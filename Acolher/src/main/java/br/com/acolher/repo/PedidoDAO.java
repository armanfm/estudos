package br.com.acolher.repo;

import java.util.List;

import br.com.acolher.model.Pedido;



public interface PedidoDAO {
	
	 public void inserir(Pedido pedido);
		
	 public List<Pedido> listar();
	 
	 public Pedido recuperarPorId(Integer id);

	 public void atualizar(Pedido pedido);
	
	 public void excluir(Integer id);
	
	 public  List<Pedido>recuperar();


}
