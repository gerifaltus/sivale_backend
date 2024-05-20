package com.sivale.msproveedor.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sivale.msproveedor.service.ProveedorService;

import dto.ProductoDto;
import dto.ResponseCustom;

@RestController
@RequestMapping("/api/v1")
public class ProveedorController {

    private ProveedorService proveedorService;
    
    public ProveedorController(ProveedorService proveedorService) {
        super();
        this.proveedorService = proveedorService;
    }

    @GetMapping("/proveedores/{id}")
    public ResponseEntity<ResponseCustom<ProductoDto>> getProductIdProveedor(
            @PathVariable Integer id) {
        List<ProductoDto> listProducto = this.proveedorService.getProductosByIdProveedor(id);
        return getResponse(listProducto);
    }
    
    @GetMapping("/proveedores/rfc/{rfc}")
    public ResponseEntity<ResponseCustom<ProductoDto>> getProductRfcProveedor(
            @PathVariable String rfc) {
        List<ProductoDto> listProducto = this.proveedorService.getProductosByRfc(rfc);
        return getResponse(listProducto);
    }
    
    
    private ResponseEntity<ResponseCustom<ProductoDto>> getResponse(
            List<ProductoDto> listProducto) {
        ResponseCustom<ProductoDto> rc = new ResponseCustom<>();
       if(listProducto.isEmpty()) {
            rc.setStatusCode(HttpStatus.NOT_FOUND.value());
            rc.setData(listProducto);
            return new ResponseEntity<>(rc, HttpStatus.NOT_FOUND);
        }
        
        rc.setStatusCode(HttpStatus.OK.value());
        rc.setData(listProducto);
        return new ResponseEntity<>(rc, HttpStatus.OK);
    }
}
