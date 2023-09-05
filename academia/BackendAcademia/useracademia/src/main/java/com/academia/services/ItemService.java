package com.academia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.academia.dtos.ItemDTO;
import com.academia.model.Item;
import com.academia.repository.ItemDAO;
import com.academia.services.exceptions.BusinessExceptions;

@Service
public class ItemService {

	@Autowired
	private ItemDAO dao;
	
	@Transactional(readOnly = true)
	public Page<ItemDTO> findAll(Pageable pageable) {
		Page<Item> result = dao.findAll(pageable);
		return result.map(obj -> new ItemDTO(obj));
				
		
	}


	@Transactional(readOnly = true)
	public ItemDTO findById(Integer id) {
		Item result = dao.findById(id).
				orElseThrow(() -> new BusinessExceptions("Registros não encontrados!!!"));
		
		return new ItemDTO(result);
			
	}
    
	@Transactional
	public ItemDTO update(ItemDTO obj) {
		Item entity = dao.findById(obj.getId())
				.orElseThrow(() -> new BusinessExceptions("Registros não encontrados!!!"));
		
		entity.setNomeItem(obj.getNomeItem());
		entity.setDescItem(obj.getDescItem());
		entity.setEstoqueItem(obj.getEstoqueItem());
		entity.setPrecoItem(obj.getPrecoItem());

		return new ItemDTO(dao.save(entity));
		
	}	
    
    @Transactional
    public ItemDTO save(@RequestBody ItemDTO obj) {
    	Item modelObj = new Item(obj.getId(), obj.getNomeItem(), obj.getDescItem(),
    			obj.getEstoqueItem(), obj.getPrecoItem(), obj.getCompra());
        return new ItemDTO(dao.save(modelObj));
    }
    
	@Transactional
	public void deleteById(Integer id) {
			dao.deleteById(id);
	}
	
	public boolean existById(Integer id) {
		return dao.existsById(id);
	}
}
