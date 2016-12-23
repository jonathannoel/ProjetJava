package MVC;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


import controller.CarteController;
import controller.InteractionController;
import model.Bateau;
import model.Carte;
import model.InteractionsUtilisateur;
import view.CarteView;
import view.InteractionView;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.TextArea;

/**
 * Cette classe permet à de lancer la vue GUI. 
 * 
 * @author Jonathan Noel, Armand Tsameza, Pierre Tshiama.
 * @version 2016
 * 
 */


public class JeuVueGUI implements MouseListener{
	
	/**
	 * Instanciation des variables.
	 */
	
	JPanel panel_2 = new JPanel();
	JTextArea textArea = new JTextArea();
	JButton cases[][] = new JButton[10][10];
	public boolean joueurAJoue = true;
	public boolean jeuFini = false;
	private JTextField textField;
	JTextArea txtrTest = new JTextArea();
	Box verticalBox_3 = Box.createVerticalBox();
	
	/*--------- MAP -------*/
	private Carte carteModel = new Carte();
	private CarteView carteView = new CarteView();
	private CarteController carteController = new CarteController(carteModel,carteView);
	
	/*----------Interaction Utilisateur --------*/
	InteractionsUtilisateur iuModel = new InteractionsUtilisateur();
	InteractionView iuView = new InteractionView();
	InteractionController iuController = new InteractionController(iuModel, iuView);
	
	

	
	/**
	 * Cette méthode remplace joueurAJoue par le parametre.
	 * @param joueurAJoue : the joueurAJoue à définir.
	 */
	public void setJoueurAJoue(boolean joueurAJoue) {
		this.joueurAJoue = joueurAJoue;
	}
	

	/**
	 * Cette méthode retourne joueurAJoue.
	 * @return joueurAJoue
	 */
	public boolean isJoueurAJoue() {
		return this.joueurAJoue;
	}



	/**
	 * Cette méthode vas chercher le nom de l'utilisateur local.
	 * @return user : le nom du joueur.
	 */
	public String getUser(){
		return carteController.getUser1();
	}
	
	/**
	 * Cette méthode permet de créer la fenetre graphique.
	 * @wbp.parser.entryPoint
	 */
	public void drawFrame(){
		
		JFrame f = new JFrame ("Bataille Navale");
		f.setSize (500, 1000);
		f.setVisible (true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Création de la boite main
		
		
		Box main = Box.createVerticalBox();
		main.setBounds(0, 0, 482, 860);
		Container contentpane = f.getContentPane();
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		main.add(panel_3);
		panel_3.setLayout(null);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBounds(0, 5, 482, 36);
		panel_3.add(verticalBox);
		verticalBox.setPreferredSize(new Dimension(300, 50));
		
		JPanel panel_1 = new JPanel();
		verticalBox.add(panel_1);
		panel_1.setBackground(Color.ORANGE);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JTextArea txtrIciLeNom = new JTextArea();
		panel_1.add(txtrIciLeNom);
		txtrIciLeNom.setBackground(Color.ORANGE);

		txtrIciLeNom.setText("ICI LE NOM DU RIVAL");
		txtrIciLeNom.setLineWrap(true);
		txtrIciLeNom.setEditable(false);
		
		// Création de la boite carte de l'adversaire

		Box rival = Box.createVerticalBox(); 
		rival.setBackground(new Color(51, 153, 255));
		rival.setBounds(0, 42, 482, 360);
		panel_3.add(rival);
		rival.setPreferredSize (new Dimension (300, 300));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		
		char k;
		for(k = 'A'; k < 'K'; k++){
			String lettre = "" + k;
			JButton caseEau = new JButton(lettre);
			panel.add(caseEau);
		}
		
		for(int i = 0 ; i < cases.length ; i++) {
            for(int j = 0 ; j < cases[i].length ; j++) {
                cases[i][j] = new JButton();
                cases[i][j].setName(i + "" + j);
                cases[i][j].setPreferredSize(new Dimension(42, 25));
                cases[i][j].addMouseListener(this); 
                panel.add(cases[i][j]);
            }
        }
		
		rival.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBounds(0, 415, 482, 36);
		panel_3.add(verticalBox_1);
		
		JTextArea txtrIciLeNom_1 = new JTextArea();
		verticalBox_1.add(txtrIciLeNom_1);		
		
		String name = getUser();
		txtrIciLeNom_1.setText(name);
		
		txtrIciLeNom_1.setLineWrap(true);
		txtrIciLeNom_1.setEditable(false);
		txtrIciLeNom_1.setBackground(Color.ORANGE);
		
		Box verticalBox_2 = Box.createVerticalBox();
		verticalBox_2.setBounds(0, 451, 482, 360);
		panel_3.add(verticalBox_2);
		
		
		panel_2.setBackground(new Color(51, 153, 255));
		verticalBox_2.add(panel_2);
		panel_2.setLayout(null);
		
		
		textArea.setBackground(new Color(51, 153, 255));
		textArea.setBounds(0, 0, 482, 360);
		panel_2.add(textArea);
		
		
		verticalBox_3.setBounds(177, 821, 1, 1);
		panel_3.add(verticalBox_3);
		
		JPanel panel_4 = new JPanel();
		verticalBox_3.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnPlacer = new JButton("Placer");
		btnPlacer.setBounds(373, 821, 97, 25);
		panel_3.add(btnPlacer);
		
		textField = new JTextField();
		textField.setBounds(177, 821, 170, 22);
		panel_3.add(textField);
		textField.setColumns(10);
		txtrTest.setText("test");
		txtrTest.setBounds(10, 824, 162, 22);
		panel_3.add(txtrTest);
		
		f.getContentPane().setLayout(null);
		f.getContentPane().add(main);
		
		// AFFICHER LE TOUT
		f.setVisible (true);
		
	}
	
		
	/**
	 * Cette méthode permet de mettre à jour la vue actuelle du joueur local.
	 */
	public void updateView(){
		int p = 0;
		//if(isJoueurAJoue() || p == 0){
				carteController.setUser1("Bill");
				String user = carteController.getUser1();
				carteController.randomTir();
				carteController.showAdversaireAttaque();
				int count = 0;
				char a = 'A';
				
				int carte2 [][] = carteController.getCarte(2);
				
				reset();
		        textArea.append("\n"+user+"\n");
		        a = 'A';
		        count = 0;
		        while(count < carte2.length){
		        	textArea.append("             "+ a);
					a++;
					count++;
				}
		        textArea.append("\n");
		        for(int i=0 ; i < carte2.length ; i++ ){
		        	textArea.append((i+1)+"");
		            for(int j=0 ; j < carte2.length ; j++ ){
		                switch(carte2[i][j]){
			                case(0):textArea.append("             "+"~");break;
			                case(1):textArea.append("             "+"R");break;
			                case(2):textArea.append("             "+"X");break;
			                case(3):textArea.append("             "+"B");break;
		                }
		                
		            }
		            textArea.append("\n\n");
		        }
		        panel_2.add(textArea);
		    	joueurAJoue = false;
		    	p++;
			}
	      
       // }
	
	/**
	 * Cette méthode permet de reset la zone textArea.
	 */
	public void reset(){
		textArea.setText("");
	}
	
	/**
	 * Cette méthode est la méthode principale de la classe.
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String args[]) throws InterruptedException {
		JeuVueGUI lancer = new JeuVueGUI();
		
		lancer.drawFrame();
		

		lancer.updateView();
		System.out.println(lancer.isJoueurAJoue());
}
	
    
    /**
     * Cette méthode permet de traiter le clique sur les boutons.
     */
    public void mousePressed(MouseEvent e) {
    	String coords;
        String coordonnees [];
        int coordonneesInt [] = new int [2];
        int x,y;
    	
    	JButton btn = (JButton)(e.getSource());
    	coords = "" + btn.getName(); // Récupérer les coordonnées
    	coordonnees = coords.split("");
    	y = Integer.parseInt(coordonnees[0]);
    	coordonneesInt[0] = y;
    	x = Integer.parseInt(coordonnees[1]);
		coordonneesInt[1] = x;

    	btn.setForeground(new Color(255, 0, 51));
    	
    	iuController.setIntCaseIntroduite(coordonneesInt);
    	
    	carteController.tirGui(iuController.getIntCaseIntroduite(), btn);

    	this.updateView(); 

    }


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}