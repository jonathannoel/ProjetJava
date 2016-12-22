package model;

/**
 * This class creates the map of the game
 * @author Pierre Tshiama  2TL2 group 14
 *
 */
public class Carte {
	private int [][]carte1;
	private int [][]carte2;
	private String user1, user2;
	int celluleAttaqueX,celluleAttaqueY;
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
	
	public String getUser1() {
		return user1;
	}

	public void setUser1(String user1) {
		this.user1 = user1;
	}

	public String getUser2() {
		return user2;
	}

	public void setUser2(String user2) {
		this.user2 = user2;
	}

	/**
	 * this method returns a map
	 * @param numCarte if 1, returns the opponent's map. If 2, returns the player's map.
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
	 * this method sets a map to an updated map
	 * @param carte updated map
	 * @param numCarte number of the map to be updated
	 */
	public void setCarte(int[][] carte, int numCarte) {
		switch(numCarte){
			case(1): this.carte1 = carte;
			case(2): this.carte2 = carte;
		}
	}
	public int getCelluleAttaqueX() {
		return celluleAttaqueX;
	}
	public void setCelluleAttaqueX(int celluleAttaqueX) {
		this.celluleAttaqueX = celluleAttaqueX;
	}
	public int getCelluleAttaqueY() {
		return celluleAttaqueY;
	}
	public void setCelluleAttaqueY(int celluleAttaqueY) {
		this.celluleAttaqueY = celluleAttaqueY;
	}    
	
    
}

