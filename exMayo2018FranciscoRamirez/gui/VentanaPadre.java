package exMayo2018FranciscoRamirez.gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaPadre extends JDialog {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;
	protected final JPanel contentPanel = new JPanel();
	
	/**
	 * Textos
	 */
	JTextField textoNombre;
	JTextField textoFecha;
	/**
	 * Labels
	 */
	JLabel lblNombre;
	JLabel lblFecha;
	/**
	 * Botones
	 */
	JButton btnAccion1;
	JButton btnAccion2;

	/**
	 * Create the dialog.
	 */
	public VentanaPadre() {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				salir();
			}
		});
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 381, 136);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(124, 11, 78, 14);
		contentPanel.add(lblNombre);
		
		lblFecha = new JLabel("Fecha caducidad");
		lblFecha.setBounds(75, 39, 159, 14);
		contentPanel.add(lblFecha);
		
		btnAccion1 = new JButton("");
		btnAccion1.setBounds(124, 64, 91, 23);
		contentPanel.add(btnAccion1);
		
		btnAccion2 = new JButton("");
		btnAccion2.setBounds(225, 64, 128, 23);
		contentPanel.add(btnAccion2);
		
		textoNombre = new JTextField();
		textoNombre.setBounds(179, 8, 137, 20);
		contentPanel.add(textoNombre);
		textoNombre.setColumns(10);
		
		textoFecha = new JTextField();
		textoFecha.setBounds(179, 36, 137, 20);
		contentPanel.add(textoFecha);
		textoFecha.setColumns(10);
	}
	
	/**
	 * Vacia el texto del nombre y de la fecha
	 */
	protected void vaciar(){
		textoNombre.setText("");
		textoFecha.setText("");
	}
	
	/**
	 * Pregunta si desea salir del programa.
	 */
	private void salir() {

		if (JOptionPane.showConfirmDialog(contentPanel, "Vas a salir del programa. ¿Estás seguro?", "Saliendo",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(contentPanel, "Aaaaaaaaaaaaaadios");
			//dispose(); Solo cierra la ventana abierta, no el programa.
			//dispose();
			System.exit(0);
		}
	}
}