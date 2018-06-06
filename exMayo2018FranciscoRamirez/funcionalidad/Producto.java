package exMayo2018FranciscoRamirez.funcionalidad;

import java.util.regex.Pattern;

/**
 * Clase producto con campo nombre
 * 
 * @author Francisco Ramírez Ruiz
 *
 */
public class Producto {

	/**
	 * Nombre del producto
	 */
	private String nombre;

	/**
	 * Regex nombre
	 */
	static final private Pattern patternNombre = Pattern.compile("^([a-zA-Z]{3,}?)(\\s[a-zA-Z]{3,}?)*$");

	/**
	 * Constructor de Producto
	 * 
	 * @param nombre
	 * @throws NombreNoValidoException
	 */
	public Producto(String nombre) throws NombreNoValidoException {
		setNombre(nombre);
	}

	/**
	 * getNombre
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param nombre
	 * @throws NombreNoValidoException
	 */
	private void setNombre(String nombre) throws NombreNoValidoException {
		if (!esValida(nombre))
			throw new NombreNoValidoException("El nombre del Producto no es válido: " + nombre);
		this.nombre = (nombre);
		
			

	}

	/**
	 * Controla si el nombre es válido o no
	 * 
	 * @param nombre
	 * @return
	 */
	private static boolean esValida(String nombre) {
		return patternNombre.matcher(nombre).matches();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
			// equalsIgnoreCase para que ignore las mayúsculas y las minúsculas
		} else if (!nombre.equalsIgnoreCase(other.nombre))
			return false;
		return true;
	}

}
