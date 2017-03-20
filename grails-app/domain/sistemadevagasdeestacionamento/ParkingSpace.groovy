package sistemadevagasdeestacionamento

class ParkingSpace {

	User owner
    String description
    String sector
    boolean preferential

    static constraints = {
        owner nullable: true
        description nullable: false, blank: false, unique: true
        sector inList: ["CIn", "CCEN", "Area II"]
    }

    boolean isAvailable()
    {
        return owner == null
    }
	
	@Override
	public String toString() {
		return "ParkingSpace [description=" + description + ", sector="
				+ sector + ", preferential=" + preferential + "]";
	}
}