package fr.ftprod.pizzeria

import fr.ftprod.pizzeria.content.Content

class MetaProduit extends Content {

	Integer price
	String tva
	Boolean isSupplement = false
	Boolean isDiver = false
	
    static constraints = {
		price min: 0
		tva blank: false, inList: ['5.5', '19.6']
    }
	
	@Override
	public String toString() { name }
	
}
