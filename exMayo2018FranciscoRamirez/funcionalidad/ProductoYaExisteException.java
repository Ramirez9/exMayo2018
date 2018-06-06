package exMayo2018FranciscoRamirez.funcionalidad;
/**
 * Excepcion producto no es válido
 * 
 * @author Francisco Ramirez
 *
 */
public class ProductoYaExisteException extends Exception{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;

	public ProductoYaExisteException(String string) {
		super(string);
	}
}
