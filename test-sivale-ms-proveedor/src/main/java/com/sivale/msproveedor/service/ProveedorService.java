package com.sivale.msproveedor.service;

import java.util.List;

import dto.ProductoDto;

public interface ProveedorService {

    List<ProductoDto> getProductosByIdProveedor(Integer id);
    
    List<ProductoDto> getProductosByRfc(String rfc);
    
}
