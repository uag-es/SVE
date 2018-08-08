package pages

import geb.Page

class SignUpPage extends Page {
    static url = 'signUp/index'

    static at = {
        title ==~ /Sign up/
    }

    def registerUserPage(String username, String password, String preferredSector) {
        $("input[name='username']").value(username)
		$("input[name='password']").value(password)
        $("input[name='firstName']").value("Primeironome")
        $("input[name='lastName']").value("Ultimonome")
        $("select[name='preferredSector']").value(preferredSector)
        $("input[name='signUp']").click()
    }
	
	def registerUserPage(String username, String password, String firstname, String lastname) {
		$("input[name='username']").value(username)
		$("input[name='password']").value(password)
		$("input[name='firstname']").value(firstname)
		$("input[name='lastname']").value(lastname)
	}
	
	def preferredSector(String preferredSector){
		$("select[name='preferredSector']").value(preferredSector)
	}
	
	def clicButtonSignUp(){
		$("input[name='signUp']").click()
	}
	
}