package pages.UserPage

import geb.Page


class CreateUserPage extends Page {
	static url = 'user/create'

	static at = {
		title ==~ /Create User/
	}
	
	def proceed(String username, String name, String lastName, String preferredSector) {
		$("input[name='username']").value(username)
		$("input[name='firstName']").value(name)
		$("input[name='lastName']").value(lastName)
		$("select[name='preferredSector']").value(preferredSector)
		$("input[name='Criar']").click()
	}
}