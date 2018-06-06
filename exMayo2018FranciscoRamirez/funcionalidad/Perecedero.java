package exMayo2018FranciscoRamirez.funcionalidad;

import java.util.regex.Pattern;

/**
 * Clase Perecedero que hereda de Producto (nombre)
 * 
 * @author Francisco Ramírez Ruiz
 *
 */
public class Perecedero extends Producto {

	/**
	 * Fecha del producto
	 */
	private String fecha;

	/**
	 * Regex fecha
	 */
	private static final Pattern patternFecha = 
			Pattern.compile
					//Día
					("^(([0-1-2]\\d{1}|3[0-1])"
					//Mes
					+ "\\/(0[1-9]|1[0-1-2])"
					//Año
					+ "\\/(201[8-9]|20[2-9]\\d))$");

	/**
	 * Constructor de perecedero
	 * 
	 * @param nombre
	 * @param fecha
	 * @throws NombreNoValidoException
	 * @throws FechaNoValidaException
	 */
	public Perecedero(String nombre, String fecha) throws NombreNoValidoException, FechaNoValidaException {
		super(nombre);
		setFecha(fecha);
	}

	/**
	 * getFecha
	 * 
	 * @return fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * setFecha
	 * 
	 * @param fecha
	 * @throws FechaNoValidaException
	 */
	private void setFecha(String fecha) throws FechaNoValidaException {
		if (!esValida(fecha)) 
			throw new FechaNoValidaException("El formato de la fecha no es válido:" + fecha);
		this.fecha = (fecha);
		 
			
		
	}

	/**
	 * Comprueba si la fecha es válida
	 * 
	 * @param nombre
	 * @return fecha
	 */
	private static boolean esValida(String fecha) {
		return patternFecha.matcher(fecha).matches();
	}
}
