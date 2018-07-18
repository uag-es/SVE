package steps

import pages.*
import sistemadevagasdeestacionamento.*

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

Given(~/^I signed up as "([^"]*)" with preference for parking spaces in the "([^"]*)" sector$/) { String username, String sector ->
	currentUsername = username

	waitFor { to SignUpPage }
	page.proceed(username, sector)
	waitFor { at HomePage }
}

And(~/^the user is logged in the system$/) { ->
	AuthHelper.instance.login(currentUsername)

	assert AuthHelper.instance.currentUsername == currentUsername
}
When(~/^the user select the option My profile$/) { ->
	at HomePage
	page.confirmMyProfile()
}
Then (~/^the user see the list of all user stored in the system$/) { ->
	to UserListPage
	at UserListPage
}

When(~/^I update the user "(.*?)", firstName "(.*?)" to new firstName "(.*?)"$/) {String username, String firstName, String NewFirstName ->
	def user = User.findByUsername(username)
	user.firstName = NewFirstName
	user.save(flush: true)
}

Then(~/^the system has stored the user "(.*?)" wiht new firstName "(.*?)", lastName "(.*?)", pefeence sector "(.*?)"$/) { String username, String NewFirstName, String lastName, String sector ->
	currentUsername = username
	
	waitFor { to SignUpPage }
	page.register(username, NewFirstName, lastName)
	page.preferredSector(sector)
	waitFor { at SignUpPage }
}

And (~/^the user select userName "(.*?)"$/) { String username->
	to UserListPage
	at UserListPage
	page.confirmUser(username)
}
And (~/^the user see the user`s information$/) { ->
	to UserShowPage
	at UserShowPage
}