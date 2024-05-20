package com.sivale.msproducto.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="producto", schema = "comercio")
public class Producto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2622366283376318757L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="detalle")
	private String detalle;
	
	@Column(name="codigo")
	private String codigo;
	
	@Column(name="precio")
	private BigDecimal precio;
	
	@ManyToOne(targetEntity = Proveedor.class, fetch = FetchType.LAZY)
	@JoinColumn(name="id_proveedor")
	private Proveedor proveedor;
	
}
