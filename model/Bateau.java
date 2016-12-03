package model;

import java.util.Arrays;

/**
*
* @author  Armand
*/
public class Bateau {
   private boolean horizontal = true;
   private Taille[] taille;   // appel de la classe position pour former un tableau de position
   private int t;
   //Creates a new instance of Bateau 
   public  Bateau(int x, int y, boolean horizontal, int taille ){
       this.horizontal = horizontal;
       this.taille = new Taille [taille];
       this.t = taille;
	   if (horizontal){ 
		   for (int i=0; i<taille; i++){
			   this.taille[i]=new Taille(x,y); 
			   x++;
		   }
	   }
	   else{
        for(int j=0;j<taille;j++){
        	this.taille[j]=new Taille(x,y);
        	y++;
	    }
    
   }
 }
   /**
    * 
    * @param px
    * @param py
    * @return
    */
   public  int estTouche(int px, int py){
       int caseTouche = 0; int nbreCout = 0;
       for (int i=0;i<this.taille.length;i++){
           int etat = this.taille[i].getEtat(px, py);
           if (etat == 1) {
               nbreCout = 1; caseTouche++;
           }
           else if (etat == 2) {
               nbreCout = 2; caseTouche++;
           }
       }
       if (caseTouche == taille.length){
           return 3;
       }
       else{
           return nbreCout;
       }
   }
 
    /**
     * @return the horizontal
     */
    public boolean isHorizontal() {
        return horizontal;
    }
    /**
     * @param horizontal the horizontal to set
     */
    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }
    /**
     * @return the position
     */
    public Taille[] getPosition() {
        return this.taille;
    }
    /**
     * @param position the position to set
     */
    public void setPosition(Taille[] taille) {
        this.taille = taille;
    }
    
    public Taille[] getTaille() {
		return taille;
	}
	public void setTaille(Taille[] taille) {
		this.taille = taille;
	}
	public int getT() {
		return t;
	}
	public void setT(int t) {
		this.t = t;
	}
	/* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Bateau [horizontal=" + horizontal + ", Taille=" + Arrays.toString(taille) + "]";
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Bateau b = new Bateau(1, 0, false, 5);
        System.out.println(b);
    }
    
 }