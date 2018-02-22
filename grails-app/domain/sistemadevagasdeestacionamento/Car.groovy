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
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Car){
			Car c = (Car) o;
			if(c.placa.equals(placa)){
				return true
			}
		}
		return false
	}
	
	@Override
	public String toString(){
		return "Placa: " + this.placa + ". Marca: " + this.marca + ". Modelo: " + "Login do proprietaro: " + this.proprietario.username
	}
	
}
