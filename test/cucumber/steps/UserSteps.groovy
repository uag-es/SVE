package sistemadevagasdeestacionamento

import sistemadevagasdeestacionamento.User

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)
def usuario
def user
def usercontroller
def outroUsuario
def outroUser

Given(~/^existe no sistema um usuario com username "(.*?)" e preferredSector "(.*?)"$/) { String arg1, String arg2 ->
   outroUsuario = new User()
   outroUsuario.setUsername(arg1)
   outroUsuario.setFirstName("nome")
   outroUsuario.setLastName("sobrenome")
   outroUsuario.setPreferredSector(arg2)
   outroUsuario.save(flush: true)

	   
   outroUser = User.findByUsername(arg1)

}

When(~/^o usuario seleciona remover este usuario$/) { ->
	if(outroUser != null){
	   usercontroller = new UserController()
	   usercontroller.delete(outroUser)
   }
}

Then(~/^nao existem mais usuario$/) { ->
}

Given(~/^existe no sistema um usuario com nome de usuario "(.*?)"$/) { String arg1 ->
	usuario = new User()
	usuario.setUsername(arg1)
	usuario.setFirstName("nome")
	usuario.setLastName("sobrenome")
	usuario.setPreferredSector("CCEN")
	usuario.save(flush: true)

		
	user = User.findByUsername(arg1)
}

When(~/^O usuario altera o username para "(.*?)"$/) { String arg1 ->
   if(user != null){	   
	user.setUsername(arg1)
	}
}

Then(~/^o sistema atualiza o username$/) { ->
}



