package com.uce.edu.funcional;

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
		// 2. Predicate
		System.out.println("***********PREDICATE");
		// Lambdas
		System.out.println("Lambdas");
		IPersonaPredicate<Integer> predicateLambda = numero -> numero.compareTo(7)==0;
		System.out.println(predicateLambda.evaluar(Integer.valueOf(7)));
	}

}
