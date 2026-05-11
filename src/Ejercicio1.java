import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresar 3 numeros");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int suma = a + b + c;
        System.out.println("La suma de los 3 numeros es: " + suma);

        double prom = suma / 3.0;
        System.out.println("El promedio es: " + prom);

        int producto = a * b * c;
        System.out.println("El producto es: " + producto);

        int max;
        int min;

        // Mínimo
        if (a < b && a < c) {
            min = a;
        } else if (b < a && b < c) {
            min = b;
        } else {
            min = c;
        }
        System.out.println("El numero mas chico es: " + min);

        // Máximo
        if (a > b && a > c) {
            max = a;
        } else if (b > a && b > c) {
            max = b;
        } else {
            max = c;
        }
        System.out.println("El numero mas grande es: " + max);
    }
}

