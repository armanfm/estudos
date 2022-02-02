package br.com.acolher.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name = "pedido", schema = "db_acolher")
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Pedido {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idPedido;

	@Column(name="valor_pedido")
	private Double valor;

	@Column(name="descricao")
	private String descricao;
	@Column(name="comprovante")
	private String comprovante;
	
	@ManyToOne
	@JoinColumn(name="id_fornecedor")
	private CadPessoa fornecedor;

	public Pedido() {
	}

	
}
