package sistemadevagasdeestacionamento

class SignUpController {
    def index() { }

    def register() {
        String username = params.username

        def user = User.findByUsername(username)

        if (user) {
            flash.message = "User already exists with the username '${username}'"

            redirect(action: 'index')
        } else {
           criar()

            AuthHelper.instance.login(username)

            redirect(controller: 'home', action: 'index')
        }
    }
	def criar(){
		String username = params.username		
		def user = User.findByUsername(username)
		String firstName = params.firstName
		String lastName = params.lastName
		String preferredSector = params.preferredSector
		user = new User(username: username, firstName: firstName, lastName: lastName, preferredSector: preferredSector)
		user.save(flush: true)
	}
}