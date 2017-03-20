package steps

import pages.*
import sistemadevagasdeestacionamento.*

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

When(~/^the user "(.*?)" is typed and clicks in the sign-in button$/) { String username ->
	AuthHelper.instance.login(currentUsername)
	
	assert AuthHelper.instance.currentUsername == currentUsername
}

Then(~/^the user can use the system$/) { ->
	waitFor { to SignUpPage }
}