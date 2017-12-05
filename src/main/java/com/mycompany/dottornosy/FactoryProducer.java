package com.mycompany.dottornosy;

public class FactoryProducer {

	private static final String MICRO = "MICRO";
//	private static final String NOMICRO = "NO_MICRO";

	public static InfoAbstractFactory getFactory(String select) {

		if (select.equalsIgnoreCase(MICRO)) {
			return new InfoMicroFactory();
		}
		return new InfoNoMicroFactory();

	}

}
