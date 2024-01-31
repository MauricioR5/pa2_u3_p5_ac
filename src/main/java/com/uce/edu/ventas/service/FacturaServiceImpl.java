package com.uce.edu.ventas.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.ventas.repository.IFacturaRepository;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository iFacturaRepository;

	@Override
	public Factura buscarPorNumero(String numero) {
		return this.iFacturaRepository.seleccionarPorNumero(numero);
	}

	@Override
	public void agregar(Factura factura) {
		this.iFacturaRepository.insertar(factura);
	}

	@Override
	public List<Factura> buscarFacturasInnerJoin() {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarFacturasInnerJoin();
	}

	@Override
	public List<Factura> buscarFacturasRightJoin() {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarFacturasRightJoin();
	}

	@Override
	public List<Factura> buscarFacturasLeftJoin() {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarFacturasLeftJoin();
	}

	@Override
	public List<Factura> buscarFacturasFullJoin() {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarFacturasFullJoin();
	}

	@Override
	public List<Factura> buscarFacturasWhereJoin() {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarFacturaWhereJoin();
	}

	@Override
	public List<Factura> buscarFacturasFetchJoin() {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarFacturaFetchJoin();
	}

	@Override
	public int eliminarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.eliminarPorNumero(numero);
	}

	@Override
	public int actualizarFecha(LocalDateTime fechaNueva, LocalDateTime fechaActual) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.actualizarFecha(fechaNueva, fechaActual);
	}

	@Override
	public void eliminar(Integer id) {
		this.iFacturaRepository.eliminar(id);
	}

	@Override
	public List<FacturaDTO> buscarFacturasDTO() {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarFacturasDTO();
	}

}
