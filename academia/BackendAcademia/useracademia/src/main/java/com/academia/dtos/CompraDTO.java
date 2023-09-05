package com.academia.dtos;


	import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.hateoas.RepresentationModel;

import com.academia.model.Compra;
import com.academia.model.Compra.CompraStatus;
import com.academia.model.Item;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	@Setter
	@EqualsAndHashCode(onlyExplicitlyIncluded = true)
	public class CompraDTO extends RepresentationModel<CompraDTO> implements Serializable {

	    private static final long serialVersionUID = 1L;
	    
		@EqualsAndHashCode.Include
		private Integer id;
		private int qntItens;
		private String dataCompra;
		private Float valorTotal;
		private CompraStatus status;
	    private Set<ItemDTO> items = new HashSet<>();

		  public void adItem(ItemDTO item) {
		        this.items.add(item);
		    }
		  
		public CompraDTO(Compra obj) {
			id = obj.getId();
			qntItens = obj.getQntItens();
			dataCompra = obj.getDataCompra();
			valorTotal = obj.getValorTotal();
			status = obj.getStatus();
			if (obj.getItem() != null) {
			    for (Item item : obj.getItem()) {
			       ItemDTO novoItem = new ItemDTO(item);
			       items.add(novoItem);
			    }
			}
		}

	}


