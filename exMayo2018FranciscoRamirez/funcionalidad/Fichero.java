package exMayo2018FranciscoRamirez.funcionalidad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

/**
 * Fichero con nuestro nombre, bienvenida
 * 
 * @author Francisco Ramírez
 *
 */
public class Fichero {

	/**
	 * Archivo txt con mi nombre
	 */
	private static final File FileFrancisco = new File("franciscoRamirez.txt");

	/**
	 * Lee el fichero si está escrito
	 * 
	 * @return
	 * @throws FicheroNoExisteException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String leer() throws FicheroNoExisteException, FileNotFoundException, IOException {
		String cadena = "";
		String linea;
		if (!isExist())
			throw new FicheroNoExisteException("No hay ningún fichero que leer.");
		try (BufferedReader c = new BufferedReader(new FileReader(FileFrancisco))) {
			while ((linea = c.readLine()) != null)
				cadena += linea + "\n";
			return cadena;
		}
	}

	/**
	 * Escribe el fichero
	 * 
	 * @throws IOException
	 */
	public static void escribir() throws IOException {
		LocalDate fecha = LocalDate.now();
		try (BufferedWriter c = new BufferedWriter(new FileWriter(FileFrancisco))) {
			c.write("Bienvenido al examen final");
			c.newLine();
			c.write("Mayo de 2018");
			c.newLine();
			c.write("Hoy es día " + fecha.getDayOfMonth() + ", " + getDiaDeLaSemana(fecha));
			c.newLine();
			c.write("Francisco Ramírez Ruiz");
		}
	}

	/**
	 * Día de la semana
	 * 
	 * @param localDate
	 * @return
	 */
	private static String getDiaDeLaSemana(TemporalAccessor localDate) {
		return DayOfWeek.from(localDate).getDisplayName(TextStyle.FULL, Locale.getDefault());
	}

	/**
	 * Existe el fichero
	 * 
	 * @return
	 */
	public static boolean isExist() {
		return FileFrancisco.exists();
	}
}
