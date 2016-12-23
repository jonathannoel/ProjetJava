package model;

import java.io.Serializable;

/**
*
* @author TSAMEZA Armand MARCEL 2tl2 groupe 14 
*/
public class Taille implements Serializable{
   private int x;             // sens orizontale du bateau
   private int y;            //sens verticale du bateau
   private int etat= 0;		
       /*          */
   public Taille(int x, int y) {
       this.x=x;
       this.y=y;
   }

   /*                           */
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(char x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @param py 
     * @param px 
     * @return the etat
     */
    public int getEtat(int px, int py) {
        return etat;
    }

    /**
     * @param etat the etat to set
     */
    public void setEtat(int etat) {
        this.etat = etat;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Position [x=" + x + ", y=" + y + ", etat=" + etat + "]";
    }
    
    

}