package com.everis.mnvjev;

import java.io.*;
import java.util.*;
import org.apache.commons.io.*;
import org.apache.commons.io.filefilter.*;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import com.google.common.base.Predicate;

/**
 * Formación - Dual - Javie Esmerado Vela
 * 
 * @author esmer
 *
 */
public class EsmeradoApp {

	/**
	 * ---------------> Ejemplos - Google Guava <---------------
	 * 
	 * --Predicados--
	 * 
	 * Este primer ejemplo nos va a decir si un número entero es mayor que 5
	 * devolviendo un boolean.
	 * 
	 */
	final Predicate<Integer> x = new Predicate<Integer>() {
		@Override
		public boolean apply(Integer x) {
			return x > 5;
		}
		// Este método no va a ser ejecutado. Es solo de ejemplo.
	};

	/**
	 * Es el único ejemplo que voy a poner de este repositorio, ya que está
	 * orientado para hacer pruebas de ejecución, y sinceramente no se si por no
	 * importar bien los repositorios o por que motivo, no he conseguido poner
	 * ninguna en funcionamiento.
	 */

	// Atributos con el contenido de los ficheros para el ejemplo de Apache Commons
	// IO.
	private static String TestFile1 = "C:\\dev\\WorkspaceEveris\\everisdesafiomvn-jev\\src\\main\\java\\com\\everis\\DirectorioPrueba\\prueba.txt";
	private static String TestFile2 = "C:\\dev\\WorkspaceEveris\\everisdesafiomvn-jev\\src\\main\\java\\com\\everis\\DirectorioPrueba\\prueba2.txt";

	public static void main(String[] args) {

		/**
		 * ---------------> Ejemplos - Apache Commons IO <---------------
		 * 
		 * He escogido este repositorio como segunda opción ya que desde mi punto de
		 * vista, me es mucho más útil que el anterior ya que tiene como algunos
		 * ejemplos las siguientes funcionalidades: 1. Lectura, escritura, modificación,
		 * creación y borrado de ficheros y directorios. 2. Comparación entre ficheros.
		 * 3. Facilidades de búsqueda en directorios. 4. Cálculo de Checksums.
		 */

		/**
		 * En este ejemplo voy a colocar dos ficheros y nos va a decir si son iguales.
		 */

		// Lo primero va a ser seleccionar los fichero con los que queremos realizar el
		// ejemplo. Los situamos
		// fuera del main ya que los vamos a crear como atributos.

		InputStream input1 = null;
		InputStream input2 = null;
		OutputStream output = null;
		Reader reader = null;

		try {
			System.out.println("[EJEMPLO]: APACHE COMMONS IO");
			// con estas dos variables vamos a almacenar el contenido de los dos ficheros para compararlos.
			input1 = new FileInputStream(TestFile1);
			input2 = new FileInputStream(TestFile2);

			// Usamos el contentEquals para poder comparar los dos archivos.
			if (IOUtils.contentEquals(input1, input2)) {
				System.out.println("Los ficheros son iguales!!");
			} else {
				System.out.println("Los ficheros son distintos!!");
			}

			// Una vez comprobado que son iguales, vamos a copiar el contenido del archivo 1 para introducirselo al 2.
			//Con esto vamos a comprobar que ahora los dos archivos tiene el mismo contenido, por lo que va a salir que son iguales.

			input1 = new FileInputStream(TestFile1);
			output = new FileOutputStream(TestFile2);
			IOUtils.copy(input1, output);

			// Usamos el contentEquals para poder comparar los dos archivos.
			if (IOUtils.contentEquals(input1, input2)) {
				System.out.println("Los ficheros son iguales");
			} else {
				System.out.println("Los ficheros son distintos");
			}

			// Sacamos el número de líneas de un Stream de texto.
			reader = new FileReader(TestFile1);
			java.util.List list1 = IOUtils.readLines(reader);
			System.out.println("El fichero tiene " + list1.size() + " lineas.");

		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		/**
		 *---------------> Ejemplos - Apache Commons Lang <--------------- 
		 */
		
		System.out.println("[EJEMPLO]: APACHE COMMONS LANG");
		String[] nombres = new String[0];
		int[] edades = new int[] {10,10};
		
		nombres = ArrayUtils.add(nombres, "Javier");
		nombres = ArrayUtils.add(nombres, "Nadia");
		nombres = ArrayUtils.add(nombres, "Tellez");
		nombres = ArrayUtils.add(nombres, "Susana");
		//Lo primero que vamos a hacer es comprobar si nuestro array está vacio.
		System.out.println("Está el array vacío? " + ArrayUtils.isEmpty(nombres));
 
		//Convertimos un array de tipos primitivos a uno de Objetos.
		Integer[] v = ArrayUtils.toObject(edades);
		
		//Ahora crearemos una copia del array nombres.
		String[] nombres2 = ArrayUtils.clone(nombres);
		
		//Vamos a buscar la primera aparición de un elemento de nuestro array.
		System.out.println(ArrayUtils.indexOf(nombres, "Tellez"));
		
		//Vamos a buscar un elemento. Si existe mostrará true, si no, false. Vamos a poner dos ejemplos.
		boolean x = ArrayUtils.contains(nombres, "Nadia");
		boolean y = ArrayUtils.contains(nombres, "Esmerado");
		
		if (x == true) {
			System.out.println("El nombre Nadia existe en el array.");
		}else {
			System.out.println("El nombre Nadia no existe en el array.");
		}
		
		if (y == true) {
			System.out.println("El nombre Esmerado existe en el array.");
		}else {
			System.out.println("El nombre Esmerado no existe en el array.");
		}
		
		
	}

}
