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
		IPersonaPredicate<Integer> predicateLambda = numero -> numero.compareTo(7)==0;
		System.out.println(predicateLambda.evaluar(Integer.valueOf(7)));
		
		// Metodos referenciados
				System.out.println("Metodos referenciados");
				IPersonaPredicate<String> predicate1 = met::evaluar;
				System.out.println(predicate1.evaluar("o"));
				IPersonaPredicate<Integer> predicate2 = met::evaluar;
				System.out.println(predicate2.evaluar(8));
		// 4. Function
				System.out.println("***********FUNCTION");
		//Lambdas
		IPersonaFunction<String, Integer> functionLambda = numero -> {
			numero = numero+Integer.valueOf(10);
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
	}

}
