package com.uce.edu.ventas.service;

import java.util.List;

import com.uce.edu.ventas.repository.modelo.Hotel;

public interface IHotelService {

	public void guardar(Hotel hotel);
	
public List<Hotel> buscarHotelInnerJoin(String numero);
	
	public List<Hotel> buscarHotelRightJoin(String numero);
	
	public List<Hotel> buscarHotelLeftJoin(String numero);
	
	public List<Hotel> buscarHotelFullJoin(String numero);
}
