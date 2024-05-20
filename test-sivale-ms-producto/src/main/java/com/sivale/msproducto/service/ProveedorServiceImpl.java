package com.sivale.msproducto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sivale.msproducto.dto.ProductoDto;
import com.sivale.msproducto.repository.ProveedorRepository;

@Service
public class ProveedorServiceImpl implements ProveedorService {

	ProveedorRepository proveedorRepository;

	public ProveedorServiceImpl(ProveedorRepository proveedorRepository) {
		super();
		this.proveedorRepository = proveedorRepository;
	}

	@Override
	public List<ProductoDto> getById(Long id) {
		return this.proveedorRepository.getProductosByProveedorId(id);
	}

	@Override
	public List<ProductoDto> getByRfc(String rfc) {
	    return this.proveedorRepository.getByRfc(rfc);
	}
	
	

	
}
