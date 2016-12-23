package model;

/**
*
* @author  TSAMEZA ARMAND MARCEL GROUPE 14 2tl2
*/

import model.Bateau;

public class Zodiac extends Bateau {
	
	/**
	 * Constructeur de Zodiac avec en parametre une position X, une position Y et un boolean pour verifier si le bateau est horizontal
	 * @param x
	 * @param y
	 * @param horizontal
	 */
    public Zodiac(int x, int y, boolean horizontal) {
        super(x,y,horizontal,2);
    }
    /**
     * Cette methode permet d'afficher le Bateau sous forme de texte
     */
    public String toString(){
        return "Zodiac"+super.toString();
    }
}
