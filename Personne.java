package TP;

import java.time.LocalDate;
import java.time.Period;

public class Personne {

	protected String nom;
	protected String prenom;
	protected LocalDate dateNaissance;
	protected EtatCivil etatcivil;
	protected Sexe sexe;
	protected Personne conjoint;

	public Personne() {}
	public Personne(String nom, String prenom) {
		this(nom,prenom,Sexe.HOMME);
	}

	public Personne(String nom, String prenom, Sexe sexe) {
		this(nom, prenom, LocalDate.now(), EtatCivil.CELIBATAIRE, sexe);
	}

	public Personne(String nom, String prenom, LocalDate dateNaissance, EtatCivil etatCivil, Sexe sexe) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.etatcivil = etatCivil;
		this.sexe = sexe;
	}

	public int getAge() {
		LocalDate today = LocalDate.now();
		Period p = Period.between(this.dateNaissance, today);
		return p.getYears();
	}

	public String toString() {
		String temp = "";
		if (this.sexe.equals(Sexe.HOMME)) {
			temp = Civilite.MONSIEUR + ". " + this.nom + " " + this.prenom + " est ne en " + this.dateNaissance
					+ " ,il est " + this.etatcivil;
		} else {
			if (this.etatcivil.equals(EtatCivil.MARIEE)) {
				temp = Civilite.MADAME + ". " + this.nom + " nee " + this.conjoint.nom + " est nee en "
						+ this.dateNaissance + " ,elle est " + this.etatcivil;
			} else {
				temp = Civilite.MADEMOISELLE +". "+ this.nom +" "+this.prenom + " "+ " est nee en " + this.dateNaissance + " ,elle est "
						+ this.etatcivil;
			}
		}
		return temp;
	}

	public void marier(Personne conjoint) {
		if (this.sexe.equals(Sexe.HOMME)) {
			if (conjoint.sexe.equals(Sexe.FEMME) && (conjoint.etatcivil.equals(EtatCivil.CELIBATAIRE)
					|| conjoint.etatcivil.equals(EtatCivil.VEUVE) || conjoint.etatcivil.equals(EtatCivil.DIVORCEE))) {
				this.conjoint = conjoint;
				this.etatcivil = EtatCivil.MARIE;
				conjoint.conjoint = this;
				conjoint.etatcivil = EtatCivil.MARIEE;
			}
		} else {
			if (conjoint.sexe.equals(Sexe.HOMME) && (conjoint.etatcivil.equals(EtatCivil.CELIBATAIRE)
					|| conjoint.etatcivil.equals(EtatCivil.VEUF) || conjoint.etatcivil.equals(EtatCivil.DIVORCE))) {
				this.conjoint = conjoint;
				this.etatcivil = EtatCivil.MARIEE;
				conjoint.conjoint = this;
				conjoint.etatcivil = EtatCivil.MARIE;
			}
		}
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public EtatCivil getEtatcivil() {
		return etatcivil;
	}

	public void setEtatcivil(EtatCivil etatcivil) {
		this.etatcivil = etatcivil;
	}

	public Sexe getSexe() {
		return sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	public Personne getConjoint() {
		return conjoint;
	}

	public void setConjoint(Personne conjoint) {
		this.conjoint = conjoint;
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Personne p1=new Personne("LAMAH","Michel Marie",Sexe.HOMME);
//		Personne p2=new Personne("WILL", "Michelle", Sexe.FEMME);
//		System.out.println(p1);
//		System.out.println(p2);
//		p1.marier(p2);
//		System.out.println(p1);
//		System.out.println(p2);
//		p1.setDateNaissance(LocalDate.of(1997, 11, 22));
//		System.out.println(Civilite.MONSIEUR+" "+p1.nom+" "+p1.prenom+" est n� le "+p1.getDateNaissance()+"\nIl a "+p1.getAge()+" ans");
//	}

}
