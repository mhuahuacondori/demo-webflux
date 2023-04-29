package org.reactivo.demowebflux.entity;

import java.io.Serializable;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Proveedores implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private String nombreprov;
	private String contacto;
	private String celuprov;
	private String fijoprov;
	
}
