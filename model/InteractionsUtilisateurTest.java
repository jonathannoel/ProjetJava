package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import controller.InteractionController;
import view.InteractionView;

public class InteractionsUtilisateurTest {

	/**
	 * Initialise l'interraction.
	 */
	InteractionController test;
	
	/**
	 * Prepare la variable test.
	 */
	@Before
	public void setUp(){
		InteractionsUtilisateur model = new InteractionsUtilisateur();
		InteractionView view = new InteractionView();
		test = new InteractionController(model, view);
	}
	
	/**
	 * Test le bon fonctionnement de la methode verificationLettre.
	 */
	@Test
	public void testVerificationLettre(){
		assertTrue(test.verificationLettre("A"));
		assertTrue(test.verificationLettre("B"));
		assertTrue(test.verificationLettre("C"));
		assertFalse(test.verificationLettre("K"));
		assertFalse(test.verificationLettre("Z"));
	}
	
	/**
	 * Test le bon fonctionnement de la methode verificationNumero.
	 */
	@Test
	public void testVerificationNumero(){
		assertTrue(test.verificationNumero("F1"));
		assertTrue(test.verificationNumero("F2"));
		assertTrue(test.verificationNumero("F3"));
		assertTrue(test.verificationNumero("F5"));
		assertTrue(test.verificationNumero("F9"));
		assertTrue(test.verificationNumero("F10"));
		assertFalse(test.verificationNumero("F11"));
	}
	
	/**
	 * Test le bon fonctionnement de la methode toInt.
	 */
	@Test
	public void testToInt(){
		assertEquals(1, test.toInt("A1"));
		assertEquals(6, test.toInt("F9"));
		assertEquals(4, test.toInt("D4"));
		assertEquals(0, test.toInt("Z1"));
	}
	

}
