package TP;



public class CompteEpargne extends Compte{
	protected float taux;
	CompteEpargne(Personne proprietaire, float taux){
		this(proprietaire,0,taux);
	}
	
	CompteEpargne(Personne proprietaire, double montant, float taux){
		super(proprietaire, montant);
		this.taux=taux;
	}

	public float getTaux() {
		return taux;
	}
	
	public double CalculInterets() throws EMontantMinException {
		double interets;
		interets=this.solde*this.taux;
		this.verser(interets, Libele.DEBIT);
		return interets;
	}
}
