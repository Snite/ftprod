class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		
		"/administration/$caisseId" 							controller: 'caisse', action: 'index'
		"/administration/supprimer-caisse/$caisseId" 			controller: 'caisse', action: 'confirm'
		"/administration/supprimer-table/$caisseId/$tableId" 	controller: 'table', action: 'confirm'
		"/serveur/$caisseId" 									controller: 'frontCaisse', action: 'index'
		"/serveur/voir-table/$caisseId/$tableId" 				controller: 'table', action: 'voir'
		"/action/ajouter-produit/$metaProductId/$tableId"		controller: 'table', action: 'addProduct'
		"/action/ajouter-divers/$tableId"						controller: 'table', action: 'addDiverProduct'
		'/'												controller: 'pizzeria'
		"500"(view:'/error')
	}
}
