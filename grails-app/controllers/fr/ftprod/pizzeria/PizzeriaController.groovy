package fr.ftprod.pizzeria

import fr.ftprod.pizzeria.content.Status

class PizzeriaController {

    def index() {
		[caisses: Caisse.findAll(), status: Status.findAll()]
	}
}
