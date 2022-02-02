package br.com.acolher.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name="cad_pessoa" , schema="db_acolher")
@Getter
@Setter
@ToString
@AllArgsConstructor
public class CadPessoa {
	
	


	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPessoa;
	

	@Size(min=20, max=100)
	@Column(name="nome")
	private String nome;
	

	@Size(min=3, max=20)
	@Column(name="telefone")
	private String telefone;
	

	@Size(min=12, max=13)
	@Column(name="cpf")
	private String cpf;
	

	@Size(min=1, max=10)
	@Column(name="numero")
	private String numero;

	@Size(min=0, max=10)
	@Column(name="complemento")
	private String complemento;
	
	
	@Size(min=2, max=10)
	@Column(name="cidade")
	private String cidade;
	

	@Size(min=10, max=100)
	@Column(name="endereco")
	private String endereco;

	@Size(min=2, max=2)
	@Column(name="uf")
	private String uf;
	
	
	@Size(min=2, max=30)
	@Column(name="bairro")
	private String bairro;
	

	@Size(min=1, max=55)
	@Column(name="email")
	private String email;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name="data_nascimento")
	private Date dataNasc;

	@Size(min=9, max=10)
	@Column(name="cep")
	private String cep;
	

	@Column(name="comprovante_residencia")
	private String imagemResidencia;
	

	@Column(name="comprovante_renda")
	private String imagemRegistroProf;
	
	@Column(name="tipo_pessoa")
	@Enumerated(EnumType.STRING)
	private TipoPessoa tipo;

	public CadPessoa() {
		
	}


	
}
