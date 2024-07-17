package TP;

public enum Sexe {
	HOMME("H"), FEMME("F");
	private String abreviation = "";

	Sexe(String abreviation) {
		this.abreviation = abreviation;
	}
	public String toString() {
		return this.abreviation;
	}
}
