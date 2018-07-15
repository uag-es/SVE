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

Then(~/^The home page is loaded$/) { ->
    page == HomePage
}
