package com.academia.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.academia.dtos.ItemDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "td_compra")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Compra implements Serializable {

	public enum CompraStatus {
		CANCELADA, ANALISE, PROCESSANDO, APROVADA, ENVIADA, ENTREGUE
	}
    private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Id
	@Column(name = "id_compra")
	private Integer id;
	
	@Column(name = "qntitens_compra")
	private int qntItens;
	
	@Column(name = "data_compra")
	private String dataCompra;
	
	@Column(name = "valor_total")
	private Float valorTotal;
	
	@Column(name= "status")
	private CompraStatus status;
	
	@OneToMany(mappedBy="compra")
    private Set<Item> item = new HashSet<>();

	  public void addUsuarios(Item item) {
	        this.item.add(item);
	    }

	public Compra(Integer id, int qntItens, String dataCompra, Float valorTotal, CompraStatus status) {
		super();
		this.id = id;
		this.qntItens = qntItens;
		this.dataCompra = dataCompra;
		this.valorTotal = valorTotal;
		this.status = status;
		
		
	}
	  
	  
	//relação 1:1 com usuario
}
