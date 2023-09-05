package com.academia.dtos;


	import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.academia.model.Compra;
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
	public class ItemDTO extends RepresentationModel<ItemDTO> implements Serializable {

		private static final long serialVersionUID = 1L;

		@EqualsAndHashCode.Include
		private Integer id;
		private String nomeItem;
		private String descItem;
		private int estoqueItem;
		private Float precoItem;
		private Compra compra;

		
		public ItemDTO(Item obj) {
			id = obj.getId();
			nomeItem = obj.getNomeItem();
			descItem = obj.getDescItem();
			estoqueItem = obj.getEstoqueItem();
			precoItem = obj.getPrecoItem();
			compra = null;
		}

	}


