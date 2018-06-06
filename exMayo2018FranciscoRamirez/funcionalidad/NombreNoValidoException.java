package exMayo2018FranciscoRamirez.funcionalidad;

/**
 * 
 * Excepcion de nombre no es válido
 * 
 * @author Francisco Ramirez
 *
 */
public class NombreNoValidoException extends Exception {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;

	public NombreNoValidoException(String string) {
		super(string);
	}
}
