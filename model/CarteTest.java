package model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import controller.CarteController;
import view.CarteView;

public class CarteTest {

	/**
	 * Initialise la Carte.
	 */
	Carte test;
	
	/**
	 * Prepare la variable test.
	 */
	@Before
	public void setUp(){
		Carte model = new Carte();
		CarteView view = new CarteView();
		test = new CarteController(model, view);
	}
	
	/**
	 * Test le bon fonctionnement de la methode setUSer.
	 */
	@Test
	public void setUser(){
		test.setUser("abc");
		assertEquals(test.getUser(), "abc");
		test.setUser("94197");
		assertEquals(test.getUser(), "94197");
	}
	
}
