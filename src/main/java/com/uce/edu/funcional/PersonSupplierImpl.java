package com.uce.edu.funcional;

public class PersonSupplierImpl implements IPersonaSupplier<String> {

	@Override
	public String getId() {
		String cedula = "1723524664";
		cedula = cedula + "Provincia";
		return cedula;
	}

}
