package pages

import geb.Page
import geb.navigator.NonEmptyNavigator

class UserListPage extends Page {
	static url = 'user/index'

	static at = {
	}
	
	def confirmUser(String username){
		$("input[name='A']").click()
	}
	
}