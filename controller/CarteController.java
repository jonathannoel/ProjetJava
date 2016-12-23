package controller;

import java.util.Random;

import javax.swing.JButton;

import model.Bateau;
import model.Carte;
import view.CarteView;

/**
 * Cette classe permet de mettre les données de la carte à jour.
 * 
 * @author Jonathan Noel, Armand Tsameza, Pierre Tshiama.
 * @version 0.1 - 2016
 */

public class CarteController extends Carte{
	
	/**
	 * Instanciation des variables.
	 */
	private Carte model;
	private CarteView view;
	public boolean ok = false;
	
	/**
	 * Constructeur avec deux paramètres.
	 * @param model
	 * @param view
	 */
	public CarteController(Carte model, CarteView view){
		this.model = model;
		this.view = view;
	}
	
	
	/**
	 * Cette méthode retourne la carte du rival.
	 * @return La carte du rival : carte1 ou carte2 la carte du joueur courant.
	 */
    public int[][] getCarte(int numCarte) {
		switch(numCarte){
			case(1): return model.getCarte(1);
			case(2): return model.getCarte(2);
			default: return model.getCarte(2);
		}
	}
    
    /**
     * Cette méthode permet de mettre à jour la carte carte.
     * @param carte1 : La carte à jour du rival ou 
     * carte2 la carte à jour du joueur courant.
     */
	public void setCarte(int[][] carte, int numCarte) {
		switch(numCarte){
			case(1): this.model.setCarte(carte, numCarte);
			case(2): this.model.setCarte(carte, 2);
		}
	}   
	
	/**
	 * Cette méthode retourne le joueur courant.
	 */
	public String getUser1() {
		return this.model.getUser1();
	}

	/**
	 * Cette méthode modifie le nom du joueur courant.
	 */
	public void setUser1(String user) {
		this.model.setUser1(user);
	}
	
	/**
	 * Cette méthode retourne le joueur courant.
	 */
	public String getUser2() {
		return this.model.getUser2();
	}

	/**
	 * Cette méthode modifie le nom du joueur courant.
	 */
	public void setUser2(String user) {
		this.model.setUser2(user);
	}
	
	/**
	 * Cette méthode retourne ok.
	 * @return the nok
	 */
	public boolean isOk() {
		return ok;
	}
	
	/**
	 * Cette méthode met ok à jour.
	 * @param ok : ok à définir.
	 */
	public void setOk(boolean ok) {
		this.ok = ok;
	}


	/**
	 * Cette méthode permet à l'ordinateur de tirer sur une case aléatoire.
	 */
	public void randomTir(){
		Random rand = new Random();
		int x = getCelluleAttaqueX();
		int y = getCelluleAttaqueY();
		x = rand.nextInt((10 - 1) + 1) + 1;
		y = rand.nextInt((10 - 1) + 1) + 1;
		while(getCarte(2)[x-1][y-1] == 1 || getCarte(2)[x-1][y-1] == 2) {
			x = rand.nextInt((10 - 1) + 1) + 1;
			y = rand.nextInt((10 - 1) + 1) + 1;
		}
		setCelluleAttaqueX(x);
		setCelluleAttaqueY(y);
		if(getCarte(2)[x-1][y-1] == 3){
	    	getCarte(2)[x-1][y-1] = 2;}
	    	else{getCarte(2)[x-1][y-1] = 1;}
	}
	
	/**
	 * Cette méthode permet au joueur de tirer sur un bateau ennemi. 
	 * @param position : La position sur laquelle le joueur veut tirer.
	 */
	public void tir(int[] position, int numCarte){
    	if(getCarte(numCarte)[position[0]-1][position[1]-1] == 3 ||getCarte(numCarte)[position[0]-1][position[1]-1] == 4||
			getCarte(numCarte)[position[0]-1][position[1]-1] == 5||getCarte(numCarte)[position[0]-1][position[1]-1] == 6){
    			getCarte(numCarte)[position[0]-1][position[1]-1] = 2;
    		}
    	if(getCarte(numCarte)[position[0]-1][position[1]-1] == 2){
    		getCarte(numCarte)[position[0]-1][position[1]-1] = 2;}
    	else{
    		getCarte(numCarte)[position[0]-1][position[1]-1] = 1;}
    	setCelluleAttaqueX(position[0]);
		setCelluleAttaqueY(position[1]);
    }
	
	/**
	 * Cette méthode permet au joueur de tirer sur un bateau ennemi.(Version GUI) 
	 * @param position : La position sur laquelle le joueur veut tirer.
	 */
	public void tirGui(int[] position, JButton btn){
    	if(getCarte(1)[position[0]-1][position[1]-1] == 3){
    		btn.setText("B");
    	}
    	else{
    		btn.setText("X");
    	}
    }
	/**
     * Cette méthode dessine un bateau sur la carte.
     * @param b : le bateau à dessiner.
     */
	public void drawBateau(Bateau b, int bateauId) throws ArrayIndexOutOfBoundsException{
		int i = 0, j = 0;
		
		try{
			while(j < b.getT()){
				if(b.isHorizontal()){
					if(getCarte(2)[(b.getTaille()[j].getX())-1][(b.getTaille()[j].getY())-1] == 0){
						getCarte(2)[(b.getTaille()[j].getX())-1][(b.getTaille()[j].getY())-1] = 0;
					} else { throw new ArrayIndexOutOfBoundsException(); }
				}
				else{
					if(getCarte(2)[(b.getTaille()[j].getX())-1][(b.getTaille()[j].getY())-1] == 0){
						getCarte(2)[(b.getTaille()[j].getX())-1][(b.getTaille()[j].getY())-1] = 0;
					} else { throw new ArrayIndexOutOfBoundsException(); }
				}
				j++;
			}
			
			while(i < b.getT()){
				if(b.isHorizontal()){				
					getCarte(2)[(b.getTaille()[i].getX())-1][(b.getTaille()[i].getY())-1] = bateauId;
				}
				else{
					getCarte(2)[(b.getTaille()[i].getX())-1][(b.getTaille()[i].getY())-1] = bateauId;
				}
				i++;
			}
			ok = true;
			updateView();
			
		} catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Vous avez choisi une case hors carte, veuillez réessayer");
		}		
	}
	
	/**
	 * Cette méthode permet de dessiner les bateaux de l'adversaire.
	 * @param b : Le bateau à dessiner.
	 * @param bateauId : l'id du bateau.
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public void drawBateauA(Bateau b, int bateauId) throws ArrayIndexOutOfBoundsException{
		int i = 0, j = 0;
		
		try{
			while(j < b.getT()){
				if(b.isHorizontal()){
					if(getCarte(1)[(b.getTaille()[j].getX())-1][(b.getTaille()[j].getY())-1] == 0){
						getCarte(1)[(b.getTaille()[j].getX())-1][(b.getTaille()[j].getY())-1] = 0;
					} else { throw new ArrayIndexOutOfBoundsException(); }
				}
				else{
					if(getCarte(1)[(b.getTaille()[j].getX())-1][(b.getTaille()[j].getY())-1] == 0){
						getCarte(1)[(b.getTaille()[j].getX())-1][(b.getTaille()[j].getY())-1] = 0;
					} else { throw new ArrayIndexOutOfBoundsException(); }
				}
				j++;
			}
			
			while(i < b.getT()){
				if(b.isHorizontal()){				
					getCarte(1)[(b.getTaille()[i].getX())-1][(b.getTaille()[i].getY())-1] = bateauId;
				}
				else{
					getCarte(1)[(b.getTaille()[i].getX())-1][(b.getTaille()[i].getY())-1] = bateauId;
				}
				i++;
			}
			ok = true;			
		} catch(ArrayIndexOutOfBoundsException e){
		}		
	}
	
	/**
	 * Cette méthode retourne si un bateau est coulé.
	 * @param bateauId : l'id du bateau.
	 * @param numCarte : la carte sur laquelle le bateau se trouve.
	 * @return true si le bateau est coulé, false sinon.
	 */
	public boolean estCoule(int bateauId, int numCarte){
		for (int i = 0; i < getCarte(numCarte).length; i++) {
			for (int j = 0; j < getCarte(numCarte)[0].length; j++) {
				if(getCarte(numCarte)[i][j] == bateauId){
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Cette méthode affiche l'attaque de l'ordinateur.
	 */
	public void showAdversaireAttaque(){
		System.out.println("Vous avez été attaqué à la case : " + toStr(getCelluleAttaqueY()) + "" + getCelluleAttaqueX());
	}
	
	/**
	 * Cette méthode permet de convertir les numéros en lettres.
	 * @param s : le numéro à convertir.
	 * @return la lettre associée au numéro s.
	 */
	public String toStr(int s){
		switch(s){
			case(1) : return "A";
			case(2) : return "B";
			case(3) : return "C";
			case(4) : return "D";
			case(5) : return "E";
			case(6) : return "F";
			case(7) : return "G";
			case(8) : return "H";
			case(9) : return "I";
			case(10) : return "J";
		}
		return "";
	}
		
	/**
	 * Cette méthode permet de mettre à jour la carte.
	 */
	public void updateView(){
		view.afficherCarte(getCarte(1), getCarte(2), getUser1(), getUser2());
	}
	
}