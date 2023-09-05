package com.academia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.academia.dtos.PlanoDTO;
import com.academia.model.Plano;
import com.academia.repository.PlanoDAO;
import com.academia.services.exceptions.BusinessExceptions;

@Service
public class PlanoService {

	@Autowired
	private PlanoDAO dao;
	
	@Transactional(readOnly = true)
	public Page<PlanoDTO> findAll(Pageable pageable) {
		Page<Plano> result = dao.findAll(pageable);
		return result.map(obj -> new PlanoDTO(obj));
				
		
	}


	@Transactional(readOnly = true)
	public PlanoDTO findById(Integer id) {
		Plano result = dao.findById(id).
				orElseThrow(() -> new BusinessExceptions("Registros não encontrados!!!"));
		
		return new PlanoDTO(result);
			
	}
    
	@Transactional
	public PlanoDTO update(PlanoDTO obj) {
		Plano entity = dao.findById(obj.getId())
				.orElseThrow(() -> new BusinessExceptions("Registros não encontrados!!!"));
		
		entity.setNomePlano(obj.getNomePlano());
		entity.setValorPlano(obj.getValorPlano());
		entity.setDescPlano(obj.getDescPlano());

		return new PlanoDTO(dao.save(entity));
		
	}	
    
    @Transactional
    public PlanoDTO save(@RequestBody PlanoDTO obj) {
    	Plano modelObj = new Plano(obj.getId(), obj.getNomePlano(), obj.getValorPlano(),
    			obj.getDescPlano());
        return new PlanoDTO(dao.save(modelObj));
    }
    
	@Transactional
	public void deleteById(Integer id) {
			dao.deleteById(id);
	}
	
	public boolean existById(Integer id) {
		return dao.existsById(id);
	}
}
