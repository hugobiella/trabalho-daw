package com.academia.model;

import java.io.Serializable;
import java.util.HashSet;
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
@Table(name = "td_plano")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity

public class Plano implements Serializable{

    private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_plano")
	private Integer id;
    @Column(name = "nome_plano")
	private String nomePlano;
	@Column(name = "valor_plano")
	private String valorPlano;
	@Column(name = "desc_plano")
	private String descPlano;
	
	@OneToMany(mappedBy="plano")
    private Set<Usuario> usuarios = new HashSet<>();

	  public void addUsuarios(Usuario usuario) {
	        this.usuarios.add(usuario);
	    }
	  
	public Plano(Integer id, String nomePlano, String valorPlano, String descPlano) {
		super();
		this.id = id;
		this.nomePlano = nomePlano;
		this.valorPlano = valorPlano;
		this.descPlano = descPlano;
	}

	
}
