package sistemadevagasdeestacionamento

class User {
	String username
	String password
	String firstName
	String lastName
	String preferredSector

	static constraints = {
		username nullable: false, blank: false, unique: true, size: 1..15
		password nullable: false, blank: false
		firstName nullable: false, blank: false, matches: "[A-Za-z]+"
		lastName nullable: false, blank: false, matches: "[A-Za-z]+"
		preferredSector inList: ["CIn", "CCEN", "Area II"]
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", preferredSector=" + preferredSector + "]";
	}
	
	
}
