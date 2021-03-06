package acvitivda02;

import java.util.Scanner;

public class Ejercicio01 {

	/*Declaro un Scanner para leer desde teclado*/
	public static Scanner sc= new Scanner(System.in);
	
	/*Declaro un array tipo double de tamaño 5*/
	public static double myArray []=new double[5];
	
	/*Variable para recoger la elección del usuario */
	public static int opcionSeleccionada;
	
	public static void main(String[] args) {
		
		/*Escribe un programa que pida al usuario 5 valores decimales del 0 al 100. 
		 * Se deben almacenar en un array y mostrarlos por consola.  
		 * Si el usuario introduce un valor incorrecto, se ha de volver a pedir */
		double primerosValores;
		int cont=0; /*para incrementar la posición del array mientras se rellena*/
		/*Rellenamos el array con los valores indicados por el usuario */
		
		do {
			System.out.println("Introduce un número decimal entre 0 y 100.");
			primerosValores=sc.nextDouble();
			/*Verificamos que estan contenidos entre 00 y 100*/
			if (primerosValores>0 && primerosValores <100) {
				myArray[cont]=primerosValores;
				cont++;
			}else {
					System.out.println("Valor incorrecto, no se ha guardado.");
			}
		}while(cont!=5);
			
		
		

		/*Con un do-while verificamos que se muestre el menú hasta que se introduzca un 0  */
		do {
			/*Mostramos el menú */
			System.out.println("=========================================");
			System.out.println("Introduzca la operación a realizar del siguiente menú de opciones:");
			System.out.println("1. Modificar el valor almacenado en una posición.");
	        System.out.println("2. Mostrar el resultado de sumar todos los números. ");
	        System.out.println("3. Mostrar el número más alto y más bajo.");
	        System.out.println("4. Ordena el array situando primero todos los números pares y luego los impares.");
	        System.out.println("0 Finalizar.");

			System.out.println("¿Qué quieres hacer? ");
			opcionSeleccionada=sc.nextInt();
			/*Si la opción indicada es menor que 0*/
			/*Si se introduce un valor menor a 0, indica que se ha introducido un valor incorrecto y vuelve a mostrar el menú.*/
			if(opcionSeleccionada<0) {
				System.out.println("Opción incorrecta. Introduzca un valor entre 0 y 4.");
			}
			
			switch (opcionSeleccionada){
			
			case 1:
				modificarUnValor(myArray);
				mostrarArray(myArray);
				break;
				
			case 2:
				sumarValores(myArray);
				mostrarArray(myArray);
				break;
				
			case 3:
				menorYmayor(myArray);
				mostrarArray(myArray);
				break;
				
			case 4:
				ordenarParesImpares(myArray);
				mostrarArray(myArray);
				break;
			}
			
			/*Si el usuario introduce un 0, se ha de mostrar un mensaje de despedida y finalizar el programa */	
		}while(opcionSeleccionada!=0);
		
		System.out.println("!Gracias por participar¡.");
			
		/*Cerramos el Scanner */
		sc.close();	
	}
	/*Cada vez que se realice la operación 1, 2, 3 y 4 
	 * se ha de mostrar por pantalla los valores almacenados en el array.  */
	public static void mostrarArray(double[] valores) {
		/*Mostramos el array por consola*/
		System.out.println("Los valores contenidos en el array son:" );
		 for(int i=0;i<valores.length;i++)
	        {
	            System.out.println("En la posición " + i + ": " + valores[i]);
	        }
	}
	
	
	/*modificarUnValor(double[] valores) : 
	 * en este caso se pedirá qué posición del array se quiere modificar 
	 * y su nuevo valor numérico entre 0 y 100 para situarlo en la posición indicada
	 * A continuación se deben mostrar todos los valores almacenados en el array.*/
	public static double[] modificarUnValor(double[] valores) {
        int posicionArray=0;
        double valorNuevo=0;
        
		System.out.println("¿Qué posición del array quieres modificar?");
		posicionArray=sc.nextInt();
		if(posicionArray >0 && posicionArray<5 ) {
			System.out.println("Introduce un nuevo valor entre 0 y 100");
			valorNuevo=sc.nextDouble();
			if(valorNuevo>0 && valorNuevo<100) {
				valores[posicionArray]=valorNuevo;
			}else {
				System.out.println("No ha sido posible modificar el valor porque no esta comprendido entre 0 y 100.");

			}
		}else {
			System.out.println("No ha sido posible modificar esa posición ya que no existe en el array.");
		}
		return valores;
	}
		
	
	/*sumarValores(double[] valores) : 
	 * Sumar todos los números almacenados en el array y mostrar el resultado. */
	public static void sumarValores(double[] valores) {
		double sumaValoresAlmacenados=0;
		for(int i=0;i<valores.length; i++ ) {
			sumaValoresAlmacenados +=valores[i];
			
		}
		System.out.println("El resultado de sumar todos los valores del array es: " + sumaValoresAlmacenados); 
	}
	
	/*menorYmayor(double[] valores) : 
	 * muestra el número más  alto y el más bajo almacenados en el array. */
	public static void menorYmayor(double[] valores) {
		/*Empiezo a valora a partir del primer valor del array*/
		double numeroMasAlto=valores [0];
		double numeroMasBajo=valores [0];
		for(int i=0;i<valores.length; i++ ) {
			/*Si el valor actual del array es mayor que el numeroMasAlto lo guardo*/
			if(valores [i] > numeroMasAlto) {
				numeroMasAlto = valores[i];
            }
			/*Si el valor actual del array es menor que el numeroMasBajo lo guardo*/
            if(valores[i]<numeroMasBajo) {
            	numeroMasBajo = valores[i];
            }		
		}
		System.out.println("El número más alto es: " + numeroMasAlto); 
		System.out.println("El número más bajo es: " + numeroMasBajo); 
	}
	
	/* ordenarParesImpares(double[] valores) : 
	 * Ordena y retorna el array situando primero todos los números pares
	 *  y luego los impares */
	
	public static void ordenarParesImpares(double[] valores) { 
		/*Creo un nuevo array para guardar los valores ordenados del tamaño del array pasado como parámetro*/
		double [] nuevoArray= new double[valores.length];
		int posicionIzquierda=0; //contador para los números pares
		int posicionDerecha=valores.length-1; //contador para los números impares
		/**/
		for(int i=0; i<valores.length; i++) {
			
			if(valores[i]%2==0) {//Si el resto es 0 es que es par
				nuevoArray[posicionIzquierda]=valores[i];
				posicionIzquierda++;
			}else {
				nuevoArray[posicionDerecha]=valores[i];
				posicionDerecha--;
			}
		}
		System.out.println("Los valores del array ordenados.");
		mostrarArray(nuevoArray);
		System.out.println();
	}
}
