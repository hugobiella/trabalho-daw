package com.academia.dtos;


	import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.academia.model.Plano;
import com.academia.model.Usuario;
import com.academia.model.Usuario.Categoria;

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
	public class UsuarioDTO extends RepresentationModel<UsuarioDTO> implements Serializable {

	    private static final long serialVersionUID = 1L;
	    
	    @EqualsAndHashCode.Include
		private Integer id;
		private String nome;
		private String email;
		private String senha;
		private Categoria categoria;
		private Plano plano;
		public UsuarioDTO(Usuario obj) {
			id = obj.getId();
			nome = obj.getNome();
			email = obj.getEmail();
			senha = obj.getSenha();
			categoria = obj.getCategoria();
			plano = null;
		}

	}


