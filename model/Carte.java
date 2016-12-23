package model;

/**
 * Cette classe permet de cr�er la carte du jeu.
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
	 * Cette m�thode retourne user1.
	 * @return user1.
	 */
	public String getUser1() {
		return user1;
	}

	/**
	 * Cette m�thode modifie user1.
	 * @param user1
	 */
	public void setUser1(String user1) {
		this.user1 = user1;
	}

	/**
	 * Cette m�thode r�cup�re user2.
	 * @return user2.
	 */
	public String getUser2() {
		return user2;
	}

	/**
	 * Cette m�thode modifie user2.
	 * @param user2
	 */
	public void setUser2(String user2) {
		this.user2 = user2;
	}

	/**
	 * Cette m�thode retourne une carte.
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
	 * Cette m�thode modifie la carte.
	 * @param carte : La carte � jour.
	 * @param numCarte : Num�ro de la carte � mettre � jour.
	 */
	public void setCarte(int[][] carte, int numCarte) {
		switch(numCarte){
			case(1): this.carte1 = carte;
			case(2): this.carte2 = carte;
		}
	}
	
	/**
	 * Cette m�thode r�cup�re la celluleAttaqueX.
	 * @return celluleAttaqueX.
	 */
	public int getCelluleAttaqueX() {
		return celluleAttaqueX;
	}
	
	/**
	 * Cette m�thode modifie la celluleAttaqueX.
	 */
	public void setCelluleAttaqueX(int celluleAttaqueX) {
		this.celluleAttaqueX = celluleAttaqueX;
	}
	
	/**
	 * Cette m�thode r�cup�re la celluleAttaqueY.
	 * @return celluleAttaqueY.
	 */
	public int getCelluleAttaqueY() {
		return celluleAttaqueY;
	}
	
	/**
	 * Cette m�thode modifie la celluleAttaqueY.
	 */
	public void setCelluleAttaqueY(int celluleAttaqueY) {
		this.celluleAttaqueY = celluleAttaqueY;
	}    
	
    
}

