package fr.ftprod.pizzeria.front

import fr.ftprod.pizzeria.Caisse
import fr.ftprod.pizzeria.Table

class FrontCaisseController {

    def index() {
		def caisseId = params.caisseId
		def caisse = Caisse.get(caisseId)
		[caisse: caisse]
	}
	
}
