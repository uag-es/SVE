package steps

import cucumber.api.PendingException
import steps.UserTestDataAndOperations
import pages.UserPage.*
import sistemadevagasdeestacionamento.User
import sistemadevagasdeestacionamento.UserController

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

def user

Given(~/^Eu estou na pagina "(.*?)"$/) { String page ->
	if(page.equals("Criar usuario")){
		to CreateUserPage
	}/*else if(page.equals("Lisagem de usuarios")){
		to ListUsersPage
	}*/
}

When(~/^Eu cadastro o usuario com nome de usuario "(.*?)" com primeiro nome "(.*?)" com ultimo nome "(.*?)" com setor de preferencia "(.*?)"$/) {String login, String name, String lastname, String preferencia ->

	UserTestDataAndOperations.createUser(login, name, lastname, preferencia)	
	/* 	page.proceed(login, name, lastname, preferencia)
	 * Aqui eu tive uma duvida, em controller e em GUI eu uso essa funcao, porque tem nome igual, porem, para GUI ele deveria escrever
	 * na tela, que eh oque essa funcao page.proceed faz, so que ai eu ia ter que ter duas implementacoes de algo com o mesmo nome,
	 *  entao, qual seria o certo? Desse jeito funciona pra os dois, so nao escreve na tela durante o teste de GUI
	 */

}
/*
 * estou tendo um problema com a pagina de ListUsers, ai n terminei de implementar
Then(~/^Eu vejo o usuario com nome de usuario "(.*?)" com primeiro nome "(.*?)" com ultimo nome "(.*?)" com setor de preferencia "(.*?)" na pagina "(.*?)"$/) { String login, String name, String lastname, String preferencia, String page2 ->
	to ListUsers
	at ListUsers
	assert page.confirmUser(login)
	
}
*/


// steps controller
// Cadastrar usuario

Given(~/^O usuario com nome de usuario "(.*?)" com primeiro nome "(.*?)" com ultimo nome "(.*?)" com setor de preferencia "(.*?)" nao esta cadastrado no sistema$/) { String login, String name, String lastname, String prefencia ->
	assert User.findByUsername(login) == null
}

Then(~/^O sistema cadastra o usuario com nome de usuario "(.*?)" com primeiro nome "(.*?)" com ultimo nome "(.*?)" com setor de preferencia "(.*?)"$/) { String login, String name, String lastname, String preferencia->
	assert User.findByUsername(login) != null
}

//Cadastrar usuario duas vezes
Given(~/^O usuario com nome de usuario "(.*?)" com primeiro nome "(.*?)" com ultimo nome "(.*?)" com setor de preferencia "(.*?)" ja esta cadastrado no sistema$/) { String login, String name, String lastname, String preferencia ->
	UserTestDataAndOperations.createUser(login, name, lastname, preferencia)
	assert User.findByUsername(login) != null
}

Then(~/^O sistema nao cadastra o usuario com nome de usuario "(.*?)" com primeiro nome "(.*?)" com ultimo nome "(.*?)" com setor de preferencia "(.*?)"$/) { String login, String name, String lastname, String preferencia ->
	assert UserTestDataAndOperations.quantidadeUsuarios(login)== 1
}


