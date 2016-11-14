/**
 * 
 */
package bn;

/**
 * @author MIX CELLO DJ
 * cette classe permet de savoir la position d'un bateau sur la carte 
 */
public class Position {
	private String x;
	private int y;
	private String etat;
	
	// instance des différentes variables de la classe 
	public Position(String x, int y){
		this.x = x;
		this.y = y;
		this.etat = "intact";
	}
	
	/**
	 *  cette methode permet de determine l'etat actuel d'un element de la carte
	 * @param i:sens horizontale de la position
	 * @param j:sens verticale de la position
	 * @return l'etat du bateau sur la carte
	 */
	public String etatActuel(String i , int j) {
	}
	
	//methode toString
	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + ", etat=" + etat + "]";
	}

	/**
	 * petit test de la classe 
	 * @param args
	 */
	public static void main(String[] args) {
	}
	

}
