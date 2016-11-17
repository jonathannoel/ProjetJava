package batailleNavale1711;

/**
 * Cette classe permet a l'utilisateur d'entrer la cellule qu'il souhaite attaquer
 * et de faire en sorte que celle-ci soit validee. 
 * 
 * @author Jonathan Noel, Armand Tsameza, Pierre Tshiama.
 * @version 0.1 - 2016 - Noel Jonathan.
 */


import java.util.ArrayList; // Permettra le stockage des donnees deja inserees
import java.util.Arrays;
import java.util.Scanner;

public class InterractionsUtilisateur {
	
	/**
	 * Variables utilisees dans la classe.
	 */
	private String strCaseIntroduite;
	private int[] intCaseIntroduite = new int [2];
    ArrayList<String> cellulesUtilisees = new ArrayList<String>();
    
    /**
     * Constructeur sans parametres de la classe.
     */
    public InterractionsUtilisateur(){
    	System.out.println("Veuillez insérer une cellule dans la console");
    	demandeCellule();
    }
    
	/**
	 * Constructeur avec parametres de la classe
	 * @param i : 0 pour ajouter des bateaux sur sa carte,
	 * 			  1 pour attaquer une cellule
	 */
	public InterractionsUtilisateur(int i){
		switch(i){
		case(0) : 
			System.out.println("Ou voulez-vous mettre votre bateau ?");
			demandeCellule();
			break;
		case(1) : 
			System.out.println("Quelle cellule voulez-vous attaquer ?");
			demandeCellule();
			break;
		}
	}
	
	/**
	 * Cette methode prend la cellule inseree par l'utilisateur et la verifie
	 */
	public void demandeCellule(){
		
		/*--------Lecture de la console + Verifications----------*/
		Scanner reader = new Scanner(System.in);
		this.strCaseIntroduite = reader.nextLine();
		
		while(this.strCaseIntroduite.length() < 2 || 
					this.strCaseIntroduite.length() > 3 || 
						verificationLettre(this.strCaseIntroduite) == false || 
							verificationNumero(this.strCaseIntroduite) == false){
			
			if(verificationLettre(this.strCaseIntroduite) == false || 
					verificationNumero(this.strCaseIntroduite) == false){
				
				System.out.println("Veuillez introduire une lettre(A-J), puis un chiffre(1-10)");
			}
			
			else{
				System.out.println("Veuillez introduire une lettre, puis un chiffre");
			}
			
			this.strCaseIntroduite = reader.nextLine();
		}
		this.intCaseIntroduite[0] = Integer.parseInt(String.valueOf(this.strCaseIntroduite.charAt(1)));
		this.intCaseIntroduite[1] = toInt(this.strCaseIntroduite);
	}
	
	/**
	 * Cette methode verifie si la lettre entree est entre A et J.
	 * @param s : Le caractere entre A et J.
	 * @return true si la lettre est validee, false sinon.
	 */
	public boolean verificationLettre(String s){
		String convert = s.toUpperCase();
		char lettre = convert.charAt(0);
		
		if(lettre >= 'A' && !(lettre > 'J')){
			return true;
		}
		return false;
	}
	
	/**
	 * Cette methode verifie que le numero de cellule entree
	 * soit dans les conditions.
	 * s = 1 a 10.
	 * @param s : Le numero de case souhaite par l'utilisateur.
	 * @return true si le numero est valide, false sinon.
	 */
	public boolean verificationNumero(String s){
		int nombre = Integer.parseInt(Character.toString(s.charAt(1)));
		
		if(strCaseIntroduite.length() > 2){
			
			if(Integer.parseInt(Character.toString(s.charAt(2))) == 0 & 
				Integer.parseInt(Character.toString(s.charAt(1))) == 1){
				String nbr = nombre + 
							"" + 
							Integer.parseInt(Character.toString(s.charAt(2)));
				nombre = Integer.parseInt(nbr);
				System.out.println(nombre);
				return true;
				
			} else {
				return false;
			}
		}
		
		if(nombre >= 1 && nombre <= 10 ){
			return true;
		}
		return false;
	}
	
	public void ajoutDesCellules(String s){
		cellulesUtilisees.add(s);
	}
	
	public int[] getIntCaseIntroduite() {
		return intCaseIntroduite;
	}

	public String toString(){
		return ("La case introduite est : " + strCaseIntroduite);
	}
	/**
	 * Converti les lettres en chiffre.
	 * Est utilise pour convertir une case "B" en nombre pour l'utilisation
	 * de l'attaque dans un tableau a deux dimensions.
	 * @param s : la lettre introduite.
	 * @return un int representant la lettre
	 */
	public int toInt(String s){
		switch(s.toUpperCase().charAt(0)){
			case('A') : return 1;
			case('B') : return 2;
			case('C') : return 3;
			case('D') : return 4;
			case('E') : return 5;
			case('F') : return 6;
			case('G') : return 7;
			case('H') : return 8;
			case('I') : return 9;
			case('J') : return 10;
		}
		return 0;
	}
}
