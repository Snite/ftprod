package fr.ftprod.pizzeria.content

class Status {

	String code
	String description
	
	def static LIBRE = "LIBRE"
	def static OCCUPEE = "OCCUPEE"

	static constraints = {
		code nullable: false, blank: false, inList: [LIBRE, OCCUPEE]
		description size: 1..80
	}
	
	def isFree() { code == LIBRE }
		
	def isUsed() { code == OCCUPEE }
	
	@Override
	public String toString() { description }
}