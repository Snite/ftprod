package fr.ftprod.pizzeria

class CaisseController {

    def index() {
		def caisseId = params.caisseId
		def caisse = Caisse.get(caisseId)
		[caisse: caisse]
	}
	
	def confirm() {
		def caisseId = params.caisseId
		def caisse = Caisse.get(caisseId)
		[caisse: caisse]
	}
	def scaffold = true
	
}
