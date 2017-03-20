package sistemadevagasdeestacionamento

class User {
    String username
    String firstName
    String lastName
    String preferredSector

    static constraints = {
        username nullable: false, blank: false, unique: true
		firstName nullable: false, blank: false, matches: "[a-zA-Z]+"
		lastName nullable: false, blank: false, matches: "[a-zA-Z]+"
		preferredSector inList: ["CIn", "CCEN", "Area II"]
	} 
	
	@Override
	public String toString(){
		return "Primeiro nome: $firstName, Segundo nome: $lastName, Setor preferido: $preferredSector"
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
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}
        
	
