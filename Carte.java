/**
 * Cette classe permet ŕ l'utilisateur d'entrer la cellule qu'il souhaite attaquer
 * et de faire en sorte que celle-ci soit validée. 
 * 
 * @author Jonathan Noël, Armand Tsameza, Pierre Tshiama.
 * @version 0.1 - 2016
 */

package Goodwin;

public class Carte {
	int carte [][];
	
	public Carte(int[][] carte){
		this.carte = carte;
	}
	
	public static void main(String[] args) {
		int test [][] = new int [10][10];
		Carte cart = new Carte(test);
		cart.affichage();
	}
	//Methode qui permert d'afficher la carte
    public void affichage(){
    	for(int i=0 ; i < carte.length ; i++ ){
            for(int j=0 ; j < carte[0].length ; j++ ){
                this.carte[i][j] = 0;
            }
    	}
    		System.out.println("\tA \tB \tC \tD \tE \tF \tG \tH \tI \tJ");
        	System.out.println();
        for(int i=0 ; i < carte.length ; i++ ){
            System.out.print((i+1)+"");
            for(int j=0 ; j < carte[0].length ; j++ ){
                switch(carte[i][j]){
	                case(0):System.out.print("\t"+"~");break;
	                case(1): System.out.print("\t"+"*");break;
	                case(2):System.out.print("\t"+"X");break;
                }
                
            }
            System.out.println();
        }

    }
}
