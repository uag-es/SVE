package sistemadevagasdeestacionamento

class User {
	String username
	String firstName
	String lastName
	String preferredSector

	static constraints = {
		username nullable: false, blank: false, unique: true
		firstName nullable: false, blank: false
		lastName nullable: false, blank: false
		preferredSector inList: ["CIn", "CCEN", "Area II"]
	}
	
	@Override
	public String toString(){
		return "Username: " + this.username + ". First Name: " + this.firstName + ". lastName: " + this.lastName + ". PreferredSector: " + this.preferredSector
	}
}