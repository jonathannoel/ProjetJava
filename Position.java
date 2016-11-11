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
	//les methode getters et setters
	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	 public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	/**
	 *  cette methode permet de determine l'etat actuel d'un element de la carte
	 * @param i:sens horizontale de la position
	 * @param j:sens verticale de la position
	 * @return l'etat du bateau sur la carte
	 */
	public String etatActuel(String i , int j) {
		    if(this.x==i && this.y==j) {
		        if(this.etat =="touche"){
		            this.etat="abime";
		        }else if(this.etat=="abime")
		            this.etat="detruit";
		        } 
		    return this.etat;
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
		// TODO Auto-generated method stub
		Position p = new Position("A", 1);
		System.out.println(p);
		Position P = new Position("A", 2);
		System.out.println(P);
	}
	

}
