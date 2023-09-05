package com.academia.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.academia.dtos.CompraDTO;
import com.academia.services.CompraService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping ("/v1/gym/Compras")
@Tag(name = "Endpoint de Compras")
public class CompraController {

    @Autowired
    private CompraService service;
    
	@GetMapping
	@Operation(summary = "Busca todas os Compras")
	@Tag(name = "Endpoint de Compras")
	public ResponseEntity<CollectionModel<CompraDTO>> buscarTodos(
				@RequestParam(value="page", defaultValue = "0") int page,
				@RequestParam(value="limit", defaultValue = "12") int limit,
				@RequestParam(value="1direction", defaultValue = "asc") String direction) {
			Direction sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
			Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "id"));
			Page<CompraDTO> pages = service.findAll(pageable);
			pages
				.stream()
				.forEach(p -> p.add(
						linkTo(methodOn(CompraController.class).findById(p.getId())).withSelfRel()
					)
				);
			return ResponseEntity.ok(CollectionModel.of(pages));
		}
	
	@GetMapping("/{id}")
	@Operation(summary = "Busca um proprietário por id")
	public ResponseEntity<CompraDTO> findById(@PathVariable Integer id) {
			CompraDTO objDTO = service.findById(id);
			objDTO.add(linkTo(methodOn(CompraController.class).findById(id)).withSelfRel());
			return ResponseEntity.ok(objDTO);
		}	


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Insere uma nova Compra")
	public ResponseEntity<CompraDTO> incluir(@RequestBody CompraDTO objBody) {
		CompraDTO objDTO = service.save(objBody);
		objDTO.add(linkTo(methodOn(CompraController.class).findById(objDTO.getId())).withSelfRel());
		return ResponseEntity.ok(objDTO);
	}

	@PutMapping
	@Operation(summary = "Atualiza uma Compra")
	public ResponseEntity<CompraDTO> atualizar(@RequestBody CompraDTO objBody) {
		CompraDTO objDTO = service.update(objBody);
		objDTO.add(linkTo(methodOn(CompraController.class).findById(objDTO.getId())).withSelfRel());
		return ResponseEntity.ok(objDTO);
	}	
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Exclui uma Compra por id")
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		if (!service.existById(id)) {
			return ResponseEntity.notFound().build();
		}
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
