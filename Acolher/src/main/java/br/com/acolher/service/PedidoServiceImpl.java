package br.com.acolher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.acolher.model.Pedido;
import br.com.acolher.repo.PedidoDAOImpl;
@Service
@Transactional
public class PedidoServiceImpl implements PedidoService {
	@Autowired
	PedidoDAOImpl pedidoDAO;
	@Override
	public void inserir(Pedido pedido) {
		
	
		
		
		pedido.setFornecedor( pedido.getFornecedor());
		pedidoDAO.inserir(pedido);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pedido> listar() {
		// TODO Auto-generated method stub
		return pedidoDAO.listar();
	}

	@Override
	@Transactional(readOnly = true)
	public Pedido recuperarPorId(Integer id) {
		// TODO Auto-generated method stub
		return pedidoDAO.recuperarPorId(id);
	}

	@Override
	public void atualizar(Pedido pedido) {
		pedidoDAO.atualizar(pedido);
		
	}

	@Override
	public void excluir(Integer id) {
		pedidoDAO.excluir(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pedido> recuperar() {
		// TODO Auto-generated method stub
		return pedidoDAO.recuperar();
	}

}
