package fr.ftprod.pizzeria

class TableController {

    def scaffold = true
	
	def voir() {
		def caisseId = params.caisseId
		def tableId = params.tableId
		def caisse = Caisse.get(caisseId)
		if (tableId) {
			def table = Table.get(tableId)
			def metaProducts = MetaProduit.findAll().findAll { !it.isSupplement && !it.isDiver }
			[	
				caisse: caisse,
				table: table,
				metaProducts: metaProducts,
				factu: table.getFacturation()
			]
		}
	}
	
	def addProduct() {
		def tableId = params.tableId
		def metaProductId = params.metaProductId
		if (tableId && metaProductId) {
			def table = Table.get(tableId)
			def metaProduct = MetaProduit.get(metaProductId)
			def produit = new Produit(metaProduit: metaProduct, table: table)
			if (!produit.save()) {
				println "Erreur lors de la création du produit"
			} else {
				table.produits += produit
				if (!table.save()) {
					println "Erreur lors de la mise à jour de la table"
				} else {
					if (request.xhr) {
						render template: '/table/facturation',
							model: [
								caption: 'Détails de  ' + table,
								titles: [
									'Item',
									'Nombre',
									'Montant unitaire',
									'total'
								],
								factu: table.getFacturation()
							]
					}
				}
			}
			
		}
	}
	
	def addDiverProduct() {
		[table: Table.get(params.tableId)]
	}
	
	def doAddDiverProduct(DiverCommand command) {
		def tableId = params.tableId
		def table = Table.get(tableId)
		if (command.hasErrors()) {
			log.debug "Erreur lors de l'ajout d'un produit divers : ${command.errors}"
			render view: '/table/addDiverProduct', model: [command: command, table: table]
		} else {
			def metaProduit = new MetaProduit(
				name: command.name,
				price: command.price,
				tva: new Double(command.tva),
				isDiver: true)
			if (!metaProduit.save()) {
				log.debug "Erreur lors de la création d'un metaProduit : ${metaProduit.errors}"
			} else {
				def produit = new Produit(metaProduit: metaProduit, table: table)
				if (!produit.save()) {
					log.debug "Erreur lors de la création d'un produit : ${produit.errors}"
				} else {
					redirect action: 'voir', params: [tableId: tableId, caisseId: table.caisse.id]
				}
			}
		}
	}
	
	def confirm() {
		def tableId = params.tableId
		def caisseId = params.caisseId
		def caisse = Caisse.get(caisseId)
		def table = Table.get(tableId)
		[caisse: caisse, table: table]
	}
}

class DiverCommand {
	String name
	Integer price
	String tva
	Integer tableId
	
	static constraints = {
		name blank: false
		price min: 0
		tva blank: false, inList: ['5.5', '19.6']
    }
}