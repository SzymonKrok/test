package Sprawdzian1;

public class Osoba {
	private String imie;
	private String nazwisko;
	private String zawod;

	public Osoba(String imie, String nazwisko, String zawod) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.zawod = zawod;
	}

	public Osoba() {
	}

	public String getZawod() {
		return zawod;
	}

	public void setZawod(String zawod) {
		this.zawod = zawod;
	}

public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

@Override
public String toString() {
	return imie + " " + nazwisko;
}
}
