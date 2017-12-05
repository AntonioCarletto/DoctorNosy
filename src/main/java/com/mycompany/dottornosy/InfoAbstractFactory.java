package com.mycompany.dottornosy;

/**
 * 
 * @author Antonio
 *
 */
public abstract class InfoAbstractFactory {

	public abstract InfoMicro getMicroInfo(String choise);

	public abstract InfoNoMicro getNoMicroInfo(String choise);
}
