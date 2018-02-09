package steps

import sistemadevagasdeestacionamento.User
import sistemadevagasdeestacionamento.UserController

class UserTestDataAndOperations {
	
	static public void createUser(String login, String name, String lastname, String preferencia){
	    def userController = new UserController()
		userController.params << [username: login, firstName: name, lastName: lastname, preferredSector: preferencia]
		userController.createAndSave()
		userController.response.reset()

	}
	
	static public int quantidadeUsuarios(String login){
		return User.findAllByUsername(login).size()
	}
}