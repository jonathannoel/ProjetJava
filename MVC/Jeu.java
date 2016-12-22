package MVC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
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

public class Jeu {
	public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
		ServerSocket s = new ServerSocket();
		Socket socket = new Socket();
		BufferedReader user2Input;
		PrintWriter serverOutput;
		ObjectOutputStream serverCarte;
		ObjectInputStream user2Carte;
		Scanner reader = new Scanner(System.in);
		Bateau[] bU = new Bateau[4];
		Bateau[] bA = new Bateau[4];
		boolean isMultiplayer = false;
		boolean gameOver = false;
		Random rand = new Random();
		int input = 0;
		/*----------USER-----------*/
		//Create new user
		Joueur joueurModel  = new Joueur();
		//Create a view : to write student details on console
		JoueurView joueurView = new JoueurView();
		JoueurController joueurController = new JoueurController(joueurModel, joueurView);
		
		/*--------- MAP -------*/
		Carte carteModel = new Carte();
		CarteView carteView = new CarteView();
		CarteController carteController = new CarteController(carteModel,carteView);
		joueurController.updateView();
		carteModel.setUser1(joueurModel.getName());
		
		/*----------Interaction Utilisateur --------*/
		InteractionsUtilisateur iuModel = new InteractionsUtilisateur();
		InteractionView iuView = new InteractionView();
		InteractionController iuController = new InteractionController(iuModel, iuView);
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
			s = new ServerSocket(4000);
			socket = s.accept();
			user2Input =
					new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			serverOutput = 
					new PrintWriter( 
					new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream())), true);
			String j1 = joueurController.getJoueurName();
			String j2;
			serverOutput.println(j1);
			j2 = user2Input.readLine();
			carteModel.setUser2(j2);
		}
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
						carteController.drawBateau(bU[i]);
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
						carteController.drawBateau(bU[i]);
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
							carteController.drawBateau(bU[i]);
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
							carteController.drawBateau(bU[i]);
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
							carteController.drawBateau(bU[i]);
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
							carteController.drawBateau(bU[i]);
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
							carteController.drawBateau(bU[i]);
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
							carteController.drawBateau(bU[i]);
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
		if(isMultiplayer == true){
			System.out.println("-----");
			serverCarte = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("-----");
			user2Carte = new ObjectInputStream(socket.getInputStream());
			System.out.println("-----");
			serverCarte.writeObject(bU);
			bA = (Bateau[]) user2Carte.readObject();
			for (int j = 0; j < bA.length; j++) {
				carteController.drawBateauA(bA[j]);
			}
			
		}
		if(isMultiplayer == false){
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
				carteController.drawBateauA(bA[i]);
				if(carteController.isOk()){
					i++;
				}
				carteController.setOk(false);
			}while(i<bA.length);
		}
		carteController.updateView();
		/*--------------------------------------------*/
		while(gameOver == false){
			iuController.updateView(1);
			iuController.demandeCellule();
			carteController.tir(iuController.getIntCaseIntroduite());
			carteController.updateView();
			carteController.randomTir();
			carteController.updateView();
			carteController.showAdversaireAttaque();
		}
		reader.close();
	}
	private static int randomNum(int min, int max){
		Random rand = new Random();
		return rand.nextInt(((max - min) + 1) + min);
	}
}
