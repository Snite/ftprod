package fr.ftprod.pizzeria.content



import fr.ftprod.pizzeria.MetaProduit
import fr.ftprod.pizzeria.Produit
import fr.ftprod.pizzeria.Table
import grails.test.mixin.*

import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Status)
@Mock([Status, Produit, MetaProduit, Table])
class StatusTests {

	Status status = new Status()
	
//    void testCodeErrors() {
//       //status.code = 'TOTO'
//	   println 'status.code : ' + status.code
//	   assert status.validate() == false
//	   def errors = status.getErrors()
//	   
//	   println 'errors : ' + errors
//	   println 'errors.error : ' + errors.allErrors
//	   println 'status.validate() : ' + status.validate()
////	   assert response.redirectedUrl == '/book/show/1'
////	   assert flash.message != null
////	   assert Book.count() == 1
//    }
	
	void testStatus() {
		def meta1 = new MetaProduit(name: 'Calzone', price: 10).save()
		def meta2 = new MetaProduit(name: '4 Fromages', price: 10).save()
		def metaOeuf = new MetaProduit(name: 'Supplément oeuf', price: 1).save()
		def cofee = new MetaProduit(name: 'Café', price: 2).save()
		
		def supOeuf = new Produit(produit: metaOeuf).save()
		def calzone1 = new Produit(produit: meta1).save()
		def calzone2 = new Produit(produit: meta1).save()
		def calzone3 = new Produit(produit: meta1, supplements: [supOeuf]).save()
		
		def table1 = new Table(name: 'Table 1', nbMax: 10, nbCouvert: 1, produits: [calzone1, calzone2, calzone3, cofee])
		table1.save()
		//table1.getFacturation()
//		def produits = table1.produits.collect { produit ->
//			def factProducts = [] as List
//			factProducts += produit
//			
//		}
		
		def factu = [:]
		println table1
		println table1.produits
		println meta1.name
		println supOeuf
		println supOeuf.produit
		table1?.produits?.each { produit ->
			if (factu.containsKey(produit)) {
				println "Hey coco, tu possède déjà le produit $produit !"
				factu[produit].price += produit.produit.price
				factu[produit].nb++
			} else {
				println "Hey coco, c'est une nouvelle entrée pour $produit !"
				factu.push(produit, [price: produit.produit.price, nb: 1])
			}
		}
	}
	
}
