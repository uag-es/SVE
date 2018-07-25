package sistemadevagasdeestacionamento

import grails.transaction.Transactional

@Transactional(readOnly = true)
class AutomovelController {
	
	def index(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		respond Automovel.list(params), model:[automovelInstanceCount: Automovel.count()]
	}
	
	def show(Automovel automovelInstance) {
		respond automovelInstance
	}
	
	def create() {
		respond new Automovel(params)
	}
	
	@Transactional
	def save(Automovel  automovelInstance) {
		if (automovelInstance == null) {
			notFound()
			return
		}
	
		if (automovelInstance.hasErrors()) {
			respond automovelInstance.errors, view:'create'
			return
		}
	
		automovelInstance.save flush:true
			request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.created.message', args: [message(code: 'automovel.label', default: 'Automovel'), automovelInstance.id])
				redirect automovelInstance
			}
			'*' { respond automovelInstance, [status: CREATED] }
		}
	}
	
	def edit(Automovel automovelInstance) {
		respond automovelInstance
	}
	
	@Transactional
	def update(Automovel automovelInstance) {
		if (automovelInstance == null) {
			notFound()
			return
		}
	
		if (automvelInstance.hasErrors()) {
			respond automovelInstance.errors, view:'edit'
			return
		}
	
		automovelInstance.save flush:true
	
		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.updated.message', args: [message(code: 'Automovel.label', default: 'Automovel'), automovelInstance .id])
				redirect automovelInstance
			}
			'*'{ respond automovelInstance, [status: OK] }
		}
	}
	
	@Transactional
	def delete(Automovel automvelInstance) {
	
		if (automvelInstance == null) {
			notFound()
			return
		}
	
		automvelInstance.delete flush:true
	
		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.deleted.message', args: [message(code: 'Automvel.label', default: 'Automvel'), automvelInstance.id])
				redirect action:"index", method:"GET"
			}
			'*'{ render status: NO_CONTENT }
		}
	}
	
	protected void notFound() {
		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.not.found.message', args: [message(code: 'car.label', default: 'Car'), params.id])
				redirect action: "index", method: "GET"
			}
			'*'{ render status: NOT_FOUND }
		}
	}
}