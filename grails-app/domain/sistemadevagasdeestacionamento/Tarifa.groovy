package sistemadevagasdeestacionamento

class Tarifa {
	User use
	String tarifa

	static constraints = {
		tarifa inList:["10min/5reais", "20min/15reais", "40min/30reais", "1hr/40reais"]
	}
	@Override
	public String toString() {
		return "Tarifa [use=" + use + "]";
	}
	
}
