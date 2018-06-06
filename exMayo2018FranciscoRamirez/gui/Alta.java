package exMayo2018FranciscoRamirez.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import exMayo2018FranciscoRamirez.funcionalidad.Almacen;
import exMayo2018FranciscoRamirez.funcionalidad.FechaNoValidaException;
import exMayo2018FranciscoRamirez.funcionalidad.NombreNoValidoException;
import exMayo2018FranciscoRamirez.funcionalidad.ProductoYaExisteException;

/**
 * Alta de un producto en nuestro almacen
 * 
 * @author Francisco Ramirez
 *
 */
public class Alta extends VentanaPadre {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;
	
	public Alta() {
		super();
		setTitle("Producto");

		btnAccion1.setText("Añadir");
		btnAccion2.setText("Mostrar Stock");

		//Boton añadir
		btnAccion1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alta();
			}
		});
		
		//Boton mostrar
		btnAccion2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// dispose();
				if (Almacen.isEmpty()) {
					JOptionPane.showMessageDialog(contentPanel, "No hay producto que mostrar");
				} else {
					MostrarStock mostrarStock = new MostrarStock();
					mostrarStock.setVisible(true);
				}
			}
		});
	}
	
	/**
	 * Alta del producto con o sin fecha
	 */
	private void alta() {
		try {
			if (textoFecha.getText().length() == 0)
				Almacen.altaProducto(textoNombre.getText().trim());
			else
				Almacen.altaProductoPerecedero(textoNombre.getText().trim(), textoFecha.getText().trim());
			vaciar();
		} catch (NombreNoValidoException | FechaNoValidaException | ProductoYaExisteException e1) {
			JOptionPane.showMessageDialog(contentPanel, e1.getMessage());
		}	
	}
}
