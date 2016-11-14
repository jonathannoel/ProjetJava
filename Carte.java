/**
 * Cette classe permet ŕ l'utilisateur d'entrer la cellule qu'il souhaite attaquer
 * et de faire en sorte que celle-ci soit validée. 
 * 
 * @author Jonathan Noël, Armand Tsameza, Pierre Tshiama.
 * @version 0.1 - 2016
 */

package Goodwin;

public class Carte {
	
	int carte [][]; // Taille de la carte
	int manche = 0; // Manche actuelle dans la partie
	String bateau [] = new String [] {"F4", "F5", "F6"}; // Creation de coordonées d'un bateau (TEST)
	ArrayList<String> cellulesTouchantes = new ArrayList<String>(); // Tableau qui contient les cellules jouees au fur et a mesure

	public Carte(int[][] carte){
		this.carte = carte;
	}

	/**
	 * Cette methode permet d'afficher la carte
	 **/
	public void affichage(){
	}
	
	public static void main(String[] args) {
	}
}
