package fr.ftprod.pizzeria

class Produit {

	MetaProduit metaProduit
	
	static belongsTo = [table: Table]
	static hasMany = [supplements: Produit]
	
    static constraints = {
	}
	
	@Override
	public String toString() { metaProduit }
}
