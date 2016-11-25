package view;

import model.Carte;

public class CarteView extends Carte{

	public void afficherCarte(int[][] carte1, int[][] carte2, String user ){
		int count = 0;
		char a = 'A';
		System.out.println("Adversaire : \n");
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
                }
            }
            System.out.println();
        }
        System.out.println("\n"+user+"\n");
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
                }
                
            }
            System.out.println();
        }
	}
}
