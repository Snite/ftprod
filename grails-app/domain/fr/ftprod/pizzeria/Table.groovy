package fr.ftprod.pizzeria

import fr.ftprod.pizzeria.content.Content
import fr.ftprod.pizzeria.content.Status

class Table extends Content {

	Status status
	Integer nbMax
	Integer nbCouverts
	
	static hasMany = [produits: Produit]
	static belongsTo = [caisse: Caisse]
	
    static constraints = {
		nbMax range: 1..10
		/* Si le nombre de couvert est supèrieure à la capacité
		 * maximale de la table */
		nbCouverts min: 0, validator: { nbCouvert, table -> 
			nbCouvert > table.nbMax ? false : true 
		}
		/* Si le nombre de couvert est à 0 et que le statut est 
		 * à "libre", alors on retourne une erreur */
		status validator: { status, table ->
			if (table.nbCouverts > 0 && status.isFree()) {
				false
			}
		}
    }
	
	def getFacturation() {
		def factu = [:]
		Double tva5 = 0
		Double tva19 = 0
		Double total = 0
		produits?.each { produit ->
			def metaProduit = produit.metaProduit
			total += metaProduit.price
			def tva = metaProduit.price * (new Double(metaProduit.tva) / 100)
			if (factu.containsKey(metaProduit)) {
				factu[metaProduit].price += metaProduit.price
				factu[metaProduit].nb++
			} else {
				factu.put(metaProduit, [price: metaProduit.price, nb: 1])
			}
			if (metaProduit.tva == '5.5') {
				tva5 += tva
			} else { tva19 += tva }
			
		}
		if (produits){ 
			factu.put('prices', [tva5: tva5, tva19: tva19, total:total])
			factu
		}
	}
	
	@Override
	public String toString() { name }
}
