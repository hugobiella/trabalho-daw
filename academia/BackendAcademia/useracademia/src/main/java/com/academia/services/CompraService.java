package com.academia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.academia.dtos.CompraDTO;
import com.academia.model.Compra;
import com.academia.repository.CompraDAO;
import com.academia.services.exceptions.BusinessExceptions;

@Service
public class CompraService {

	@Autowired
	private CompraDAO dao;
	
	@Transactional(readOnly = true)
	public Page<CompraDTO> findAll(Pageable pageable) {
		Page<Compra> result = dao.findAll(pageable);
		return result.map(obj -> new CompraDTO(obj));
				
		
	}


	@Transactional(readOnly = true)
	public CompraDTO findById(Integer id) {
		Compra result = dao.findById(id).
				orElseThrow(() -> new BusinessExceptions("Registros não encontrados!!!"));
		
		return new CompraDTO(result);
			
	}
    
	@Transactional
	public CompraDTO update(CompraDTO obj) {
		Compra entity = dao.findById(obj.getId())
				.orElseThrow(() -> new BusinessExceptions("Registros não encontrados!!!"));
		
		entity.setDataCompra(obj.getDataCompra());
		entity.setQntItens(obj.getQntItens());
		entity.setValorTotal(obj.getValorTotal());
		entity.setStatus(obj.getStatus());

		return new CompraDTO(dao.save(entity));
		
	}	
    
    @Transactional
    public CompraDTO save(@RequestBody CompraDTO obj) {
    	Compra modelObj = new Compra(obj.getId(), obj.getQntItens(), obj.getDataCompra(),
    			obj.getValorTotal(), obj.getStatus());
        return new CompraDTO(dao.save(modelObj));
    }
    
	@Transactional
	public void deleteById(Integer id) {
			dao.deleteById(id);
	}
	
	public boolean existById(Integer id) {
		return dao.existsById(id);
	}
}
