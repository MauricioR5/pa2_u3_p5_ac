package com.uce.edu;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;
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
		
		System.out.println("UPDATE");
		int cantidad = this.iFacturaService.actualizarFecha(LocalDateTime.of(2024,02,23,20,50), LocalDateTime.of(2024,01,23,20,04));
		System.out.println("Cantidad de registros/filas actualizados: ");
		System.out.println(cantidad);
		
		
		System.out.println("DELETE");
		int cantidad2 = this.iFacturaService.eliminarPorNumero("0001-0270");
		System.out.println("Cantidad de registros/filas eliminados: ");
		System.out.println(cantidad2);
		
		//this.iFacturaService.eliminar(2);
		
		System.out.println("DTO");
			List<FacturaDTO> listaDTO =	this.iFacturaService.buscarFacturasDTO();
			for(FacturaDTO fDto:listaDTO) {
				System.out.println(fDto);
				
			}
	}

}
