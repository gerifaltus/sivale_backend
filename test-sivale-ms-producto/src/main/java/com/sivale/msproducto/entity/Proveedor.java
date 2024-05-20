package com.sivale.msproducto.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="proveedor", schema = "comercio")
public class Proveedor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5268126922027106711L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	@Column(name="nombre", length = 50)
	private String nombre;
	
	@Column(name="detalle", length = 200)
	private String detalle;
	
	@Column(name="rfc", length = 13)
	private String rfc;
	
	@Column(name="telefono", length = 10)
	private String telefono;
	
	@OneToMany(mappedBy = "proveedor", fetch = FetchType.LAZY, 
			targetEntity = Producto.class)
	private List<Producto> listProducto;
}
