package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * Klasa Twitter predstavlja listu objekata klase TwitterPoruka
 * 
 * @author Andjela Kojanic
 *
 */

public class Twitter {
	/**
	 * Lista ciji su elementi klase TwitterPoruka
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();

	/**
	 * Metoda vraca sve poruke iz liste
	 * 
	 * @return lista poruka
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}

	/**
	 * Ovom metodom se vrsi unos nove Twitter poruke u listu, tako sto se prvo
	 * inicijalizuje nova poruka i napuni se podacima koji su prosledjeni, a
	 * zatim se takva poruka dodaje na <strong>kraj</strong> liste
	 * 
	 * @param korisnik
	 * @param poruka
	 */
	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik); // suvisni navodnici
		tp.setPoruka(poruka);
		// Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}

	/**
	 * Metoda proverava i vraca niz poruka koje u sebi sadrze tag koji je
	 * prosledjen kao parametar sa maksimalnim kapacitetom od 100 poruka.
	 * Ukoliko takvih poruka ima vise, metoda vraca prvih 100 poruka.
	 * 
	 * @returns niz poruka koje sadrze tag
	 * @throws java.lang.RuntimeException
	 *             ako je tag null ili prazan string
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		// Pretrazuju se poruke i traze se one koje sadrze tag.
		// Ako se nadje neka takva, i ako nije prekoracen maxBroj
		// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		// se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					rezultat[brojac + 1] = poruke.get(i);
					brojac++;
				} else
					break;
		return rezultat;
	}
}