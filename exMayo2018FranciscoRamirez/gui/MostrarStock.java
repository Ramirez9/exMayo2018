package exMayo2018FranciscoRamirez.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;

import exMayo2018FranciscoRamirez.funcionalidad.Almacen;
import exMayo2018FranciscoRamirez.funcionalidad.Perecedero;
import exMayo2018FranciscoRamirez.funcionalidad.Producto;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Muestra el almacen
 * 
 * @author Francisco Ramirez Ruiz
 *
 */
public class MostrarStock extends VentanaPadre {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;
	private ListIterator<Producto> iterator;
	private Producto producto;
	private int camino = 0;

	public MostrarStock() {
		super();
		setTitle("Stock");
		iterator = Almacen.getAlmacen().listIterator();

		textoNombre.setEditable(false);
		textoFecha.setEditable(false);

		//Bounds (X,Y, Tamaño, anchura)
		btnAccion1.setText("<");
		btnAccion1.setBounds(240, 64, 50, 23);
		btnAccion2.setText(">");
		btnAccion2.setBounds(298, 64, 50, 23);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				comprobarBotones();
				siguiente();
				mostrarProducto(producto);
			}
		});

		accionBotones();
		
		
	}
	/**
	 * Muestra el producto anterior
	 */
	private void anterior() {
		if (iterator.hasPrevious()) 
			producto = iterator.previous();
		if(camino == 0)
			if(iterator.hasPrevious())
				producto = iterator.previous();
			camino = 1;
				
	}
	
	/**
	 * Muestra el producto siguiente
	 */
	private void siguiente() {
		if (iterator.hasNext()) 
			producto = iterator.next();
		
		if(camino == 1)
			if(iterator.hasNext())
				producto = iterator.next();
			camino = 0;
	}

	/**
	 * Comprueba los botones
	 */
	private void comprobarBotones() {
		btnAccion2.setEnabled(true);
		btnAccion1.setEnabled(true);
		if (!iterator.hasNext())
			btnAccion2.setEnabled(false);
		if (!iterator.hasPrevious())
			btnAccion1.setEnabled(false);

		if (Almacen.size() == 1) {
			btnAccion2.setEnabled(false);
			btnAccion1.setEnabled(false);
		}

	}

	/**
	 * Accion de los botones atrás y siguiente
	 */
	private void accionBotones() {
		//Atrás
		btnAccion1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anterior();
				mostrarProducto(producto);
				comprobarBotones();
			}
		});
		//Siguiente
		btnAccion2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				siguiente();
				mostrarProducto(producto);
				comprobarBotones();			
			}
		});
	}


	/**
	 * Muestra el producto
	 * 
	 * @param producto
	 */
	private void mostrarProducto(Producto producto) {
		textoNombre.setText(producto.getNombre());
		// instanceof para comprobar si es perecedero o no
		if (producto instanceof Perecedero)
			textoFecha.setText(((Perecedero) producto).getFecha());
		else
			textoFecha.setText("");
	}

}