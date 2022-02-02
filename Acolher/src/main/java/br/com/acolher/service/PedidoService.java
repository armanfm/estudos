package br.com.acolher.service;

import java.util.List;

import br.com.acolher.model.Pedido;

public interface PedidoService {
	
	public void inserir(Pedido pedido);
	
	 public List<Pedido> listar();
	 
	 public Pedido recuperarPorId(Integer id);

	 public void atualizar(Pedido pedido);
	
	 public void excluir(Integer id);
	
	 public  List<Pedido>recuperar();

}
