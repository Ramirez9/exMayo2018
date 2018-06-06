package exMayo2018FranciscoRamirez.funcionalidad;

/**
 * Excepcion fecha no es v�lida.
 * 
 * @author Francisco Ramirez
 *
 */
public class FechaNoValidaException extends Exception{
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 1L;

	public FechaNoValidaException(String string) {
		super(string);
	}
}
