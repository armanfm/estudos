package br.com.acolher.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name="servico" , schema="db_acolher")
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Servico {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idServico;
	
	@Column(name="entrada")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm" )
	private Date entrada;
	
	
	@Column(name="saida")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm" )
	private Date saida;
	
	@Column(name="desconto")
	private Double desconto;
	
	@Column(name="total_hora")
	private Double totalHora;

	@Column(name="valor_total")
	private Double valorTotal;
	

	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private CadPessoa cliente;

	@ManyToOne
	@JoinColumn(name="pk_sala")
	private Sala sala;

	public Servico() {
	
	}
	

   


}
