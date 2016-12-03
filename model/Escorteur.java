package model;

/**
*
* @author  TSAMEZA ARMAND MARCEL GROUPE 14 2tl2
*/

import model.Bateau;

public class Escorteur extends Bateau {
	
	  /** Creates a new instance of Escorteur */
	
    public Escorteur(int x, int y, boolean horizontal) {
        super(x,y,horizontal,4);
    }
    public String toString(){
        return "Escorteur"+super.toString();
    }
    
    public static void main(String[] args) {
    	Escorteur d = new Escorteur(1, 0, true);
    	System.out.println(d);
    }
}
