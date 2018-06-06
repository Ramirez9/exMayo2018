package exMayo2018FranciscoRamirez.funcionalidad;

/**
 * Excepcion fichero no es válido
 * 
 * @author Francisco Ramirez
 *
 */
public class FicheroNoExisteException extends Exception {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;

	public FicheroNoExisteException(String string) {
		super(string);
	}
}
