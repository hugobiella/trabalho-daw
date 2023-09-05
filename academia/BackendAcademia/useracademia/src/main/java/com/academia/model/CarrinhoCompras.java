package com.academia.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "td_carrinho")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CarrinhoCompras implements Serializable {

    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_carrinho")
	private int id;
    
	@Column(name = "qntitens_carrinho")
	private int qntItens;
	
	@Column(name = "somapreco_carrinho")
	private Float somaPreco;
}
