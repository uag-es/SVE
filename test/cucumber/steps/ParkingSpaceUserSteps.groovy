package steps

import pages.*
import sistemadevagasdeestacionamento.*

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

Given(~/^Estou na pagina de cadastrar usuario$/) { ->
	to SignUpPage 
	at SignUpPage
}

Given(~/^O sistema tem um usuario com o nome "(.*?)", senha "(.*?)", primeiro nome "(.*?)" e sobrenome "(.*?)"$/) { String userName, String password, String firstname, String lastname ->
		AuthHelper.instance.signup(userName, password, firstname, lastname)
		def user = User.findByUsername(userName) 
		assert user.username == userName 
}



When(~/^Eu digito "(.*?)" para o nome, "(.*?)" para a senha, "(.*?)" para o primeiro nome e "(.*?)" para o sobrenome$/) { String username, String password, String firstname, String lastname ->
	page.registerUserPage(username, password, firstname, lastname)
}

When(~/^Eu tento cadastrar um novo usuario com o nome "(.*?)", senha "(.*?)", primeiro nome "(.*?)" e sobrenome "(.*?)"$/) { String username, String password, String firstname, String lastname ->
	to SignUpPage
	at SignUpPage
	page.registerUserPage(username, password, firstname, lastname)
	page.preferredSector("CIn")
	page.clicButtonSignUp()
}

When(~/^Eu altero o nome do usuario "(.*?)" para o novo nome "(.*?)"$/) { String username1, String username2 ->
	def user = User.findByUsername(username1)
	user.username = username2
	user.save(flush: true)
}

And(~/^Seleciono "(.*?)"$/) { String preferredSector ->
	page.preferredSector(preferredSector)
}

And(~/^Clico no botao cadastrar$/) { ->
	page.clicButtonSignUp()
}

Then(~/^Eu vou para pagina "(.*?)"$/) { String paginaDestino ->
	paginaDestino.equalsIgnoreCase("Home")
}

Then(~/^Eu continuo na pagina de cadastro$/) { ->
    to SignUpPage
	at SignUpPage
}

Then(~/^O sistema tem somente um usuario com o nome "(.*?)"$/) { String userName ->
		def user = User.findByUsername(userName) 
		assert user.username.equals(userName) 	
}
