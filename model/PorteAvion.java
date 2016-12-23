package model;

/**
*
* @author  TSAMEZA ARMAND MARCEL GROUPE 14 2tl2
*/

import model.Bateau;

public class PorteAvion extends Bateau {
	
	/**
	 * Constructeur de PorteAvion avec en parametre une position X, une position Y et un boolean pour verifier si le bateau est horizontal
	 * @param x
	 * @param y
	 * @param horizontal
	 */
  public PorteAvion(int x, int y, boolean horizontal) {
      super(x,y,horizontal,5);
  }
  /**
   * Cette methode permet d'afficher le Bateau sous forme de texte
   */
  public String toString(){
      return "porteAvion"+super.toString();
  }
  
}
