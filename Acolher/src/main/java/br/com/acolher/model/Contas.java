package br.com.acolher.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="contas" , schema="db_acolher")
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Contas {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idContas;

	@Column(name="situacao")
	private Situacao situacao;

	@Column(name="valor_total")
	private Double ValorTotal;

	@Column(name="valor_mes")
	private Double valorparcial;

	@Column(name="tipo")
	private Tipo tipo;
	
	@ManyToOne
	@JoinColumn(name="id_pedido")
	private Pedido pedido;
	@ManyToOne
	@JoinColumn(name="id_servico")
	private Servico servico;
	

}
