package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {

	Twitter t;

	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

	@Test
	public void testVratiSvePoruke() {
		LinkedList<TwitterPoruka> pom = t.vratiSvePoruke();
		assertEquals(pom, t.vratiSvePoruke());
	}

	@Test
	public void testUnesi() {
		String kor = "Andjela";
		String por = "tekst poruke";
		t.unesi(kor, por);
		LinkedList<TwitterPoruka> pomocna = t.vratiSvePoruke();
		assertEquals(kor, pomocna.getLast().getKorisnik());
		assertEquals(por, pomocna.getLast().getPoruka());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPoruke() {
		int max = 10;
		String tag = "na";
		TwitterPoruka[] rezultat = t.vratiPoruke(max, tag);

		for (int i = 0; i < rezultat.length; i++) {
			assertTrue(rezultat[i].getPoruka().contains(tag));
		}
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNullTag() {
		int max = 10;
		String tag = null;

		TwitterPoruka[] rezultat = t.vratiPoruke(max, tag);
		for (int i = 0; i < rezultat.length; i++) {
			assertTrue(rezultat[i].getPoruka().contains(tag));
		}
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukePrazanString() {
		int max = 10;
		String tag = "";
		TwitterPoruka[] rezultat = t.vratiPoruke(max, tag);
		for (int i = 0; i < rezultat.length; i++) {
			assertTrue(rezultat[i].getPoruka().contains(tag));
		}
	}

}
