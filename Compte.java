

package TP;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class Compte {
	protected static long nbCompte = 0;
	protected final long numeroCompte;
	protected final Personne proprietaire;
	protected double solde;
	protected final LocalDate dateOuverture;
	protected List<Operation> listeOperations;
	
	public Compte() {
		this(new Personne(),0);
	}
	public Compte(Personne proprietaire) {
		this(proprietaire, 0);
	}

	public Compte(Personne proprietaire, double solde){
            
		this(proprietaire, solde, LocalDate.now());
	}

	public Compte(Personne proprietaire, double solde, LocalDate dateOuverture){
		this.proprietaire = proprietaire;
          
		this.solde = solde;
		this.dateOuverture = dateOuverture;
		this.listeOperations = new ArrayList<Operation>();
		this.numeroCompte = ++nbCompte;
	}

	public String toString() {
		String tmp;
		tmp = "+++++++++INFORMATIONS COMPTE+++++++" + "\n\tNumero: " + this.numeroCompte + "\n\tDate ouverture: "
				+ this.dateOuverture + "\n\tProprietaire: " + this.proprietaire.getNom() + " "
				+ this.proprietaire.getPrenom() + "\n\tSolde: " + this.solde;
		return tmp;
	}

	public long getNumeroCompte() {
		return numeroCompte;
	}

	public Personne getProprietaire() {
		return proprietaire;
	}

	public double getSolde() {
		return solde;
	}

	public LocalDate getDateOuverture() {
		return dateOuverture;
	}

	public List<Operation> getListeOperations() {
		return listeOperations;
	}

	public void verser(double montant, Libele libele) throws EMontantMinException {
		String erreur;
		if (montant < 0) {
			erreur = "Versement d'un montant negatif" + "\n\tMontant: " + montant;
			throw new EMontantMinException(erreur);
		}
		this.solde += montant;
		this.listeOperations.add(new Operation(Libele.DEBIT, montant));
		System.out.println("Versement de " + montant + " effectu� avec succ�s sur le compte " + this.numeroCompte
				+ "\nNouveau solde: " + this.solde);
	}

	public void retirer(double montant, Libele libele) throws EMontantMinException {
		String erreur;
		if (montant < 0) {
			erreur = "Retrait d'un montant negatif" + "\n\tMontant: " + montant;
			throw new EMontantMinException(erreur);
		} else if (montant > this.solde) {
			erreur = "Retrait d'un montant superieur au solde" + "\n\tMontant: " + montant + "\n\tSolde: " + this.solde;
			throw new EMontantMinException(erreur);
		}
		this.solde -= montant;
		this.listeOperations.add(new Operation(Libele.CREDIT, montant));
		System.out.println("Retrait de " + montant + " effectu� avec succ�s sur le compte " + this.numeroCompte
				+ "\nNouveau solde: " + this.solde);
	}

	public void virement(double montant, Libele libele, Compte destination) throws EMontantMinException {
		this.retirer(montant, Libele.CREDIT);
		destination.verser(montant, Libele.DEBIT);

	}
	
	public void Historique(int nbOperations) {
		System.out.println("Compte Numero: "+this.numeroCompte
				+"\n\tSolde: "+this.solde);
		for(int i=listeOperations.size()-1;(i>=0)&&(nbOperations>=0);i--,nbOperations--) {
			System.out.print(listeOperations.get(i));
		}
		
	}

}
