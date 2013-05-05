package fr.ftprod.pizzeria.content

class StatusController {
	
	def scaffold = true
	
	def init() {
		def status = Status.findAll()
		if (!status) {
			def libre = new Status(code: Status.LIBRE, description: 'Libre').save()
			def occup = new Status(code: Status.OCCUPEE, description: 'Occupée').save()
		}
		redirect controller: 'pizzeria'
	}
}
