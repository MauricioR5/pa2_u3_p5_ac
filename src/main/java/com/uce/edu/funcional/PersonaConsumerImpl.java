package com.uce.edu.funcional;

public class PersonaConsumerImpl implements IPersonaConsumer<String> {

	@Override
	public void accept(String arg) {
		
		System.out.println("Se inserta en la base");
		System.out.println(arg);
	}

}
