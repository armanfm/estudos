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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="usuario" , schema="db_acolher")
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Usuario  {

	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	@Size(min=4, max=40)
	@Column(name="login")
  	private String login;
	@NotNull
	@Column(name="senha" ,nullable = true)
	private String senha;
	@Column(name="perfil")
	@Enumerated(EnumType.STRING)
	private Perfil perfil;
	@Column(name="last_login")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLogin;
	@Transient
	private String senhaRepeat;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	
	}

}
