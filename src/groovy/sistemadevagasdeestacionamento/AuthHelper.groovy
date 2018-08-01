package sistemadevagasdeestacionamento

@Singleton
public final class AuthHelper {
    private String mCurrentUsername

    public String getCurrentUsername() {
        return mCurrentUsername
    }

    public void signup(String username, String password, String sector) {
        def user = new User(username: username, password: password, firstName: "Primeironome", lastName: "Ultimonome", preferredSector: sector)
        user.save(flush:true)
    }
	
	public void signup(String username, String password, String firstName, String lastName) {
		def user = new User(username: username, password: password, firstName: firstName, lastName: lastName, preferredSector: "CIn")
		user.save(flush:true)
	}

    public boolean login(String username, String password) {        
        def user = User.findByUsername(username)
		if(user!=null && user.password==password){
			mCurrentUsername = username
			return true
		}
    }

    public void logout() {
        mCurrentUsername = null
    }
	
}