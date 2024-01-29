package com.uce.edu.ventas.repository;

import java.util.List;

import com.uce.edu.ventas.repository.modelo.Hotel;

public interface IHotelRepository {
	
	public void insertar(Hotel hotel); 

public List<Hotel> seleccionarHotelInnerJoin(String numero);
	
	public List<Hotel> seleccionarHotelRightJoin(String numero);
	
	public List<Hotel> seleccionarHotelLeftJoin(String numero);
	
	public List<Hotel> seleccionarHotelFullJoin(String numero);
}
