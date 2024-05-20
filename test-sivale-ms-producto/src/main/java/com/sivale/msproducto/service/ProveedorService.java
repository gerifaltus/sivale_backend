package com.sivale.msproducto.service;

import java.util.List;

import com.sivale.msproducto.dto.ProductoDto;

public interface ProveedorService {

	List<ProductoDto> getById(Long id);
	
	List<ProductoDto> getByRfc(String rfc);
	
}
