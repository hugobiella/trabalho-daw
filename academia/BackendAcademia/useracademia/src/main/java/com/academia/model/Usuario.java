package com.academia.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "td_usuario")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario {

	public enum Categoria {
		CLIENTE, ADMINISTRADOR, INSTRUTOR
	}
	
    private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Id
	@Column(name = "id_usuario")
	private Integer id;
	@Column(name = "nome_usuario")
	private String nome;
	@Column(name = "email_usuario")
	private String email;
	@Column(name = "senha_usuario")
	private String senha;
	@Column(name = "categoria_usuario")
	private Categoria categoria;
	@ManyToOne
    @JoinColumn(name="id_plano")
	private Plano plano;
	
	public Usuario(Integer id, String nome, String email, String senha, Categoria categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.categoria = categoria;
	}
	
}
