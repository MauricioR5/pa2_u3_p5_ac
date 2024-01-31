package com.uce.edu.ventas.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
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
		factura.getDetalleFactura().size();// le digo que cargue el detalle bajo demanda
		return factura;
	}

	@Override
	public void insertar(Factura factura) {
		this.entityManager.persist(factura);
	}

	@Override
	public List<Factura> seleccionarFacturasInnerJoin() {
		// TODO Auto-generated method stub
		// SQL: SELECT * FROM factura f inner join detalle_factura d
		// on f.fact_id = d.defa_id_factura
		// JPQL: SELECT f FROM Factura f INNER JOIN f.detalleFactura d
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f INNER JOIN f.detalleFactura d", Factura.class);

		List<Factura> lista = myQuery.getResultList();
//		for (Factura f : lista) {
//			f.getDetalleFactura().size();
//		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasRightJoin() {
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f RIGHT JOIN f.detalleFactura d", Factura.class);

		List<Factura> lista = myQuery.getResultList();
		for (Factura f : lista) {
			f.getDetalleFactura().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasLeftJoin() {
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalleFactura d", Factura.class);

		List<Factura> lista = myQuery.getResultList();
		for (Factura f : lista) {
			f.getDetalleFactura().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturasFullJoin() {

		/*
		 * CriteriaBuilder cb = this.entityManager.getCriteriaBuilder(); CriteriaQuery<
		 * Factura> cq = cb.createQuery(Factura.class); Root<Factura> root=
		 * cq.from(Factura.class); root.join(DetalleFactura.class);
		 */

		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f FULL JOIN f.detalleFactura d", Factura.class);

		List<Factura> lista = myQuery.getResultList();
		for (Factura f : lista) {
			f.getDetalleFactura().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturaWhereJoin() {
		// SQL: SELECT f.* FROM factura f, detalle_factura d WHERE
		// f.fact_id = d.defa_id_factura

		// JPQL: SELECT f FROM Factura f, DetalleFactura d,
		// WHERE f = d.factura

		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f, DetalleFactura d WHERE f = d.factura", Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for (Factura f : lista) {
			f.getDetalleFactura().size();
		}
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturaFetchJoin() {

		// SELECT f FROM Factura f JOIN FETCH f.detalleFactura d
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f JOIN FETCH f.detalleFactura d", Factura.class);
		List<Factura> lista = myQuery.getResultList();
		return lista;
	}

	@Override
	public int eliminarPorNumero(String numero) {
		Query myQuery = 
				this.entityManager.createQuery("DELETE FROM Factura f WHERE f.numero=:numero");
		myQuery.setParameter("numero", numero);
		return myQuery.executeUpdate();
	}

	@Override
	public int actualizarFecha(LocalDateTime fechaNueva, LocalDateTime fechaActual) {
		Query myQuery = this.entityManager
				 .createQuery("UPDATE Factura f SET f.fecha = :fechaNueva WHERE f.fecha >= :fechaActual");
	    myQuery.setParameter("fechaNueva", fechaNueva);
	    myQuery.setParameter("fechaActual", fechaActual);
		return myQuery.executeUpdate();
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(id);
	}

	@Override
	public List<FacturaDTO> seleccionarFacturasDTO() {//hay que incluir el nombre desde el paquete
		TypedQuery<FacturaDTO> myQuery = this.entityManager.createQuery("SELECT NEW com.uce.edu.ventas.repository.modelo.dto.FacturaDTO(f.numero,f.fecha) FROM Factura f", FacturaDTO.class);
		return myQuery.getResultList();
	}

}
