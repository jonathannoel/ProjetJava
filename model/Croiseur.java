package model;

import model.Bateau;

/**
 * Cette classe permet de définir un Croiseur.
 * 
 * @author Jonathan Noel, Armand Tsameza, Pierre Tshiama.
 * @version 2016
 * 
 */

public class Croiseur extends Bateau {
    
	/**
	 * Constructeur de la classe.
	 * @param x
	 * @param y
	 * @param horizontal
	 */
	
    public Croiseur(int x, int y, boolean horizontal) {
        super(x,y,horizontal,4);
    }
}
