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

	boolean isAvailable() {
		return owner == null
	}
@Override
public boolean equals(Object o){
	if(o instanceof ParkingSpace){
		ParkingSpace c = (ParkingSpace) o;
		if(c.owner.equals(owner)){
			return true
		}
	}
	return false
}
	
@Override
public String toString() {
	return "Usuario:"+this.user+"Descrição:"+this.description+"Setor: "+this.sector+"Preferencial: "+this.preferential
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
			+ ((description == null) ? 0 : description.hashCode());
	result = prime * result + ((owner == null) ? 0 : owner.hashCode());
	result = prime * result + (preferential ? 1231 : 1237);
	result = prime * result + ((sector == null) ? 0 : sector.hashCode());
	return result;
}

}