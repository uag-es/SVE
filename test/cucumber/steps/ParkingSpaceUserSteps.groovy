package steps

import pages.*
import sistemadevagasdeestacionamento.*

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

Given(~/^Im at login page$/) { ->
	to LoginPage
	at LoginPage
}

When(~/^I click in sign in with username "(.*?)"$/) { String username ->
	page.login(username,"")
}

Then(~/^the home page is loaded$/) { ->
    page == HomePage
}

When(~/^I remove user "(.*?)"$/) { String username ->
	currentUsername = username
	def user = User.findByUsername(currentUsername)
	user.delete(flush: true)
}

Then(~/^the systems does not have user "(.*?)" storaged$/) { String arg1 ->
	    user = User.findByUsername(currentUsername)
		user == null
}

When(~/^I update user "(.*?)" with "(.*?)" sector$/) { String username, String sector ->
	def user = User.findByUsername(username)
	user.preferredSector = sector
	user.save(flush: true)
}

Given(~/^Im at sign up page$/) { ->
	to SignUpPage
	at SignUpPage
}

When(~/^I fill username with "(.*?)" and "(.*?)" as prefered sector$/) { String username, String sector ->
	
	page.proceed(username, sector)
}

Then(~/^Im still in sign up page$/) { ->
	page == SignUpPage
}

