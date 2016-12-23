package model;

/**
*
* @author  TSAMEZA ARMAND MARCEL GROUPE 14 2tl2
*/

import model.Bateau;

public class Zodiac extends Bateau {
	
	  /** Creates a new instance of Zodiac */
	
    public Zodiac(int x, int y, boolean horizontal) {
        super(x,y,horizontal,2);
    }
    public String toString(){
        return "Zodiac"+super.toString();
    }
    
    public static void main(String[] args) {
    	Zodiac d = new Zodiac(1, 0, true);
    	System.out.println(d);
    }
}
