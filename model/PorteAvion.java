package model;

/**
*
* @author  TSAMEZA ARMAND MARCEL GROUPE 14 2tl2
*/

import model.Bateau;

public class PorteAvion extends Bateau {
	
	  /** Creates a new instance of PorteAvion */
	
  public PorteAvion(int x, int y, boolean horizontal) {
      super(x,y,horizontal,5);
  }
  public String toString(){
      return "porteAvion"+super.toString();
  }
  
  public static void main(String[] args) {
  	PorteAvion d = new PorteAvion(1, 0, true);
  	System.out.println(d);
  }
}
