package com.sivale.msproveedor.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sivale.msproveedor.service.ProveedorService;

import dto.ProductoDto;

@Service
public class ProveedorServiceImpl implements ProveedorService{

    private String url = "http://localhost:8080/api/v1";

    private RestTemplate restTemplate = new RestTemplate();
    
    @Override
    public List<ProductoDto> getProductosByIdProveedor(Integer id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add( "Content-Type", "application/json");
        List<ProductoDto> listProductoDto = new ArrayList<>();
        HttpEntity<List<ProductoDto>> entity = new HttpEntity<>(headers);

        ResponseEntity<List<ProductoDto>> responseEntity 
            = restTemplate.exchange(
                    this.url+"/proveedores/"+id, 
                    HttpMethod.GET, 
                    entity, 
                    new ParameterizedTypeReference<List<ProductoDto>>(){});
        
        listProductoDto = responseEntity.getBody();
        
        return listProductoDto;
        
    }

    @Override
    public List<ProductoDto> getProductosByRfc(String rfc) {
        HttpHeaders headers = new HttpHeaders();
        headers.add( "Content-Type", "application/json");
        List<ProductoDto> listProductoDto = new ArrayList<>();
        HttpEntity<List<ProductoDto>> entity = new HttpEntity<>(headers);

        ResponseEntity<List<ProductoDto>> responseEntity 
            = restTemplate.exchange(
                    this.url+"/proveedores/rfc/"+rfc, 
                    HttpMethod.GET, 
                    entity, 
                    new ParameterizedTypeReference<List<ProductoDto>>(){});
        
        listProductoDto = responseEntity.getBody();
        
        return listProductoDto;
    }
    
    
    
}
