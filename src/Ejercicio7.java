import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese monto en pesos: ");
        int monto = sc.nextInt();

        int[] valores = {2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};

        for (int i = 0; i < valores.length; i++) {
            int cantidad = monto / valores[i];

            if (cantidad > 0) {
                System.out.println(valores[i] + ": " + cantidad);
                monto %= valores[i];
            }
        }
    }
}

