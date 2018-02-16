package sistemadevagasdeestacionamento

class Car {
	String placa
	String marca
	String modelo
	User propietario
	
    static constraints = {
		propietario nullable: false, brank: false
		placa nullable: false, blank: false, unique: true
    	marca nullable: false, blank: false
		modelo nullable: false, blank: false
	}
}
