package EjerciciosJava;

import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numero;

        do {
            System.out.print("Ingrese un número de 5 dígitos: ");
            numero = sc.nextInt();

            if (numero < 10000 || numero > 99999) {
                System.out.println("Error: debe tener 5 dígitos");
            }

        } while (numero < 10000 || numero > 99999);

        int suma = 0;

        while (numero > 0) {
            suma += numero % 10;
            numero /= 10;
        }

        System.out.println("Suma de dígitos: " + suma);
    }
}


