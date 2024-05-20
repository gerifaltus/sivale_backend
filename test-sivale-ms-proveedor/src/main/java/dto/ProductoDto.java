package dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8779056246125075387L;
	
	private String nombre;
	private String codigo;
	private String detalle;
	private BigDecimal precio;
	private String nombreProveedor;
}
