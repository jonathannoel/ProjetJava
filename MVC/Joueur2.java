package MVC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

import controller.CarteController;
import controller.InteractionController;
import controller.JoueurController;
import model.Bateau;
import model.Carte;
import model.Croiseur;
import model.Fregate;
import model.InteractionsUtilisateur;
import model.Joueur;
import model.PorteAvion;
import model.Zodiac;
import view.CarteView;
import view.InteractionView;
import view.JoueurView;
/**
 * Classe qui permet d'executer le jeu en tant que deuxieme joueur
 */
public class Joueur2 {
	public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
		Socket socket = new Socket();
		BufferedReader serverInput;
		PrintWriter userOutput;
		ObjectOutputStream userCarte = null;
		ObjectInputStream serverCarte = null;
		Scanner reader = new Scanner(System.in);
		Bateau[] bU = new Bateau[4];
		Bateau[] bA = new Bateau[4];
		boolean isMultiplayer = false;
		boolean gameOver = false;
		Random rand = new Random();
		int input = 0;
		int bateauCount = 0;
		int bateauACount = 0;
		int [] bateauCoule = new int [4];
		int [] bateauACoule = new int [4];
		int [] serverAttaque = new int[2];
		int [] userAttaque = new int[2];
		/*----------Utilisateur-----------*/
		Joueur joueurModel  = new Joueur();
		//Create a view : to write student details on console
		JoueurView joueurView = new JoueurView();
		JoueurController joueurController = new JoueurController(joueurModel, joueurView);
		
		/*--------- Carte -------*/
		Carte carteModel = new Carte();
		CarteView carteView = new CarteView();
		CarteController carteController = new CarteController(carteModel,carteView);
		joueurController.updateView();
		carteModel.setUser1(joueurModel.getName());
		
		/*----------Interaction Utilisateur --------*/
		InteractionsUtilisateur iuModel = new InteractionsUtilisateur();
		InteractionView iuView = new InteractionView();
		InteractionController iuController = new InteractionController(iuModel, iuView);
		
		/*-------- Demande pour jouer en ligne ---------*/
		try {
			while(input != 1 && input != 2){
				iuController.updateView(4);
				input = Integer.parseInt(reader.next());
			}
		} catch (NumberFormatException e){
			System.out.println("Votre réponse n'est pas valable");
		}
		switch(input){
			case(1) : 
				isMultiplayer = true;
			break;
			case(2) : 
				isMultiplayer = false;
			break;
		}
		if(isMultiplayer == true){
			socket = new Socket("localhost",4000); 
			serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			userOutput = new PrintWriter( new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream())),true);
			String j1 = joueurController.getJoueurName();
			String j2;
			userOutput.println(j1);
			j2 = serverInput.readLine();
			carteModel.setUser2(j2);
			
		}
		
		/*---------------------------------------------------------------*/
		
		/*------------- Introduction des bateaux de l'utilisateur----------------*/
		
		input = 0;
		carteController.updateView();
		System.out.println("Vous allez maintenant introduire vos bateaux.");
		Thread.sleep(1000);
		
		int i = 0;
		do{
			try {
				while(input != 1 && input != 2){
					iuController.updateView(3);
					input = Integer.parseInt(reader.next());
				}
			} catch (NumberFormatException e){
				System.out.println("Votre réponse n'est pas valable");
			}
			switch(i){
				case 0:
					if(input == 1){
						System.out.println("Porte Avion (5 cases) :\n");
						iuController.updateView(0);
						iuController.demandeCellule();
						bU[i] = new PorteAvion(iuController.getIntCaseIntroduite()[0], iuController.getIntCaseIntroduite()[1], false);
						carteController.drawBateau(bU[i],3);
						if(carteController.isOk()){
							i++;
						}
						carteController.setOk(false);
						input = 0;
					}
					if(input == 2){
						System.out.println("Porte Avion : (5 cases) :\n");
						iuController.updateView(0);
						iuController.demandeCellule();
						bU[i] = new PorteAvion(iuController.getIntCaseIntroduite()[0], iuController.getIntCaseIntroduite()[1], true);
						carteController.drawBateau(bU[i],3);
						if(carteController.isOk()){
							i++;
						}
						carteController.setOk(false);
						input = 0;
					}
					break;
				case 1 : 
					for (int j = 0; j < 2; j++) {
						if(input == 1){
							System.out.println("Croiseur : (4 cases) :\n");
							iuController.updateView(0);
							iuController.demandeCellule();
							bU[i] = new Croiseur(iuController.getIntCaseIntroduite()[0], iuController.getIntCaseIntroduite()[1], false);
							carteController.drawBateau(bU[i],4);
							if(carteController.isOk()){
								i++;
							}
							carteController.setOk(false);
							input = 0;
						}
						if(input == 2){
							System.out.println("Croiseur : (4 cases) :\n");
							iuController.updateView(0);
							iuController.demandeCellule();
							bU[i] = new Croiseur(iuController.getIntCaseIntroduite()[0], iuController.getIntCaseIntroduite()[1], true);
							carteController.drawBateau(bU[i],4);
							if(carteController.isOk()){
								i++;
							}
							carteController.setOk(false);
							input = 0;
						}
					}
					break;
				case 2 : 
					for (int j = 0; j < 2; j++) {
						if(input == 1){
							System.out.println("Fregate : (3 cases) :\n");
							iuController.updateView(0);
							iuController.demandeCellule();
							bU[i] = new Fregate(iuController.getIntCaseIntroduite()[0], iuController.getIntCaseIntroduite()[1], false);
							carteController.drawBateau(bU[i],5);
							if(carteController.isOk()){
								i++;
							}
							carteController.setOk(false);
							input = 0;
						}
						if(input == 2){
							System.out.println("Fregate : (3 cases) :\n");
							iuController.updateView(0);
							iuController.demandeCellule();
							bU[i] = new Fregate(iuController.getIntCaseIntroduite()[0], iuController.getIntCaseIntroduite()[1], true);
							carteController.drawBateau(bU[i],5);
							if(carteController.isOk()){
								i++;
							}
							carteController.setOk(false);
							input = 0;
						}
					}
					break;
				case 3 : 
					for (int j = 0; j < 3; j++) {
						if(input == 1){
							System.out.println("Zodiac : (3 cases) :\n");
							iuController.updateView(0);
							iuController.demandeCellule();
							bU[i] = new Zodiac(iuController.getIntCaseIntroduite()[0], iuController.getIntCaseIntroduite()[1], false);
							carteController.drawBateau(bU[i],6);
							if(carteController.isOk()){
								i++;
							}
							carteController.setOk(false);
							input = 0;
						}
						if(input == 2){
							System.out.println("Zodiac : (3 cases) :\n");
							iuController.updateView(0);
							iuController.demandeCellule();
							bU[i] = new Zodiac(iuController.getIntCaseIntroduite()[0], iuController.getIntCaseIntroduite()[1], true);
							carteController.drawBateau(bU[i],6);
							if(carteController.isOk()){
								i++;
							}
							carteController.setOk(false);
							input = 0;
						}
					}
					break;		
			}
		}while(i<bU.length);
		
		/*---------------------------------------------------*/
		/*-------------Introduction des bateaux de l'adversaire(En ligne)-------------*/
		if(isMultiplayer == true){
			userCarte = new ObjectOutputStream(socket.getOutputStream());
			serverCarte = new ObjectInputStream(socket.getInputStream());
			userCarte.writeObject(bU);
			bA = (Bateau[]) serverCarte.readObject();
			for (int j = 0; j < bA.length; j++) {
				carteController.drawBateauA(bA[j], j+3);
			}
		}
		/*-------------Introduction des bateaux de l'adversaire(local)-------------*/
		else{
			carteModel.setUser2("Adversaire");
			i = 0;
			do{
				switch(i){
					case 0 :
						bA[0] = new PorteAvion(randomNum(1,10), randomNum(1,10), rand.nextBoolean());
						break;
					case 1 :
						bA[1] = new Croiseur(randomNum(1,10), randomNum(1,10), rand.nextBoolean());
						break;
					case 2 :
						bA[2] = new Fregate(randomNum(1,10), randomNum(1,10), rand.nextBoolean());
						break;
					case 3 :
						bA[3] = new Zodiac(randomNum(1,10), randomNum(1,10), rand.nextBoolean());
						break;
				}
				carteController.drawBateauA(bA[i], i+3);
				if(carteController.isOk()){
					i++;
				}
				carteController.setOk(false);
			}while(i<bA.length);
		}
		carteController.updateView();
		/*--------------------------------------------*/
		/*----------------Debut du jeu----------------*/
		while(gameOver == false){
			System.out.println("En attente de l'adversaire");
			serverAttaque = (int[]) serverCarte.readObject();
			iuController.setIntCaseIntroduite(serverAttaque);
			carteController.tir(iuController.getIntCaseIntroduite(), 2);
			carteController.updateView();
			carteController.showAdversaireAttaque();
			iuController.updateView(1);
			iuController.demandeCellule();
			carteController.tir(iuController.getIntCaseIntroduite(), 1);
			userAttaque = iuController.getIntCaseIntroduite();
			userCarte.writeObject(userAttaque);
			carteController.updateView();
			for (int j = 0; j < bateauACoule.length ; j++) {
				if(carteController.estCoule(j+3, 1)){
					if (bateauACoule[j] == j+3){}
					else{
						bateauACoule[j] = j+3;
						System.out.println("Un bateau enemie a été coulé");
						bateauACount++;
					}
					
				}
			}
			if (bateauACount == 1){
				gameOver = true;
				System.out.println("Vous avez gagné");
				break;
			}
			for (int j = 0; j < bateauCoule.length ; j++) {
				if(carteController.estCoule(j+3, 2)){
					if (bateauCoule[j] == j+3){}
					else{
						bateauCoule[j] = j+3;
						System.out.println("Un de vos bateaux a été coulé");
						bateauCount++;
					}
					
				}
			}
			if (bateauCount == 1){
				gameOver = true;
				System.out.println("Vous avez perdu");
				break;
			}
			
		}
		reader.close();
		/*-------------------------------------*/
	}
	/**
	 * Cette methode retourne un nombre aleatoire entre le parametre min et le parametre max
	 * @param min
	 * @param max
	 * @return un nombre aleatoire entre min et max
	 */
	private static int randomNum(int min, int max){
		Random rand = new Random();
		return rand.nextInt(((max - min) + 1) + min);
	}
}
