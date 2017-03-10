package sistemadevagasdeestacionamento

public class AuthController {
    def index = { redirect(action: "login", params: params) }

    def login = {
        [username: params.username]
    }

    def signIn = {
        AuthHelper.instance.login(params.username as String)
		if(params.username == ""){
			redirect(controller: "auth", action: "login")
		}else if(User.findByUsername(params.username) == null){
			redirect(controller: "auth", action: "login")
		}else{
			redirect(controller: "home", action: "index")
		}	
		
    }
}