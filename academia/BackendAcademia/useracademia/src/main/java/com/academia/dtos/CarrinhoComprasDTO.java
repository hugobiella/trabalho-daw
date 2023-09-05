package com.academia.dtos;


	import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.academia.model.CarrinhoCompras;

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
	public class CarrinhoComprasDTO extends RepresentationModel<CarrinhoComprasDTO> implements Serializable {

		private static final long serialVersionUID = 1L;

	    @EqualsAndHashCode.Include
		private int id;
		private int qntItens;
		private Float somaPreco;
		
		public CarrinhoComprasDTO(CarrinhoCompras obj) {
			id = obj.getId();
			qntItens = obj.getQntItens();
			somaPreco = obj.getSomaPreco();
		}

	}


