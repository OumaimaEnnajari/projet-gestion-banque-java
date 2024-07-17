package TP;

public enum Civilite {
	MONSIEUR("Mr"), MADAME("Mme"), MADEMOISELLE("Mlle");
	private String abbreviation = "";

	Civilite(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String toString() {
		return this.abbreviation;
	}
}
