package com.twitter.poruke;

/**
 * Klasa predstavlja poruku na twitteru
 * 
 * @author Andjela Kojanic
 *
 */
public class TwitterPoruka {
	/**
	 * Atribut korisnik tipa String predstavlja naziv korisnika koji salje
	 * Twitter poruku
	 */
	private String korisnik;
	/**
	 * Atribut poruka tipa String predstavlja sadrzaj poruke
	 */
	private String poruka;

	/**
	 * Metoda vraca vrednost atributa korisnik
	 * 
	 * @return ime korisnika
	 */
	public String getKorisnik() {
		return korisnik;
	}

	/**
	 * Metoda postavlja vrednost atributa korisnik na prosledjenu vrednost
	 * parametra
	 * 
	 * @param korisnik
	 *            ime korisnika
	 * @throws java.lang.RuntimeException
	 *             ako je prosledjena vrednost
	 *             <ul>
	 *             <li>null</li>
	 *             <li>prazan string</li>
	 *             </ul>
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik.isEmpty()) // uklonjen !
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}

	/**
	 * Metoda vraca sadrzaj poruke
	 * 
	 * @return sadrzaj poruke
	 */
	public String getPoruka() {
		return poruka;
	}

	/**
	 * Metoda postavlja vrednost atributa poruka na String vrednost koja je
	 * prosledjena kao parametar
	 * 
	 * @param poruka
	 *            sadrzaj poruke
	 * @throws java.lang.RuntimeException
	 *             ako je prosledjena vrednost
	 *             <ul>
	 *             <li>null</li>
	 *             <li>prazan string</li>
	 *             <li>String duzine vece od 140 znakova</li>
	 *             </ul>
	 */
	public void setPoruka(String poruka) {
		if (poruka == null || poruka.isEmpty() || poruka.length() > 140) {
			/*
			 * uklonjeno this; odnosi se na poruku koja je parametar, ne atribut
			 * poruka = new String("") zamenjeno sa poruka.isEmpty()
			 */
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");

		}
		this.poruka = poruka;
	}

	/**
	 * Redefinisana toString metoda
	 * 
	 * @return formatiran ispis Twitter poruke
	 */

	@Override
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}

}
