package fr.ftprod.pizzeria.content

abstract class Content {

	String name
	
    static constraints = {
		name blank: false
    }
}
