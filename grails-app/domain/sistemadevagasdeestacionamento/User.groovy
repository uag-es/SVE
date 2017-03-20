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
	public String toString()
	{
    	return "Primeiro nome: $firstName, Segundo nome: $lastName, Setor preferido: $preferredSector"
	}

	}