package model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Observable;

/**
*
* @author  TSAMEZA ARMAND MARCEL GROUPE 14 2tl2
*/
public class Bateau extends Observable implements Serializable {
   private boolean horizontal = true;
   private Taille[] taille;   // appel de la classe Taille pour former un tableau de position
   private int t;
   //Creates a new instance of Bateau 
   public  Bateau(int x, int y, boolean horizontal, int taille ){
       this.horizontal = horizontal;
       longueur(x, y, taille);
   }
   
   /**
    * cette methode permet de savoir si un bateau a 
    * une longueur verticale ou une longueur orizontale
    * @param x	constitue le parametre horizontale du bateau
    * @param y	constitue le parametre verticale du bateau du bateau
    * @param taille constitue la taille du bateau
    */
   public void longueur(int x, int y, int taille){
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
	   setChanged();
       notifyObservers();
	   }
   
   /**
    * cette methode permet de tester si un bateau est 
    * ataqué ou pas  
    * @param px	constitue le parametre horizontale du bateua
    * @param py	constitue le parametre verticale du bateau du bateua
    * @return par inccrémentation le nombre de cout a chaque que la la case est est touche 
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
        setChanged();
        notifyObservers();
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
        setChanged();
        notifyObservers();
    }
    
    public Taille[] getTaille() {
		return taille;
	}
	public void setTaille(Taille[] taille) {
		this.taille = taille;
		setChanged();
        notifyObservers();
	}
	public int getT() {
		return t;
	}
	public void setT(int t) {
		this.t = t;
		setChanged();
        notifyObservers();
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
        Bateau a = new Bateau(1, 0, true, 4);
        Bateau c = new Bateau(1, 0, false, 3);
        Bateau d = new Bateau(1, 0, true, 2);
        System.out.println(b);
        System.out.println(a);
        System.out.println(c);
        System.out.println(d);
    }
    
 }
