package exMayo2018FranciscoRamirez.gui;

import java.io.IOException;

import javax.swing.JOptionPane;

import exMayo2018FranciscoRamirez.funcionalidad.Fichero;
import exMayo2018FranciscoRamirez.funcionalidad.FicheroNoExisteException;

/**
 * Principal, escribe/lee el fichero y muestra Alta de producto
 * 
 * @author Francisco Ramirez
 *
 */
public class Principal {

	public static void main(String[] args) {
		leer();
		escribir();
		Alta alta = new Alta();
		alta.setVisible(true);
	}

	// --------------------------FICHERO--------------------------------

	/**
	 * Lee el fichero txt con nuestro nombre
	 */
	private static void leer() {
		try {
			JOptionPane.showMessageDialog(null, Fichero.leer(), "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		} catch (FicheroNoExisteException | IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	/**
	 * Escribe el fichero sino está escrito
	 */
	private static void escribir() {

		try {
			if (Fichero.isExist())
				JOptionPane.showMessageDialog(null, "Voy a machacar el fichero.");
			Fichero.escribir();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());

		}
	}
}