package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwitterPorukaTest {

	TwitterPoruka poruka;

	@Before
	public void setUp() throws Exception {
		poruka = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		poruka = null;
	}

	@Test
	public void testSetKorisnik() {
		poruka.setKorisnik("Andjela");
		assertEquals("Andjela", poruka.getKorisnik());

	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		poruka.setKorisnik(null);

	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		poruka.setKorisnik("");

	}

	@Test
	public void testSetPoruka() {
		String unetaPoruka = "hhhhhhhhhhh";
		poruka.setPoruka(unetaPoruka);
		assertEquals(unetaPoruka, poruka.getPoruka());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		poruka.setPoruka(null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaPrazanString() {
		String unetaPoruka = "";
		poruka.setPoruka(unetaPoruka);
		assertEquals(unetaPoruka, poruka.getPoruka());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaDugString() {
		String pom = "";
		for (int i = 0; i < 200; i++) {
			pom += "x";
		}
		poruka.setPoruka(pom);
	}

	@Test
	public void testToString() {

		poruka.setKorisnik("Andjela");
		poruka.setPoruka("Sadrzaj poruke");

		String pom = "KORISNIK:" + poruka.getKorisnik() + " PORUKA:" + poruka.getPoruka();
		assertEquals(pom, poruka.toString());
	}

}
