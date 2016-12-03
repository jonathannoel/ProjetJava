package model;

/**
*
* @author  TSAMEZA ARMAND MARCEL GROUPE 14 2tl2
*/

import model.Bateau;

public class Torpilleur extends Bateau {
	
	  /** Creates a new instance of Torpilleur */
	
  public Torpilleur(int x, int y, boolean horizontal) {
      super(x,y,horizontal,3);
  }
  public String toString(){
      return "Torpilleur"+super.toString();
  }
  
  public static void main(String[] args) {
  	Torpilleur d = new Torpilleur(1, 0, true);
  	System.out.println(d);
  }
}
