package com.mycompany.dottornosy;

/**
 *
 * @author Antonio
 */
/**
 * La classe JobAdNoMicroFactory estende la classe astratta
 * JobAdAbstractFactory. Estende in oltre il metodo getJobAdNM() di tipo
 * JobAdNoMicro.
 */
public class InfoNoMicroFactory extends InfoAbstractFactory {

	@Override
	public InfoMicro getMicroInfo(String choise) {
		throw new UnsupportedOperationException("Errore nel metodo getMicroInfo() della classe InfoNoMicroFactory.");
	}

	@Override
	public InfoNoMicro getNoMicroInfo(String choise) {
		
		if (choise.equalsIgnoreCase("")) {
			return null;
		} else if (choise.equalsIgnoreCase("")) {
			return null;

		} else if (choise.equalsIgnoreCase("")) {
			return null;
		}
		throw new UnsupportedOperationException("Errore nel metodo getNoMicroInfo() della classe InfoNoMicroFactory.");

	}
}
