package EjerciciosJava;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresar 1 numero (inicio)");
        int x = scanner.nextInt();

        System.out.println("Ingresar la cantidad de primos");
        int n = scanner.nextInt();

        int contador = 0;

        for (int num = x; contador < n; num++) {
            int divisores = 0;

            for (int i = 1; i <= num; i++) {
                if (num % i == 0) {
                    divisores++;
                }
            }

            if (divisores == 2) {
                System.out.println(num);
                contador++;
            }
        }
    }
}