package Sprawdzian1;

public enum TypAkcji {
	DODAJ_OSOBE("Dodaj osobę"),
	EDYTUJ_OSOBE("Edytuj osobę");

	private final String nazwa;

	TypAkcji(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getNazwa() {
		return nazwa;
	}



}
