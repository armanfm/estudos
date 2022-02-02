package br.com.acolher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.acolher.model.Sala;
import br.com.acolher.model.Status;
import br.com.acolher.repo.SalaDAOImpl;
import br.com.acolher.repo.SalaRepoJPA;
import br.com.acolher.repo.ServicoDAOImpl;
@Service
@Transactional
public class SalaServiceImpl implements SalaService {

	@Autowired
	SalaDAOImpl salaDAO;
	@Autowired
	SalaRepoJPA salaRepo;

	@Autowired
	ServicoService servicoServ;
	
	@Override
	public void inserir(Sala sala, Integer servicoId) {
		
			
		sala.setServ(servicoServ.recuperarPorId(servicoId));
		salaDAO.inserir(sala);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Sala> listar(Integer servicoId) {
		return salaDAO.listar(servicoId);
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(readOnly = true)
	public Sala recuperarPorId(Integer id) {
		// TODO Auto-generated method stub
		return salaDAO.recuperarPorId(id);
	}

	@Override
	public void atualizar(Sala sala) {
		salaDAO.atualizar(sala);
		
	}

	@Override
	public void excluir(Integer id) {
		salaDAO.excluir(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Sala> recuperar() {
		// TODO Auto-generated method stub
		return salaDAO.recuperar();
	}

	@Override
	@Transactional(readOnly = true)
	public Sala recuperarPorLogin(String numero) {
		// TODO Auto-generated method stub
		
		return salaRepo.findByNumero(numero);
	}

	@Override
	public void atualizarSalaServ(Sala sala, Integer servicoId) {
		   sala.setServ(servicoServ.recuperarPorId(servicoId));
		salaDAO.atualizar(sala);
		
	}

	@Override
	public void excluirSalaServ(Integer salaId, Integer servicoId) {
		salaDAO.excluir(recuperarPorServicoIdESalaId(salaId,servicoId).getIdSala());
	}
	@Override
	@Transactional(readOnly = true)
	public Sala recuperarPorServicoIdESalaId(Integer salaId, Integer servicoId) {
		// TODO Auto-generated method stub
		 return salaDAO.recuperarPorServicoIdESalaId(servicoId, salaId);
	}
	
	

}
