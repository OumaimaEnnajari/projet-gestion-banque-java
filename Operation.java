package TP;

import java.time.LocalDate;

public class Operation {
	private final double montant;
	private final LocalDate date;
	private final Libele libele;

	public Operation(Libele libele,double montant) {
		this(libele,montant,LocalDate.now());
	}

	public Operation(Libele libele, double montant,LocalDate date) {
		this.libele = libele;
		this.montant = montant;
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}


	public LocalDate getDate() {
		return date;
	}


	public Libele getLibele() {
		return libele;
	}

	@Override
	public String toString() {
		String temp;
		temp = "++++++++++INFORMATIONS OPERATION++++++++++++++" + "\n\tLibele: " + this.libele + "\n\tMontant: "
				+ this.montant + "\n\tDate: " + this.date+"\n";
		return temp;
	}

}
