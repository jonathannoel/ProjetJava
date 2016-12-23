package model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Observable;

/**
 * Cette classe permet de gérer les insertions utilisateur.
 * 
 * @author Jonathan Noel, Armand Tsameza, Pierre Tshiama.
 * @version 2016
 * 
 */

public class Bateau extends Observable implements Serializable {
   
	/**
	 * Instanciation des variables.
	 */
	private boolean horizontal = true;
	private Taille[] taille;   // appel de la classe Taille pour former un tableau de position
	private int t;
	
	/**
	* Constructeur de la classe. 
	* @param x	constitue le parametre horizontale du bateau.
	* @param y	constitue le parametre verticale du bateau du bateau.
	* @param taille constitue la taille du bateau.
	* @param horizontal
	*/
	public  Bateau(int x, int y, boolean horizontal, int taille ){
       this.horizontal = horizontal;
       longueur(x, y, taille);
   }
   
   /**
    * cette methode permet de savoir si un bateau a 
    * une longueur verticale ou une longueur orizontale.
    * @param x	constitue le parametre horizontale du bateau.
    * @param y	constitue le parametre verticale du bateau du bateau.
    * @param taille constitue la taille du bateau.
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
    * attaqué ou pas  
    * @param px	constitue le parametre horizontale du bateau.
    * @param py	constitue le parametre verticale du bateau.
    * @return par incrémentation le nombre de cout a chaque que la la case est est touche .
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
     * Cette méthode retourne horizontal.
     * @return the horizontal
     */
    public boolean isHorizontal() {
        return horizontal;
    }
    
    /**
     * Cette méthode met à jour horizontal.
     * @param horizontal
     */
    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
        setChanged();
        notifyObservers();
    }
    
    /**
     * @return position
     */
    public Taille[] getPosition() {
        return this.taille;
    }
    
    /**
     * Cette méthode modifie la position courante.
     * @param position the position to set
     */
    public void setPosition(Taille[] taille) {
        this.taille = taille;
        setChanged();
        notifyObservers();
    }
    
    /**
     * Cette méthode retourne la taille.
     * @return taille.
     */
    public Taille[] getTaille() {
		return taille;
	}
    
    /**
     * Cette méthode modifie la taille.
     * @param taille
     */
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
 }