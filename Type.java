package TP;

public enum Type {
	CC("Compte Courant"), CE("Compte Epargne");
	private String type;

	Type(String type) {
		this.type=type;
	}
	
	public String toString() {
		return this.type;
	}
}
