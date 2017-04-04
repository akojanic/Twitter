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
	public void testVratiSvePorukePraznaLista() {
		assertEquals(new LinkedList<TwitterPoruka>(), t.vratiSvePoruke());
	}

	@Test
	public void testVratiSvePoruke() {

		String[] k = { "korisnik1", "korisnik2", "korisnik3" };
		String[] p = { "poruka1", "poruka2", "poruka3" };

		t.unesi(k[0], p[0]);
		t.unesi(k[1], p[1]);
		t.unesi(k[2], p[2]);

		LinkedList<TwitterPoruka> svePoruke = t.vratiSvePoruke();

		for (int i = 0; i < svePoruke.size(); i++) {
			assertEquals(svePoruke.get(i).getKorisnik(), k[i]);
			assertEquals(svePoruke.get(i).getPoruka(), p[i]);
		}
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

	@Test
	public void testUnesiUPostojecuListu() {

		String[] k = { "korisnik1", "korisnik2", "korisnik3" };
		String[] p = { "poruka1", "poruka2", "poruka3" };
		
		TwitterPoruka e1 = new TwitterPoruka();
		e1.setKorisnik(k[0]);
		e1.setPoruka(p[0]);

		TwitterPoruka e2 = new TwitterPoruka();
		e2.setKorisnik(k[1]);
		e2.setPoruka(p[1]);

		TwitterPoruka e3 = new TwitterPoruka();
		e3.setKorisnik(k[2]);
		e3.setPoruka(p[2]);

		LinkedList<TwitterPoruka> lista = new LinkedList<TwitterPoruka>();
		
		lista.addLast(e1);
		lista.addLast(e2);
		lista.addLast(e3);
				
		t.setPoruke(lista);

		int brojPorukaPreUnosa = t.vratiSvePoruke().size();
		
		t.unesi("korisnik4", "poruka4");
		
		int brojPorukaPosleUnosa = t.vratiSvePoruke().size();
		
		assertEquals(brojPorukaPreUnosa + 1, brojPorukaPosleUnosa);
		assertEquals("korisnik4", t.vratiSvePoruke().getLast().getKorisnik());
		assertEquals("poruka4", t.vratiSvePoruke().getLast().getPoruka());
		
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPoruke() {
		t.unesi("korisnik1", "poruka1");
		t.unesi("korisnik2", "poruka2");
		
		TwitterPoruka[] nizPoruka = t.vratiPoruke(2, "por");
		TwitterPoruka[] niz = new TwitterPoruka[2];
		TwitterPoruka tp1 = new TwitterPoruka();
		tp1.setKorisnik("korisnik1");
		tp1.setPoruka("poruka1");
		niz[0] = tp1;
		TwitterPoruka tp2 = new TwitterPoruka();
		tp2.setKorisnik("korisnik2");
		tp2.setPoruka("poruka2");
		niz[1] = tp2;
		
		assertEquals(niz[0].getKorisnik(), nizPoruka[0].getKorisnik());
		assertEquals(niz[0].getPoruka(), nizPoruka[0].getPoruka());
		assertEquals(niz[1].getKorisnik(), nizPoruka[1].getKorisnik());
		assertEquals(niz[1].getPoruka(), nizPoruka[1].getPoruka());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNullTag() {
		t.vratiPoruke(13, null);

	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukePrazanString() {
		t.vratiPoruke(13, "");
	}

}
