package com.uce.edu.ventas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.ventas.repository.IHotelRepository;
import com.uce.edu.ventas.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	private IHotelRepository iHotelRepository;
	@Override
	
	public void guardar(Hotel hotel) {
		this.iHotelRepository.insertar(hotel);
	}
	@Override
	public List<Hotel> buscarHotelInnerJoin(String numero) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.seleccionarHotelInnerJoin(numero);
	}
	@Override
	public List<Hotel> buscarHotelRightJoin(String numero) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.seleccionarHotelRightJoin(numero);
	}
	@Override
	public List<Hotel> buscarHotelLeftJoin(String numero) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.seleccionarHotelLeftJoin(numero);
	}
	@Override
	public List<Hotel> buscarHotelFullJoin(String numero) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.seleccionarHotelFullJoin(numero);
	}
	@Override
	public List<Hotel> buscarHotelFetchJoin() {
		// TODO Auto-generated method stub
		return this.iHotelRepository.seleccionarHotelFetchJoin();
	}


}
