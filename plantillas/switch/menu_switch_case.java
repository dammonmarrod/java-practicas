package aplicacion;

import java.util.Scanner;


public class Aplicacion {

    public static void main(String[] args) {     
        
        boolean sortir = false;
       
        do{
            switch(menu()){
                case 1: metode1();
                        break;
                case 2: metode2();
                        break;
                case 3: metode3();
                        break;
                case 0: System.out.println("Gràcies per utilitzar l'aplicació");
                		sortir = true;
                        break;
            }
        }while(!sortir);   
    }
   
    public static byte menu(){
        Scanner entrada = new Scanner(System.in);
        byte opcio;
        final byte MINIMO = 0;
        final byte MAXIMO = 3;

        do{
            System.out.println("\nMENú PRINCIPAL");
            System.out.println("1. Opció 1.");
            System.out.println("2. Opció 2.");
            System.out.println("3. Opció 3.");
            System.out.println("0. Sortir de l'aplicació.\n");
            opcio = entrada.nextByte();
            if(opcio < MINIMO || opcio > MAXIMO){
                System.out.println("Escull una opció vàlida");
            }
        }while(opcio < MINIMO || opcio > MAXIMO);
        return opcio;
    }
   
    public static void metode1(){
        System.out.println("Mètode 1");
    }
   
    public static void metode2(){
       System.out.println("Mètode 2");
    }
   
    public static void metode3(){
       System.out.println("Mètode 3");
    }

    
}
