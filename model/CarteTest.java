package model;
/**
 * This class tests the classe Carte
 * @author Pierre Tshiama 2TL2 group 14 
 *
 */

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import controller.CarteController;
import view.CarteView;

public class CarteTest {

	/**
	 * Initialize the map
	 */
	Carte test;
	
	/**
	 * Prepare the variable test.
	 */
	@Before
	public void setUp(){
		Carte model = new Carte();
		CarteView view = new CarteView();
		test = new CarteController(model, view);
		test.setUser1("abc");
	}
	
	/**
	 * This method tests getUSer works.
	 */
	@Test
	public void getUser(){
		assertEquals(test.getUser1(), "abc");
	}
	
	
	
}
