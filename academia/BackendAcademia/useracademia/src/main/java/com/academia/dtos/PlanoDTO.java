package com.academia.dtos;


	import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.hateoas.RepresentationModel;

import com.academia.model.Plano;
import com.academia.model.Usuario;

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
	public class PlanoDTO extends RepresentationModel<PlanoDTO> implements Serializable {

		    private static final long serialVersionUID = 1L;

			@EqualsAndHashCode.Include
			private Integer id;
			private String nomePlano;
			private String valorPlano;
			private String descPlano;
		    private Set<UsuarioDTO> usuarios = new HashSet<>();
		    
		    public void addUsuarios(UsuarioDTO usuario) {
		        this.usuarios.add(usuario);
		    }
		  
		public PlanoDTO(Plano obj) {
			id = obj.getId();
			nomePlano = obj.getNomePlano();
			valorPlano = obj.getValorPlano();
			descPlano = obj.getDescPlano();

			if (obj.getUsuarios() != null) {
			    for (Usuario usuarios : obj.getUsuarios()) {
			       UsuarioDTO novoUsuario = new UsuarioDTO(usuarios);
			       this.usuarios.add(novoUsuario);
			    }
			}
	}
		
		
	}


