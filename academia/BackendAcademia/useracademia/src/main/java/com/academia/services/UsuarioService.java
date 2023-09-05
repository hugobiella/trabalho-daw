package com.academia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.academia.dtos.UsuarioDTO;
import com.academia.model.Usuario;
import com.academia.repository.UsuarioDAO;
import com.academia.services.exceptions.BusinessExceptions;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioDAO dao;
	
	@Transactional(readOnly = true)
	public Page<UsuarioDTO> findAll(Pageable pageable) {
		Page<Usuario> result = dao.findAll(pageable);
		return result.map(obj -> new UsuarioDTO(obj));
				
		
	}


	@Transactional(readOnly = true)
	public UsuarioDTO findById(Integer id) {
		Usuario result = dao.findById(id).
				orElseThrow(() -> new BusinessExceptions("Registros não encontrados!!!"));
		
		return new UsuarioDTO(result);
			
	}
    
	@Transactional
	public UsuarioDTO update(UsuarioDTO obj) {
		Usuario entity = dao.findById(obj.getId())
				.orElseThrow(() -> new BusinessExceptions("Registros não encontrados!!!"));
		
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setSenha(obj.getSenha());
		entity.setCategoria(obj.getCategoria());
		entity.setPlano(obj.getPlano());
		return new UsuarioDTO(dao.save(entity));
		
	}	
    
    @Transactional
    public UsuarioDTO save(@RequestBody UsuarioDTO obj) {
    	Usuario modelObj = new Usuario(obj.getId(), obj.getNome(), obj.getEmail(), obj.getSenha(), obj.getCategoria(),  obj.getPlano());
        return new UsuarioDTO(dao.save(modelObj));
    }
    
	@Transactional
	public void deleteById(Integer id) {
			dao.deleteById(id);
	}
	
	public boolean existById(Integer id) {
		return dao.existsById(id);
	}
}
