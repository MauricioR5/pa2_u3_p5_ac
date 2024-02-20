package com.uce.edu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.service.IClienteService;

@SpringBootApplication
public class Pa2U3P5AcApplication implements CommandLineRunner {

	@Autowired
	private IClienteService iClienteService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5AcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	/*	// TODO Auto-generated method stub
		System.out.println("Nombre hilo: "+Thread.currentThread().getName());
		long tiempoInicial = System.currentTimeMillis();

		for (int i = 1; i <= 10; i++) {
			Cliente cliente = new Cliente();
			cliente.setNombre("CN" + i);
			cliente.setApellido("CA" + i);
			this.iClienteService.guardar(cliente);
		}

		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		System.out.println("Tiempo transcurrido en: " + tiempoTranscurrido + "segundos");
*/
		//Programación en paralelo
//		System.out.println("Nombre hilo: "+Thread.currentThread().getName());
//		long tiempoInicial = System.currentTimeMillis();
//		
//		List<Cliente> listaCliente = new ArrayList<>();
//		for(int i=1;i<=100;i++) {
//			Cliente cliente = new Cliente();
//			cliente.setNombre("CN" + i);
//			cliente.setApellido("CA" + i);
//			listaCliente.add(cliente);
//		}
//		
//		listaCliente.stream().forEach(cliente->this.iClienteService.guardar(cliente));
//		long tiempoFinal = System.currentTimeMillis();
//		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
//		System.out.println("Tiempo transcurrido en: " + tiempoTranscurrido + "segundos");
//		
		System.out.println("Nombre hilo: "+Thread.currentThread().getName());
		long tiempoInicial = System.currentTimeMillis();
		
		List<Cliente> listaCliente = new ArrayList<>();
		for(int i=1;i<=100;i++) {
			Cliente cliente = new Cliente();
			cliente.setNombre("CN" + i);
			cliente.setApellido("CA" + i);
			listaCliente.add(cliente);
		}
		
		listaCliente.parallelStream().forEach(cliente->this.iClienteService.guardar(cliente));
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		System.out.println("Tiempo transcurrido en: " + tiempoTranscurrido + "segundos");
		
		
		
	}

}
