package fr.formation.ejb;

import javax.ejb.Stateless;

@Stateless
public class CapsConvertisseur {
	
	public ConvertEnMinuscule getLowerCase() {
		return new ConvertEnMinuscule();
	}
}