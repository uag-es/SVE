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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((preferredSector == null) ? 0 : preferredSector.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

public boolean equals(Object o){
		if(o instanceof User){
			User c = (User) o;
			if(c.usernaame.equals(username)){
				return true
			}
		}
		return false
	}
	}
		
	
