import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese un carácter: ");
        char caracter = sc.next().charAt(0);

        if (caracter >= '0' && caracter <= '9') {
            System.out.println("Es un dígito entre 0 y 9");
        } else {
            System.out.println("No es un digito");
        }

        sc.close();
    }
}