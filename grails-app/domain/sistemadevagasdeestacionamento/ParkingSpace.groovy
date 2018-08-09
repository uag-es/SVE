package sistemadevagasdeestacionamento

class ParkingSpace {
	User owner
	String description
	String sector
	boolean preferential

	static constraints = {
		owner nullable: true
		description nullable: false, blank: false, unique: true, size: 1..40
		sector inList: ["CIn", "CCEN", "Area II"]
	}

	private boolean isAvailable() {
		return owner == null
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
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
		ParkingSpace other = (ParkingSpace) obj;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ParkingSpace [description=" + description + ", sector="
				+ sector + ", preferential=" + preferential + "]";
	}
	
}