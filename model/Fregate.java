package model;

/**
*
* @author  TSAMEZA ARMAND MARCEL GROUPE 14 2tl2
*/

import model.Bateau;

public class Fregate extends Bateau {
	
	  /** Creates a new instance of Frigate */
	
  public Fregate(int x, int y, boolean horizontal) {
      super(x,y,horizontal,3);
  }
  public String toString(){
      return "Fregates"+super.toString();
  }
  
  public static void main(String[] args) {
  	Fregate d = new Fregate(1, 0, true);
  	System.out.println(d);
  }
}
