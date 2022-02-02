package br.com.acolher.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acolher.model.Sala;

public interface SalaRepoJPA  extends JpaRepository<Sala, Long> {
	
	public Sala findByNumero(String nome);

}
