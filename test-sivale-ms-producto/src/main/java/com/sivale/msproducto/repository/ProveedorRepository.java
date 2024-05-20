package com.sivale.msproducto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sivale.msproducto.dto.ProductoDto;
import com.sivale.msproducto.entity.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer>{

	@Query("""
            SELECT new com.sivale.msproducto.dto.ProductoDto(
                  producto.nombre AS nombre, producto.codigo AS codigo, 
                  producto.detalle AS detalle, producto.precio AS precio,
                  proveedor.nombre AS nombreProveedor) 
            FROM Proveedor proveedor 
                  INNER JOIN Producto producto
                        ON producto.proveedor.id = proveedor.id
            WHERE proveedor.id = :id
            """)
	List<ProductoDto> getProductosByProveedorId(@Param("id") Long id);
	
	
    @Query("""
            SELECT new com.sivale.msproducto.dto.ProductoDto(
                  producto.nombre AS nombre, producto.codigo AS codigo, 
                  producto.detalle AS detalle, producto.precio AS precio,
                  proveedor.nombre AS nombreProveedor) 
            FROM Proveedor proveedor 
                  INNER JOIN Producto producto
                        ON producto.proveedor.id = proveedor.id
            WHERE proveedor.rfc = :rfc
            """)
    List<ProductoDto> getByRfc(@Param("rfc") String rfc);
}
