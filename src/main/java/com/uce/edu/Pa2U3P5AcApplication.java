package com.uce.edu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ventas.repository.modelo.DetalleFactura;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5AcApplication implements CommandLineRunner{
	
	@Autowired
	private IFacturaService iFacturaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5AcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Factura fac = new Factura();
		fac.setCedula("123456789");
		fac.setFecha(LocalDateTime.now());
		fac.setNumero("0001-0255");
		
		DetalleFactura det1 = new DetalleFactura();
		det1.setCantidad(5);
		det1.setCodigoBarras("0000001");
		det1.setNombreProducto("Coca Cola");
		det1.setFactura(fac);
	
		DetalleFactura det2 = new DetalleFactura();
		det2.setCantidad(8);
		det2.setCodigoBarras("0000002");
		det2.setNombreProducto("Sprite");
		det2.setFactura(fac);
		
		List<DetalleFactura> detalle = new ArrayList<>();
		detalle.add(det1);
		detalle.add(det2);
	
		
		fac.setDetalleFactura(detalle);
		
		//this.iFacturaService.agregar(fac);
		Factura fac01 = this.iFacturaService.buscarPorNumero("0001-0255");
		for(DetalleFactura det: fac01.getDetalleFactura()) {
			System.out.println(det.getCodigoBarras());
		}
			
		System.out.println(fac01);
	}

}
