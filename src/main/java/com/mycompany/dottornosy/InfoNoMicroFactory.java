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

		if (choise.equalsIgnoreCase("")) {
			return null;
		} else if (choise.equalsIgnoreCase("")) {
			return null;

		} else if (choise.equalsIgnoreCase("")) {
			return null;
		}

		throw new UnsupportedOperationException("Errore nel metodo getJobAdNM() della classe JobAdNoMicroFactory.");

	}

	@Override
	public InfoNoMicro getNoMicroInfo(String choise) {
		throw new UnsupportedOperationException("Errore nel metodo getJobAd() della classe JobAdNoMicroFactory.");

	}
}
