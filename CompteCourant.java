package TP;



public class CompteCourant extends Compte {
	protected double montantDecouvertAutorise;

	public CompteCourant(Personne proprietaire) {
		this(proprietaire, 0);
	}

	public CompteCourant(Personne proprietaire, double montantDecouvertAutorise) {
		this(proprietaire, 0, montantDecouvertAutorise);
	}

	public CompteCourant(Personne proprietaire, double montant, double montantDecouvertAutorise) {
		super(proprietaire, montant);
		this.montantDecouvertAutorise = montantDecouvertAutorise;
	}

	public double getMontantDecouvertAutorise() {
		return montantDecouvertAutorise;
	}

	@Override
	public void retirer(double montant, Libele libele) throws EMontantMinException {
		String erreur;
		// TODO Auto-generated method stub
		if (montant > (this.solde + this.montantDecouvertAutorise)) {
			erreur = "Montant de retrait superieur � Montant requis de retrait" + "\n\tSolde: " + this.solde
					+ "\n\tDecouvert autorise: " + this.montantDecouvertAutorise + "\n\tMontant requis: "
					+ (this.solde + this.montantDecouvertAutorise);
			throw new EMontantMinException(erreur);
		}
		this.solde -= montant;
		this.listeOperations.add(new Operation(Libele.CREDIT, montant));
		System.out.println("Retrait de " + montant + " effectu� avec succ�s sur le compte " + this.numeroCompte
				+ "\nNouveau solde: " + this.solde);

	}

}
