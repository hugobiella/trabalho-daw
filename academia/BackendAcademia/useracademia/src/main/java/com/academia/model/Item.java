package com.academia.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "td_item")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item")
	private Integer id;
	@Column(name = "nome_item")
	private String nomeItem;
	@Column(name = "desc_item")
	private String descItem;
	@Column(name = "estoque_item")
	private int estoqueItem;
	@Column(name = "preco_item")
	private Float precoItem;
	@ManyToOne
    @JoinColumn(name="id_compra")
	private Compra compra;
	
	public Item(Integer id, String nomeItem, String descItem, int estoqueItem, Float precoItem) {
		super();
		this.id = id;
		this.nomeItem = nomeItem;
		this.descItem = descItem;
		this.estoqueItem = estoqueItem;
		this.precoItem = precoItem;
	}
	
	
}
