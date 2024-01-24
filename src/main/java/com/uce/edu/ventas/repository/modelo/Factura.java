package com.uce.edu.ventas.repository.modelo;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura {
	
	@SequenceGenerator(name = "seq_factura", sequenceName = "seq_factura", allocationSize = 1)
	@GeneratedValue(generator = "seq_factura", strategy = GenerationType.SEQUENCE)
	
	@Id
	@Column(name = "fact_id")
	private Integer id;
	
	@Column(name = "fact_numero")
	private String numero;
	
	@Column(name = "fact_fecha")
	private LocalDateTime fecha;
	
	@Column(name = "fact_cedula")
	private String cedula;
	
	@OneToMany(mappedBy = "factura",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<DetalleFactura> detalleFactura;

	//set and get
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public List<DetalleFactura> getDetalleFactura() {
		return detalleFactura;
	}

	public void setDetalleFactura(List<DetalleFactura> detalleFactura) {
		this.detalleFactura = detalleFactura;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", numero=" + numero + ", fecha=" + fecha + ", cedula=" + cedula
			+ ", getId()=" + getId() + ", getNumero()=" + getNumero()
				+ ", getFecha()=" + getFecha() + ", getCedula()=" + getCedula() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
}
