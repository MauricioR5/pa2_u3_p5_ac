package com.uce.edu.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		// 1. Supplier
		System.out.println("SUPPLIER");
		// Clases
		System.out.println("Clases");
		IPersonaSupplier<String> supplierClase = new PersonSupplierImpl();
		System.out.println(supplierClase.getId());
		// Lambdas
		System.out.println("Lambdas");
		IPersonaSupplier<String> supplierLambda = () -> {
			String cedula = "1723524664";
			cedula = cedula + "Canton";
			return cedula;

		};
		System.out.println(supplierLambda.getId());

		IPersonaSupplier<String> supplierLambda2 = () -> "1723524664" + "Pais";

		System.out.println(supplierLambda2.getId());

		IPersonaSupplier<Integer> supplierLambda3 = () -> {
			Integer valor1 = Integer.valueOf(100);
			valor1 = valor1 * Integer.valueOf(50) / Integer.valueOf(5);
			return valor1;
		};
		System.out.println(supplierLambda3.getId());

		// Metodos Referenciados

		System.out.println("Metodos referenciados");
		MetodosReferenciados met = new MetodosReferenciados();
		IPersonaSupplier<String> supplierLambda4 = met::obtenerId;
		System.out.println(supplierLambda4.getId());

		// 2. Consumer
		System.out.println("CONSUMER");
		// Clases
		System.out.println("Clases");
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Profesor");
		// Lambdas
		System.out.println("Lambdas");

		IPersonaConsumer<String> consumerLambda = (cadena) -> {
			System.out.println("Se inserta");
			System.out.println(cadena);
		};
		consumerLambda.accept("Professor");

		// Metodos referenciados
		System.out.println("Metodos referenciados");
		IPersonaConsumer<String> consumer2 = met::procesar;
		consumer2.accept("Edison Referenciado");
		// 3. Predicate
		System.out.println("***********PREDICATE");
		// Lambdas
		System.out.println("Lambdas");
		IPersonaPredicate<Integer> predicateLambda = numero -> numero.compareTo(7) == 0;
		System.out.println(predicateLambda.evaluar(Integer.valueOf(7)));

		// Metodos referenciados
		System.out.println("Metodos referenciados");
		IPersonaPredicate<String> predicate1 = met::evaluar;
		System.out.println(predicate1.evaluar("o"));
		IPersonaPredicate<Integer> predicate2 = met::evaluar;
		System.out.println(predicate2.evaluar(8));
		// 4. Function
		System.out.println("***********FUNCTION");
		// Lambdas
		IPersonaFunction<String, Integer> functionLambda = numero -> {
			numero = numero + Integer.valueOf(10);
			String numeroString = numero.toString().concat("-Valor");
			return numeroString;
		};
		System.out.println(functionLambda.aplicar(5));

		IPersonaFunction<Empleado, Ciudadano> functionlambda1 = ciudadano -> {
			Empleado emp = new Empleado();
			emp.setNombreCompleto(ciudadano.getNombre() + " " + ciudadano.getApellido());
			if (ciudadano.getProvincia().compareTo("pichincha") == 0) {
				emp.setPais("Ecuador");
			}
			;
			return emp;
		};
		Ciudadano ciu = new Ciudadano();
		ciu.setNombre("Mauricio");
		ciu.setApellido("Cacuango");
		ciu.setProvincia("pichincha");
		System.out.println(functionlambda1.aplicar(ciu));
		// Metodos referenciados
		System.out.println("Metodos referenciados");
		Empleado emp = new Empleado();
		emp.setNombreCompleto("Daniel Noboa");
		emp.setPais("Nueva York");
		IPersonaFunction<Ciudadano, Empleado> function = met::cambiar;
		System.out.println(function.aplicar(emp));

		// 5.-Unary Operator
		System.out.println("****************UNARY OPERATOR");
		// lambdas
		System.out.println("Lambdas");
		IPersonaUnaryOperator<Integer> unaryOperatorLambda = numero -> numero + (numero * 2);
		System.out.println(unaryOperatorLambda.aplicar(14));
		IPersonaUnaryOperatorFunction<Integer> unaryOperatorLambda1 = numero -> numero + (numero * 2);
		System.out.println(unaryOperatorLambda1.aplicar(10));

		// Metodos referenciados
		System.out.println("Metodos referenciados");
		IPersonaUnaryOperator<Empleado> unaryOperator1 = met::procesar;
		System.out.println(unaryOperator1.aplicar(emp));

		System.out.println("Implementación de interfaces funcionales mediante librerias JAVA");

		// 1. Supplier
		Stream<String> lista = Stream.generate(() -> "1723524664" + "Pais").limit(20);
		lista.forEach(cadena -> System.out.println(cadena));
		// 2.Consumer
		System.out.println("Consumer JAVA");
		List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5, 6, 5, 8, 8);
		listaNumeros.forEach((numero) -> {
			System.out.println("Se inserta");
			System.out.println(numero);
		});

		// 3. Predicate
		System.out.println("PREDICATE JAVA");
		Stream<Integer> listaFiltrada = listaNumeros.stream().filter(numero -> numero >= 5);
		listaFiltrada.forEach(numero -> System.out.println(numero));

		// 4. Function
		System.out.println("Function JAVA");
		Stream<String> listaCambiada = listaNumeros.stream().map(numero -> {
			numero = numero * 100 / 50;// Procesado
			return "Num" + numero.toString();
		});
		listaCambiada.forEach(cadena -> System.out.println(cadena));

		Ciudadano ciu1 = new Ciudadano();
		ciu1.setNombre("Mauricio");
		ciu1.setApellido("Cacuango");
		ciu1.setProvincia("pichincha");

		Ciudadano ciud2 = new Ciudadano();
		ciud2.setNombre("Daniel");
		ciud2.setApellido("Teran");
		ciud2.setProvincia("pichincha");

		Ciudadano ciud3 = new Ciudadano();
		ciud3.setNombre("Kareen");
		ciud3.setApellido("Jacome");
		ciud3.setProvincia("pichincha");

		List<Ciudadano> listaCiudadano = Arrays.asList(ciu1, ciud2, ciud3);
		Stream<Empleado> listaEmpleados = listaCiudadano.stream().map(ciudadano -> {
			Empleado empl = new Empleado();
			empl.setNombreCompleto(ciudadano.getNombre() + " " + ciudadano.getApellido());
			if (ciudadano.getProvincia().compareTo("pichincha") == 0) {
				empl.setPais("Ecuador");
			}
			;
			return empl;
		});
		listaEmpleados.forEach(empleado -> System.out.println(empleado));
		
		//5. Unary Operator
		System.out.println("Unary Operator JAVA");
		Stream<Integer> listaNumeros2 = listaNumeros.stream().map(numero -> {
			numero = numero * 100 / 50;// Procesado
			return numero;
		});
		listaNumeros2.forEach(numero -> System.out.println(numero));

	}

}
