package EjerciciosJava;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese su peso en la Tierra: ");
        double pesoTierra = sc.nextDouble();

        if (pesoTierra <= 0) {
            System.out.println("Error: peso inválido");
        } else {
            double pesoLuna = pesoTierra * 0.17;
            System.out.printf("Peso en la Luna: %.2f kg\n", pesoLuna);
        }
    }
}

