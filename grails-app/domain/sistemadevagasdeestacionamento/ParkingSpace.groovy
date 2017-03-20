package sistemadevagasdeestacionamento



class ParkingSpace {
    User owner
    String description
    String sector
    boolean preferential
	// inser��o da data
	String date

    static constraints = {
        owner nullable: true
        description nullable: false, blank: false, unique: true
        sector inList: ["CIn", "CCEN", "Area II"]
		//inser��o da data para registro no sistema
		date nullable: true, blank: false
    }

    boolean isAvailable()
    {
        return owner == null
    }
}