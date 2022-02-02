package br.com.acolher.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "sala", schema = "db_acolher")
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Sala {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSala;

	@Column(name="entrada")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm" )
	private Date entrada;
	
	
	@Column(name="saida")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm" )
	private Date saida;

	@NotNull
	@Column(name="numero")
	private String numero;
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToOne
	@JoinColumn(name="pk_servico")
	private Servico serv;


	public Sala() {
		
		// TODO Auto-generated constructor stub
	}

}
