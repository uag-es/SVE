package steps

import pages.*
import sistemadevagasdeestacionamento.*

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

Given(~/^Estou na pagina de cadastrar usuario$/) { ->
	to SignUpPage 
	at SignUpPage
}

Given(~/^O sistema tem um usuario com o nome "(.*?)", primeiro nome "(.*?)" e sobrenome "(.*?)"$/) { String userName, String firstname, String lastname ->
		AuthHelper.instance.signup(userName, firstname, lastname)
		def user = User.findByUsername(userName) 
		assert user.username == userName 
		assert user.firstName == firstname
		assert user.lastName == lastname
}

Given(~/^Im at login page$/) { ->
	to LoginPage
	at LoginPage
}

Given(~/^Im at sign up page$/) { ->
	to SignUpPage
	at SignUpPage
}

When(~/^Eu digito "(.*?)" para o nome, "(.*?)" para o primeiro nome e "(.*?)" para o sobrenome$/) { String username, String firstname, String lastname ->
	page.register(username, firstname, lastname)
}

When(~/^Eu tento cadastrar um novo usuario com o nome "(.*?)", primeiro nome "(.*?)" e sobrenome "(.*?)"$/) { String username, String firstname, String lastname ->
	to SignUpPage
	at SignUpPage
	page.register(username, firstname, lastname)
	page.preferredSector("CIn")
	page.confirmoSignUp()
}

When(~/^Eu altero o nome do usuario "(.*?)" para o novo nome "(.*?)"$/) { String username1, String username2 ->
	def user = User.findByUsername(username1)
	user.username = username2
	user.save(flush: true)
}

When(~/^I click in sign in with USERNAME "(.*?)"$/) { String username ->
	page.login(username,"")
}

When(~/^I remove user "(.*?)"$/) { String username ->
	currentUsername = username
	def user = User.findByUsername(currentUsername)
	user.delete(flush: true)
}

When(~/^I update user "(.*?)" with "(.*?)" sector$/) { String username, String sector ->
	def user = User.findByUsername(username)
	user.preferredSector = sector
	user.save(flush: true)
}

When(~/^I fill username with "(.*?)" and "(.*?)" as prefered sector$/) { String username, String sector ->
	
	page.proceed(username, sector)
}

And(~/^Seleciono "(.*?)"$/) { String preferredSector ->
	page.preferredSector(preferredSector)
}

And(~/^Clico no botao cadastrar$/) { ->
	page.confirmoSignUp()
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
		assert user.username == userName 	
}

Then(~/^the home page is loaded$/) { ->
	page == HomePage
}

Then(~/^the systems does not have user "(.*?)" storaged$/) { String arg1 ->
		user = User.findByUsername(currentUsername)
		user == null
}

Then(~/^Im still in sign up page$/) { ->
	page == SignUpPage
}







