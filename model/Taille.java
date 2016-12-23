package model;

import java.io.Serializable;

/**
*
* @author TSAMEZA Armand MARCEL 2tl2 groupe 14 
*/
public class Taille implements Serializable{
   private int x;             // Position sur l'axe X
   private int y;            //Position sur l'axe Y
   private int etat= 0;		
   /**
    * Constructeur de Taille prenant en parametre une position x et une positon y
    * @param x
    * @param y
    */
   public Taille(int x, int y) {
       this.x=x;
       this.y=y;
   }

    /**Cette methode renvoi la position X
     * @return x 
     */
    public int getX() {
        return x;
    }

    /**
     * Cette methode met à jour la variable d'instance X
     * @param x
     */
    public void setX(char x) {
        this.x = x;
    }

    /**
     * Cette methode renvoi la position Y
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * Cette methode met à jour la variable d'instance Y
     * @param y
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