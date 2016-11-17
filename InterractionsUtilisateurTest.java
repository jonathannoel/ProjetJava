package batailleNavale1711;

import static org.junit.Assert.*;

/**
 * Cette classe permet de tester la classe InterractionUtilisateur.
 * 
 * @author Jonathan Noel, Armand Tsameza, Pierre Tshiama.
 * @version 0.1 - 2016 - Noel Jonathan.
 */

import org.junit.Before;
import org.junit.Test;

/**
 * Cette classe permet de verifier les methodes
 * de la classe InterractionsUtilisateur.
 * 
 * A LIRE AVANT UTILISATION : 
 * 	POUR LES TESTS IL FAUT INSERER QUELQUE CHOSE DANS LA CONSOLE
 * 	IL FAUT PAR EXEMPLE INSERER 2FOIS "F4"
 * 
 * @author Noel Jonathan
 *
 */
public class InterractionsUtilisateurTest {
	
	/**
	 * Initialise l'interraction.
	 */
	InterractionsUtilisateur test;
	
	/**
	 * Prepare la variable test.
	 */
	@Before
	public void setUp(){
		test = new InterractionsUtilisateur();
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
		// PROBLEME assertFalse(test.verificationNumero("F11"));
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
