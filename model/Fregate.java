package model;

/**
*
* @author  TSAMEZA ARMAND MARCEL GROUPE 14 2tl2
*/

import model.Bateau;

public class Fregate extends Bateau {
	
	/**
	 * Constructeur de Fragate avec en parametre une position X, une position Y et un boolean pour verifier si le bateau est horizontal
	 * @param x
	 * @param y
	 * @param horizontal
	 */
  public Fregate(int x, int y, boolean horizontal) {
      super(x,y,horizontal,3);
  }
  public String toString(){
      return "Fregates"+super.toString();
  }
  
}
