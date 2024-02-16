package fecha;

public class Fecha {
	/** guardará el día de la propia fecha */
	private int dia; 
	/** guardará el mes de la propia fecha */
	private int mes; 
	/** guardará el anio de la propia fecha */
	private int anio; 

	/** Constructor Vacío de la clase Fecha*/
	public Fecha() {

	}

	/** Constructor de la clase Fecha
	 * @param dia representa el dia de la fecha
	 * @param mes represetna el mes de la fecha
	 * @param anio represetna el año de la fecha
	 * */
	public Fecha(int dia, int mes, int anio) {
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}

	
	/** 
	 * Comprueba que una fecha es correcta
	 * @return True si la fecha es correcta false si no lo es.
	 * */
	public boolean fechaCorrecta() {
		boolean diaCorrecto, mesCorrecto, anioCorrecto;
		anioCorrecto = anio > 0;
		mesCorrecto = mes >= 1 && mes <= 12;
		boolean diaMayor1 = dia >= 1;
		switch (mes) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = diaMayor1 && dia <= 29;
			} else {
				diaCorrecto = diaMayor1 && dia <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = diaMayor1 && dia <= 30;
			break;
		default:
			diaCorrecto = diaMayor1 && dia <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	/** Método esBisiesto
	 * @return devuelve true si el año es bisiesto falso si no lo es */
	private boolean esBisiesto() {
		return anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0;
	}

	/**
	 * Método diaSiguiente
	 * */
	public void nextDay() {
		dia++;
		if (!fechaCorrecta()) {
			dia = 1;
			mes++;
			if (!fechaCorrecta()) {
				mes = 1;
				anio++;
			}
		}
	}

	/**
	 * Convierte la fecha a un String
	 * @return String que contiene la fecha
	 * */
	public String toString() {
		String fecha = "";
		if (dia < 10 && mes < 10) {
			fecha = "0" + dia + "-0" + mes + "-" + anio;
		} else if (dia < 10 && mes >= 10) {
			fecha =  "0" + dia + "-" + mes + "-" + anio;
		} else if (dia >= 10 && mes < 10) {
			fecha = dia + "-0" + mes + "-" + anio;
		} else {
			fecha = dia + "-" + mes + "-" + anio;
		}
		return fecha;
	}

}
