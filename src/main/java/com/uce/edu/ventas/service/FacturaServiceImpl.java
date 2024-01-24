package com.uce.edu.ventas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.ventas.repository.IFacturaRepository;
import com.uce.edu.ventas.repository.modelo.Factura;

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

}
