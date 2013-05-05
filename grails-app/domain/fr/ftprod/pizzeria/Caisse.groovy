package fr.ftprod.pizzeria

import fr.ftprod.pizzeria.content.Content

class Caisse extends Content {

	static hasMany = [tables: Table]
	
    static constraints = {
    }
	
	@Override
	public String toString() { name }
}
