package exMayo2018FranciscoRamirez.funcionalidad;

import java.util.ArrayList;

/**
 * Stock del almacén de productos y productos perecederos
 * 
 * @author Francisco Ramirez
 *
 */
public class Almacen {

	private static final String EL_PRODUCTO_YA_EXISTE = "El producto ya existe";
	/**
	 * ArrayList Producto
	 */
	private static ArrayList<Producto> almacen = new ArrayList<Producto>();

	/**
	 * Alta de un producto que NO es perecedero
	 * 
	 * @param nombre
	 * @throws NombreNoValidoException
	 * @throws ProductoYaExisteException
	 */
	public static void altaProducto(String nombre) 
			throws NombreNoValidoException, ProductoYaExisteException {
		Producto producto = new Producto(nombre);
		if (!almacen.contains(producto))
			almacen.add(producto);
		else
			throw new ProductoYaExisteException(EL_PRODUCTO_YA_EXISTE);

	}

	/**
	 * Alta de un producto que SI es perecedero
	 * 
	 * @throws FechaNoValidaException
	 * @throws NombreNoValidoException
	 * @throws ProductoYaExisteException
	 */
	public static void altaProductoPerecedero(String nombre, String fecha)
			throws NombreNoValidoException, FechaNoValidaException, ProductoYaExisteException {
		Perecedero perecedero = new Perecedero(nombre, fecha);
		if (!almacen.contains(perecedero))
			almacen.add(perecedero);
		else
			throw new ProductoYaExisteException(EL_PRODUCTO_YA_EXISTE);

	}
	
	/**
	 * ArrayList producto
	 * 
	 * @return almacen
	 */
	public static ArrayList<Producto> getAlmacen(){
		return almacen;
	}
	
	/**
	 * No hay productos
	 */
	public static boolean isEmpty(){
		return almacen.isEmpty();
	}

	/**
	 * Tamaño del almacen
	 * @return size
	 */
	public static int size() {
		
		return almacen.size();
	}
		
}
