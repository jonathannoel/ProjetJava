package view;

import model.Carte;

public class CarteView extends Carte{
	/**
	 * Cette methode permet d'afficher la carte1 et carte2 avec leur nom respectifs user1 et user2
	 * @param carte1
	 * @param carte2
	 * @param user1
	 * @param user2
	 */
	public void afficherCarte(int[][] carte1, int[][] carte2, String user1, String user2 ){
		int count = 0;
		char a = 'A';
		System.out.println("\nAdversaire : "+user2+"\n");
		while(count<carte1.length){
			System.out.print("\t"+ a);
			a++;
			count++;
		}
		System.out.println();
        for(int i=0 ; i < carte1.length ; i++ ){
            System.out.print((i+1)+"");
            for(int j=0 ; j < carte1.length ; j++ ){
                switch(carte1[i][j]){
	                case(0):System.out.print("\t"+"~");break;
	                case(1): System.out.print("\t"+"*");break;
	                case(2):System.out.print("\t"+"X");break;
	                case(3):System.out.print("\t" + "B");break;
	                case(4):System.out.print("\t" + "B");break;
	                case(5):System.out.print("\t" + "B");break;
	                case(6):System.out.print("\t" + "B");break;
                }
            }
            System.out.println();
        }
        System.out.println("\n"+user1+"\n");
        a = 'A';
        count = 0;
        while(count<carte1.length){
			System.out.print("\t"+ a);
			a++;
			count++;
		}
        System.out.println();
        for(int i=0 ; i < carte2.length ; i++ ){
            System.out.print((i+1)+"");
            for(int j=0 ; j < carte2.length ; j++ ){
                switch(carte2[i][j]){
	                case(0):System.out.print("\t"+"~");break;
	                case(1): System.out.print("\t"+"*");break;
	                case(2):System.out.print("\t"+"X");break;
	                case(3):System.out.print("\t" + "B");break;
	                case(4):System.out.print("\t" + "B");break;
	                case(5):System.out.print("\t" + "B");break;
	                case(6):System.out.print("\t" + "B");break;
                }
                
            }
            System.out.println();
        }
	}
}
