/* Enunciado: Crea un programa que dibuje un cuadrado o un triángulo con asteriscos "*".
 * - Indicaremos el tamaño del lado y si la figura a dibujar es una u otra.*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static int lado;
    private static int figura;
    static boolean salir = false;
    static Scanner scan= new Scanner(System.in);

    public static void main (String [ ] args) {
        while(!salir) {
            try {
                do {
                    System.out.println("¿Cuál es el tamaño del lado?");
                    lado = scan.nextInt();
                    if (lado<=0) {
                        System.out.println("El número debe ser mayor que 0 y entero.");
                    }
                } while ( lado<=0);
                System.out.println("¿Qué figura quieres dibujar? 1, Cuadrado. 2, triángulo.");
                figura = scan.nextInt();
                switch (figura) {
                    case 1:
                        dibujarCuadrado(lado);
                        comprobarSalir();
                        break;
                    case 2:
                        dibujarTriangulo(lado);
                        comprobarSalir();
                        break;
                    default:
                        System.out.println("Escribe: 1 o 2.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número entero positivo.");
                scan.next();
            }
        }
        scan.close();
    }

    private static void comprobarSalir() {
        int salirInterno;
        do {
            System.out.println("¿Quiere continuar el programa? 1, Sí. 2, Salir.");
            salirInterno = scan.nextInt();
            if (salirInterno == 1) {
                System.out.println("Continúa en el programa.");
                salir = false;
            } else if (salirInterno == 2) {
                System.out.println("El programa ha finalizado. Gracias por la visita.");
                salir = true;
            }
        } while (salirInterno!=1 && salirInterno!=2);
    }

    private static void dibujarTriangulo(int lado) {
        String cadena="";
        for (int i=0; i<lado; i++){
            cadena=cadena+"*";
            System.out.println(cadena);
        }

    }

    private static void dibujarCuadrado(int lado) {
        //formamos la cabeza y culo
        String cabeza= "";
        for ( int i = 0; i <lado; i++){
            cabeza= cabeza+"*";
        }

        //formamos lo del medio
        String medio= "";
        medio= medio+"*";
        for (int i = 0; i < (lado-2); i++){
            medio=medio+" ";
        }
        medio= medio+"*";

        System.out.println(cabeza);
        for (int i= 0; i < (lado-2); i++){
            System.out.println(medio);
        }
        System.out.println(cabeza);
    }
}
