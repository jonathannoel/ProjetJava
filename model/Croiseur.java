package model;

/**
*
* @author  TSAMEZA ARMAND MARCEL GROUPE 14 2tl2
*/

import model.Bateau;

public class Croiseur extends Bateau {
    
    /** Creates a new instance of Croiseur */
	
    public Croiseur(int x, int y, boolean horizontal) {
        super(x,y,horizontal,2);
    }
    public String toString(){
        return "croiseur"+super.toString();
    }
    
    public static void main(String[] args) {
    	Croiseur d = new Croiseur(1, 0, true);
    	System.out.println(d);
    }
}
