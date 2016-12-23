package model;

/**
 * Cette classe permet de créer la carte du jeu.
 * 
 * @author Jonathan Noel, Armand Tsameza, Pierre Tshiama.
 * @version 2016
 * 
 */
public class Carte {
	
	/**
	 * Instanciation des variables.
	 */
	private int [][]carte1;
	private int [][]carte2;
	private String user1, user2;
	int celluleAttaqueX,celluleAttaqueY;
	
	/**
	 * Constructeur de la classe.
	 */
	public Carte(){
		this.carte1 = new int[10][10];
		this.carte2 = new int[10][10];
		for(int i=0 ; i < carte2.length ; i++ ){
            for(int j=0 ; j < carte2.length ; j++ ){
                carte1[i][j]=0;
                carte2[i][j]=0;
            }
    	}
	}
	
	/**
	 * Cette méthode retourne user1.
	 * @return user1.
	 */
	public String getUser1() {
		return user1;
	}

	/**
	 * Cette méthode modifie user1.
	 * @param user1
	 */
	public void setUser1(String user1) {
		this.user1 = user1;
	}

	/**
	 * Cette méthode récupère user2.
	 * @return user2.
	 */
	public String getUser2() {
		return user2;
	}

	/**
	 * Cette méthode modifie user2.
	 * @param user2
	 */
	public void setUser2(String user2) {
		this.user2 = user2;
	}

	/**
	 * Cette méthode retourne une carte.
	 * @param numCarte : si 1 retourne la carte rivale. Si 2, la carte du joueur courant.
	 * @return returns a map
	 */
    public int[][] getCarte(int numCarte) {
		switch(numCarte){
			case(1): return carte1;
			case(2): return carte2;
			default: return carte2;
		}
	}
    
	/**
	 * Cette méthode modifie la carte.
	 * @param carte : La carte à jour.
	 * @param numCarte : Numéro de la carte à mettre à jour.
	 */
	public void setCarte(int[][] carte, int numCarte) {
		switch(numCarte){
			case(1): this.carte1 = carte;
			case(2): this.carte2 = carte;
		}
	}
	
	/**
	 * Cette méthode récupère la celluleAttaqueX.
	 * @return celluleAttaqueX.
	 */
	public int getCelluleAttaqueX() {
		return celluleAttaqueX;
	}
	
	/**
	 * Cette méthode modifie la celluleAttaqueX.
	 */
	public void setCelluleAttaqueX(int celluleAttaqueX) {
		this.celluleAttaqueX = celluleAttaqueX;
	}
	
	/**
	 * Cette méthode récupère la celluleAttaqueY.
	 * @return celluleAttaqueY.
	 */
	public int getCelluleAttaqueY() {
		return celluleAttaqueY;
	}
	
	/**
	 * Cette méthode modifie la celluleAttaqueY.
	 */
	public void setCelluleAttaqueY(int celluleAttaqueY) {
		this.celluleAttaqueY = celluleAttaqueY;
	}    
	
    
}

