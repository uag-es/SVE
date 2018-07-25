package sistemadevagasdeestacionamento

class Automovel {
	User proprietario
	String placa 
	String marca
	String modelo

    static constraints = {
		proprietario nullable: false, brank: false, unique: true
		placa nullable: false, blank: false, unique: true
		marca nullable: false, blank: false
		modelo nullable: false, blank: false
    }

	@Override
	public String toString() {
		return "Automovel [proprietario=" + proprietario + "]";
	}
}
