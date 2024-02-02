package com.uce.edu.ventas.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.ventas.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Hotel hotel) {
		this.entityManager.persist(hotel);
	}

	@Override
	public List<Hotel> seleccionarHotelInnerJoin(String numero) {
		TypedQuery<Hotel> myQuery = this.entityManager
				.createQuery("SELECT h FROM Hotel h INNER JOIN h.habitaciones hab WHERE hab.numero = :numero", Hotel.class);
		myQuery.setParameter("numero", numero);
		List<Hotel> lista = myQuery.getResultList();
		for (Hotel h : lista) {
			h.getHabitaciones().size();
		}
		return lista;
	}

	@Override
	public List<Hotel> seleccionarHotelRightJoin(String numero) {
		TypedQuery<Hotel> myQuery = this.entityManager
				.createQuery("SELECT h FROM Hotel h RIGHT JOIN h.habitaciones hab WHERE hab.numero = :numero", Hotel.class);
		myQuery.setParameter("numero", numero);
		List<Hotel> lista = myQuery.getResultList();
		for (Hotel h : lista) {
			h.getHabitaciones().size();
		}
		return lista;
	}

	@Override
	public List<Hotel> seleccionarHotelLeftJoin(String numero) {
		TypedQuery<Hotel> myQuery = this.entityManager
				.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones hab WHERE hab.numero = :numero", Hotel.class);
		myQuery.setParameter("numero", numero);
		List<Hotel> lista = myQuery.getResultList();
		for (Hotel h : lista) {
			h.getHabitaciones().size();
		}
		return lista;
	}

	@Override
	public List<Hotel> seleccionarHotelFullJoin(String numero) {
		TypedQuery<Hotel> myQuery = this.entityManager
				.createQuery("SELECT h FROM Hotel h FULL JOIN h.habitaciones hab WHERE hab.numero = :numero", Hotel.class);
		myQuery.setParameter("numero", numero);
		List<Hotel> lista = myQuery.getResultList();
		for (Hotel h : lista) {
			h.getHabitaciones().size();
		}
		return lista;
	}

	@Override
	public List<Hotel> seleccionarHotelFetchJoin() {
		TypedQuery<Hotel> myQuery = this.entityManager
				.createQuery("SELECT h FROM Hotel h JOIN FETCH h.habitaciones hab", Hotel.class);
		List<Hotel> lista = myQuery.getResultList();
		return lista;
	}

	

	



	

	

}
