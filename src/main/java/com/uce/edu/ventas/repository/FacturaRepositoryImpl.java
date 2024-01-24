package com.uce.edu.ventas.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.ventas.repository.modelo.Factura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Factura seleccionarPorNumero(String numero) {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f WHERE f.numero =: numero",
				Factura.class);
		myQuery.setParameter("numero", numero);
		Factura factura = myQuery.getSingleResult();
		factura.getDetalleFactura().size();//le digo que cargue el detalle bajo demanda 
		return factura;
	}

	@Override
	public void insertar(Factura factura) {
		this.entityManager.persist(factura);
	}

}
