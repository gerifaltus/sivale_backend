package com.sivale.msproducto.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sivale.msproducto.dto.ProductoDto;
import com.sivale.msproducto.service.ProveedorService;

@RestController
@RequestMapping("/api/v1")
public class ProveedorController {

	ProveedorService proveedorService;

	public ProveedorController(ProveedorService proveedorService) {
		super();
		this.proveedorService = proveedorService;
	} 
	
	@GetMapping("/proveedores/{id}")
	public List<ProductoDto> getById(@PathVariable Long id) {
		return this.proveedorService.getById(id);
		
	}
	
	@GetMapping("/proveedores/rfc/{rfc}")
	public List<ProductoDto> getById(@PathVariable String rfc) {
	      return this.proveedorService.getByRfc(rfc);
	}
	

}
