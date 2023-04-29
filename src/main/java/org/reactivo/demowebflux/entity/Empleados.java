package org.reactivo.demowebflux.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Empleados implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private String nombre;
	private String apellido;
	private Date fecha_nac;
	private Integer reporta_a;
	private Integer extension;


}
