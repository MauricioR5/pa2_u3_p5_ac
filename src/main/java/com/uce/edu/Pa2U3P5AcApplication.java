package com.uce.edu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ventas.repository.modelo.DetalleFactura;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.Habitacion;
import com.uce.edu.ventas.repository.modelo.Hotel;
import com.uce.edu.ventas.service.IFacturaService;
import com.uce.edu.ventas.service.IHotelService;

@SpringBootApplication
public class Pa2U3P5AcApplication implements CommandLineRunner{
	
	
	@Autowired
	private IFacturaService iFacturaService;

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
		
		List<Factura> listaf = this.iFacturaService.buscarFacturasInnerJoin();
		for(Factura f: listaf) {
			System.out.println(f);
		}
		
		System.out.println("RIGHT JOIN");
		
		List<Factura> lista2 = this.iFacturaService.buscarFacturasRightJoin();
		for(Factura f: lista2) {
			System.out.println(f.getNumero());
		}
		
		List<Hotel> listah = this.iHotelService.buscarHotelRightJoin("A1");
		for(Hotel f: listah) {
			System.out.println(f.getDireccion());
		}
		
		System.out.println("LEFT JOIN");
		
		List<Factura> lista3 = this.iFacturaService.buscarFacturasLeftJoin();
		for(Factura f: lista3) {
			System.out.println(f);
		}
		
		List<Hotel> listah2 = this.iHotelService.buscarHotelLeftJoin("H2");
		for(Hotel f: listah2) {

		System.out.println(f);

		}
		
		System.out.println("FULL JOIN");
		List<Factura> lista4 = this.iFacturaService.buscarFacturasFullJoin();
		for(Factura f: lista4) {
			for(DetalleFactura d : f.getDetalleFactura()) {
				System.out.println(d);
			}
		}
		
		List<Hotel> listah3 = this.iHotelService.buscarHotelFullJoin("H2");
		for(Hotel f: listah3) {
			for(Habitacion d : f.getHabitaciones()) {
				System.out.println(d);
			}
		}
		
		System.out.println("FETCH JOIN");
		List<Factura> lista5 = this.iFacturaService.buscarFacturasFetchJoin();
		for(Factura f: lista5) {
			System.out.println(f.getNumero());
			for(DetalleFactura d : f.getDetalleFactura()) {
				System.out.println(d.getNombreProducto());
			}
		}
		
		List<Hotel> listah4 = this.iHotelService.buscarHotelFetchJoin();
		for(Hotel f: listah4) {
			for(Habitacion d : f.getHabitaciones()) {
				System.out.println(d.getNumero());
			}
		}
		
	}

}
