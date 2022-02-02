package br.com.acolher.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acolher.model.CadPessoa;



public interface CadPessoaRepoJPA extends JpaRepository<CadPessoa, Long>  {
	public CadPessoa findByNome(String nome);
}
