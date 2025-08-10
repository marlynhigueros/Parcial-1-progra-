import java.util.Scanner;

    public class Escalera_numerica {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Ingrese el número de niveles: ");
            int niveles = sc.nextInt();

            if (niveles < 1) {
                System.out.println("Error: El número debe ser mayor o igual a 1.");
            } else {
                imprimirEscaleraAscendente(niveles);
                imprimirEscaleraDescendenteRecursiva(niveles - 1); // Punto extra: recursivo
            }

            sc.close();
        }
        public static void imprimirEscaleraAscendente(int niveles) {
            for (int i = 1; i <= niveles; i++) {
                imprimirLinea(i);
            }
        }
        public static void imprimirEscaleraDescendenteRecursiva(int nivel) {
            if (nivel == 0) return;
            imprimirLinea(nivel);
            imprimirEscaleraDescendenteRecursiva(nivel - 1);
        }

        // Método sobrecargado que imprime los números del 1 hasta nivel
        public static void imprimirLinea(int nivel) {
            for (int i = 1; i <= nivel; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        // Método sobrecargado que imprime un símbolo en vez de números
        public static void imprimirLinea(int nivel, char simbolo) {
            for (int i = 1; i <= nivel; i++) {
                System.out.print(simbolo + " ");
            }
            System.out.println();
        }
    }
