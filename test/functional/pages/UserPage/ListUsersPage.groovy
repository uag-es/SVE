package pages.UserPage

import geb.Page


class ListUsersPage extends Page {
	static url = 'user/index'

	
	// aqui no meu esta acusando de que eu escrevi User Listagem, mas eu ja mudei pra User List e ainda nao roda
	static at = {
		title ==~ /User List/
	}
	
	boolean confirmUser(String login) {
		boolean r = false
		boolean findLogin = $("tr").has("td",text: login)
		if(findLogin){
			r = true
		}
		return r
	}	
	
}