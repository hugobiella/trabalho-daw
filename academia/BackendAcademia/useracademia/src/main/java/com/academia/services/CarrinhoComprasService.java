package com.academia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.academia.dtos.CarrinhoComprasDTO;
import com.academia.model.CarrinhoCompras;
import com.academia.repository.CarrinhoComprasDAO;
import com.academia.services.exceptions.BusinessExceptions;


@Service
public class CarrinhoComprasService {

	@Autowired
	private CarrinhoComprasDAO dao;
	
	@Transactional(readOnly = true)
	public Page<CarrinhoComprasDTO> findAll(Pageable pageable) {
		Page<CarrinhoCompras> result = dao.findAll(pageable);
		return result.map(obj -> new CarrinhoComprasDTO(obj));
				
		
	}


	@Transactional(readOnly = true)
	public CarrinhoComprasDTO findById(Integer id) {
		CarrinhoCompras result = dao.findById(id).
				orElseThrow(() -> new BusinessExceptions("Registros não encontrados!!!"));
		
		return new CarrinhoComprasDTO(result);
			
	}
    
	@Transactional
	public CarrinhoComprasDTO update(CarrinhoComprasDTO obj) {
		CarrinhoCompras entity = dao.findById(obj.getId())
				.orElseThrow(() -> new BusinessExceptions("Registros não encontrados!!!"));
		
		entity.setQntItens(obj.getQntItens());
		entity.setSomaPreco(obj.getSomaPreco());
		
		return new CarrinhoComprasDTO(dao.save(entity));
		
	}	
    
    @Transactional
    public CarrinhoComprasDTO save(@RequestBody CarrinhoComprasDTO obj) {
    	CarrinhoCompras modelObj = new CarrinhoCompras(obj.getId(), obj.getQntItens(), obj.getSomaPreco());
        return new CarrinhoComprasDTO(dao.save(modelObj));
    }
    
	@Transactional
	public void deleteById(Integer id) {
			dao.deleteById(id);
	}
	
	public boolean existById(Integer id) {
		return dao.existsById(id);
	}
}
