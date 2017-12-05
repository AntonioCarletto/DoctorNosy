package com.mycompany.dottornosy;

/**
 *
 * @author Antonio
 */

public class InfoMicroFactory extends InfoAbstractFactory {

	@Override
	public InfoMicro getMicroInfo(String choise) {

		if (choise.equalsIgnoreCase("MICROHTTP")) {
			return new ParserMicroHttp();
		} else if (choise.equalsIgnoreCase("MICROHTTPS")) {
			return new ParserMicroHttps();
		}

		throw new UnsupportedOperationException("");

	}

	public InfoNoMicro getNoMicroInfo(String choise) {
		throw new UnsupportedOperationException("");
	}
}
