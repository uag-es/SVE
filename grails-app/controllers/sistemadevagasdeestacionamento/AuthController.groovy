package sistemadevagasdeestacionamento

public class AuthController {
    def index = { redirect(action: "login", params: params) }

    def login = {
        [username: params.username]
    }

    def signIn = {
        if(AuthHelper.instance.login(params.username, params.password)==true){
			redirect(controller: "home", action: "index")
        }else{
			redirect(action: 'index')
		}
    }
}