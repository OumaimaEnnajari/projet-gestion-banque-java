package TP;

public enum Libele {
	CREDIT("Credit"), DEBIT("Debit"), VIREMENT("Virement");
	private String type;

	Libele(String type) {
		this.type=type;
	}
	
	public String toString() {
		return this.type;
	}
}
