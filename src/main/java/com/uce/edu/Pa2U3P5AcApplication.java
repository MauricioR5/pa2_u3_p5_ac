package com.uce.edu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ventas.repository.modelo.Habitacion;
import com.uce.edu.ventas.repository.modelo.Hotel;
import com.uce.edu.ventas.service.IFacturaService;
import com.uce.edu.ventas.service.IHotelService;

@SpringBootApplication
public class Pa2U3P5AcApplication implements CommandLineRunner{
	
	
	@Autowired
	private IHotelService iHotelService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5AcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("INNER JOIN");
		List<Hotel> lista = this.iHotelService.buscarHotelInnerJoin("A1");
		for(Hotel f: lista) {
			
		System.out.println(f);
		
		
		}
		System.out.println("RIGHT JOIN");
		List<Hotel> lista2 = this.iHotelService.buscarHotelRightJoin("A1");
		for(Hotel f: lista2) {
			
		System.out.println(f.getDireccion());
		
		
		}
		
		System.out.println("LEFT JOIN");
		List<Hotel> lista3 = this.iHotelService.buscarHotelLeftJoin("H2");
		for(Hotel f: lista3) {
			
		System.out.println(f);
		
		
		}
		
		System.out.println("FULL JOIN");
		List<Hotel> lista4 = this.iHotelService.buscarHotelFullJoin("H2");
		for(Hotel f: lista4) {
			
		System.out.println(f);
		for(Habitacion d : f.getHabitaciones()) {
			System.out.println(d);
		}
		
		
		}
		
		
	}

}
