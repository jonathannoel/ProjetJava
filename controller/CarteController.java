package controller;

import java.util.Random;

import model.Bateau;
import model.Carte;
import view.CarteView;

public class CarteController extends Carte{
	private Carte model;
	private CarteView view;
	public boolean ok = false;
	public CarteController(Carte model, CarteView view){
		this.model = model;
		this.view = view;
	}
	
	
	/**
	 * this method returns the opponent's map
	 * @return the opponent's map carte1
	 */
    public int[][] getCarte(int numCarte) {
		switch(numCarte){
			case(1): return model.getCarte(1);
			case(2): return model.getCarte(2);
			default: return model.getCarte(2);
		}
	}
    /**
     * this method sets the oppononent's map to an updated map
     * @param carte1 : the updated map that will be set to old opponent's map 
     */
	public void setCarte(int[][] carte, int numCarte) {
		switch(numCarte){
			case(1): this.model.setCarte(carte, numCarte);
			case(2): this.model.setCarte(carte, 2);
		}
	}   
	
	public String getUser() {
		return this.model.getUser();
	}


	public void setUser(String user) {
		this.model.setUser(user);
	}
	
	/**
	 * @return the nok
	 */
	public boolean isOk() {
		return ok;
	}
	
	/**
	 * @param ok the ok to set
	 */
	public void setOk(boolean ok) {
		this.ok = ok;
	}


	/**
	 * This method allows the computer to shoot at a random spot on the map
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
	 * this method allows the player to shoot an opponent's boat
	 * @param position :position in which the player wishes to shoot
	 */
	public void tir(int[] position){
    	if(getCarte(1)[position[0]-1][position[1]-1] == 3){
    	getCarte(1)[position[0]-1][position[1]-1] = 2;}
    	else{getCarte(1)[position[0]-1][position[1]-1] = 1;}
    }
	
	/**
     * this method draws a boat
     * @param b : boat to be drawn
     */
	public void drawBateau(Bateau b) throws ArrayIndexOutOfBoundsException{
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
					getCarte(2)[(b.getTaille()[i].getX())-1][(b.getTaille()[i].getY())-1] = 3;
				}
				else{
					getCarte(2)[(b.getTaille()[i].getX())-1][(b.getTaille()[i].getY())-1] = 3;
				}
				i++;
			}
			ok = true;
			updateView();
			
		} catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Vous avez choisi une case hors carte, veuillez réessayer");
		}		
	}
	public void drawBateauA(Bateau b) throws ArrayIndexOutOfBoundsException{
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
					getCarte(1)[(b.getTaille()[i].getX())-1][(b.getTaille()[i].getY())-1] = 3;
				}
				else{
					getCarte(1)[(b.getTaille()[i].getX())-1][(b.getTaille()[i].getY())-1] = 3;
				}
				i++;
			}
			ok = true;			
		} catch(ArrayIndexOutOfBoundsException e){
		}		
	}
	public void showAdversaireAttaque(){
		System.out.println("Vous avez été attaqué à la case : " + toStr(getCelluleAttaqueY()) + "" + getCelluleAttaqueX());
	}
	
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
		
	public void updateView(){
		view.afficherCarte(getCarte(1), getCarte(2), getUser());
	}
	
}
