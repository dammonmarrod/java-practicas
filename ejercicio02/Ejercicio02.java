package acvitivda02;

import java.util.Scanner;

public class Ejercicio02 {

	/* Declaro un Scanner para leer desde teclado */
	public static Scanner sc = new Scanner(System.in);

	/* Declaro un array tipo double de tamaño 5 */
	public static String[][] myArray = { 
			
			{ "E.T" + " " + "8" + " " + "5" + " " + "10" + " "+ "4" },
			{ "Sharknado" + " " + "3" + " " + "8" + " " + "9" + " "+ "7" },
			{ "Godzilla" + " " + "9" + " " + "7" + " " + "6" + " "+ "8" },};
			

	public static String stringIntroducido; /* Variable para recoger el valor introducido por el usuario */
	public static int esNumeroEntero;
	public static int opcionSeleccionada; /* variable para mostrar que el valor introducido es un número */

	
	
	public static void main(String[] args) {

		/* Con un do-while mostramos el menú hasta que se introduzca un 0 */
		do {
			/* Mostramos el menú */
			System.out.println("=========================================");
			System.out.println("Introduzca la operación a realizar del siguiente menú de opciones:");
			System.out.println("1. Mostrar el nombre y puntuaciones de todas las películas.");
			System.out.println("2. Modificar el nombre de una película según su posición en el array. ");
			System.out.println("3. Modificar una puntuación de una película según su posición en el array.");
			System.out.println("4. Mostrar las puntuaciones de una película en concreto seleccionada según su posición en el array.");
			System.out.println("0 Finalizar.");

			opcionSeleccionada = pideEntero();/* Guardo el número introducido en una variable */

			/*Si es menor que 0 y mayor que 4 que son las opciones*/
			if(opcionSeleccionada <0 && opcionSeleccionada > 4) {
				System.out.println("Valor introducido no válido");
			}
			
			switch (opcionSeleccionada) {

			case 1:
				/*Mostrar el nombre y puntuaciones de todas las películas*/
				mostrarArray(myArray);
				break;

			case 2:

				break;

			case 3:
				/*Modificar una puntuación de una película 
				 * según su posición en el array */
				modificaPuntuacionPelicula(myArray);
				break;

			case 4:
				/*Mostrar las puntuaciones de una película en concreto seleccionada 
				 * según su posición en el array.*/
				mostrarPuntuacionesPelicula(myArray);
				break;
			}

			/*
			 * Si el usuario introduce un 0, se ha de mostrar un mensaje de despedida y
			 * finalizar el programa
			 */
		} while (opcionSeleccionada != 0);

	}

	

	
	/*
	 * pideEntero() que no reciba ningún parámetro y retorne un valor entero. La
	 * función ha de pedir un número por consola (si el usuario no introduce un
	 * número se ha de volver a pedirlo repitiendo el proceso hasta que el usuario
	 * introduzca un valor numérico válido) y retornar el número introducido.
	 */
	public static int pideEntero() {
		boolean esNumero = false;
		do {
			System.out.println("¿Qué opción de las del menú quieres realizar? ");
			stringIntroducido = sc.nextLine();
			if (isNum(stringIntroducido)) {
				esNumero = true; // Si es número dejamos de pedir el valor
			}else {
				System.out.println("El valor introducido no es un número. Introduce por favor una opción válida.");
			}
		} while (esNumero != true);

		return Integer.parseInt(stringIntroducido);
	}

	/* Función para verificar que es un número el valor introducido */
	public static boolean isNum(String strNum) {
		boolean respuesta = true;
		try {
			Integer.parseInt(strNum);// Si es posible parsearlo por lo que el String es un número
		} catch (NumberFormatException e) {
			respuesta = false;
		}
		return respuesta;
	}

		
	
	/*mostrarInfoPeliculas (String[][] puntuaciones) : 
	 * recibe el array de puntuaciones y lo muestra.*/
	public static void mostrarArray(String[][] puntuaciones) {
		System.out.println("===============================================");
		System.out.println("Array de películas y sus puntuaciones:");
		
		for (int i = 0; i < puntuaciones.length; i++) {
			for (int j = 0; j < puntuaciones[i].length; j++) {
				System.out.print(puntuaciones[i][j]);
			}
			System.out.println();
		}
	}
	
	
	/*Verifica que una posición es correcta*/
	public static boolean existe(String[] [] array, int posicion) {
		boolean existe = true;
		for(int i=0;i<array.length; i++ ) {
			for(int j=0; j<array.length; j++) {
				if(array[i].length > posicion) {
					existe=false;
					System.out.println("No existe la posición dada");
				}
			}
		}
		return existe;
	}
	
	/*modificaPuntuacionPelicula (String[][] puntuaciones) :
	 *  modifica una puntuación de una película 
	 *  según su posición en el array. */
	public static void modificaPuntuacionPelicula(String[][] puntuaciones) {
		System.out.println("¿Que pelicula quieres modificar la posición");
		String nombrePelicula=sc.nextLine();
		if(nombrePelicula.equalsIgnoreCase("E.T.")) {
			System.out.println("Indica la posición de la puntuación que quieres modificar");
			int posicion=sc.nextInt();
			System.out.println(existe(puntuaciones, posicion));
		}
	}
	
	
	/*mostrarPuntuacionesPelicula (String[][] puntuaciones) : 
	 * muestra las puntuaciones de una película en concreto seleccionada 
	 * según su posición en el array..*/
	public static void mostrarPuntuacionesPelicula (String[][] puntuaciones) {
		
		boolean nombreCorrecto=false;
		
		do {
			System.out.println("¿De que película quieres recibir información?");
			String nombrePelicula=sc.nextLine();
			
			if(nombrePelicula.equalsIgnoreCase("E.T.")) {
				System.out.print("Las puntuaciones son: ");
				System.out.print(puntuaciones[0][0]);
				nombreCorrecto=true;
			}
			else if(nombrePelicula.equalsIgnoreCase("Sharknado")){
				System.out.print("Las puntuaciones son: ");
				System.out.print(puntuaciones[1][0]);
				nombreCorrecto=true;
			}
			else if(nombrePelicula.equalsIgnoreCase("Godzilla")){
				System.out.print("Las puntuaciones son: ");
				System.out.print(puntuaciones[1][0]);
				nombreCorrecto=true;
			}
			else {
				System.out.println("El nombre de pelicula introducido no es correcto.");
			}
			System.out.println();
		}while(nombreCorrecto !=true);
		
	}
	
}
