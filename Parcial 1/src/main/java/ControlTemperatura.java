import java.util.Scanner;
public class ControlTemperatura {

    static final int DIAS_SEMANA = 7;
    static String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] temperaturas = new double[DIAS_SEMANA];
        boolean datosIngresados = false;
        int opcion;

        do {
            mostrarMenu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    ingresarTemperaturas(sc, temperaturas);
                    datosIngresados = true;
                    break;
                case 2:
                    if (datosIngresados) {
                        mostrarTemperaturas(temperaturas);
                    } else {
                        System.out.println("¡Primero debe ingresar las temperaturas!");
                    }
                    break;
                case 3:
                    if (datosIngresados) {
                        double maxTemp = obtenerMaxima(temperaturas);
                        int indiceMax = obtenerIndiceMaxima(temperaturas);
                        mostrarMaxima(maxTemp);
                        mostrarMaxima(maxTemp, dias[indiceMax]);
                    } else {
                        System.out.println("¡Primero debe ingresar las temperaturas!");
                    }
                    break;
                case 4:
                    if (datosIngresados) {
                        double suma = sumarTemperaturasRecursiva(temperaturas, 0);
                        System.out.printf("La suma total de las temperaturas es: %.2f\n", suma);
                    } else {
                        System.out.println("¡Primero debe ingresar las temperaturas!");
                    }
                    break;
                case 5:
                    System.out.println("Gracias por usar el sistema.");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while (opcion != 5);

        sc.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n--- Menú de Opciones ---");
        System.out.println("1. Ingresar temperaturas");
        System.out.println("2. Mostrar todas las temperaturas");
        System.out.println("3. Mostrar temperatura máxima");
        System.out.println("4. Sumar temperaturas ");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Ingr Temp
    public static void ingresarTemperaturas(Scanner sc, double[] temperaturas) {
        System.out.println("Ingrese las temperaturas máximas de la semana:");
        for (int i = 0; i < DIAS_SEMANA; i++) {
            System.out.print(dias[i] + ": ");
            temperaturas[i] = sc.nextDouble();
        }
    }

    // Prcdmt  mtr temp
    public static void mostrarTemperaturas(double[] temperaturas) {
        System.out.println("Temperaturas registradas:");
        for (int i = 0; i < DIAS_SEMANA; i++) {
            System.out.printf("%s: %.2f°C\n", dias[i], temperaturas[i]);
        }
    }

    // F R T M
    public static double obtenerMaxima(double[] temperaturas) {
        double max = temperaturas[0];
        for (int i = 1; i < DIAS_SEMANA; i++) {
            if (temperaturas[i] > max) {
                max = temperaturas[i];
            }
        }
        return max;
    }

    // D I D  temp Max
    public static int obtenerIndiceMaxima(double[] temperaturas) {
        int indice = 0;
        for (int i = 1; i < DIAS_SEMANA; i++) {
            if (temperaturas[i] > temperaturas[indice]) {
                indice = i;
            }
        }
        return indice;
    }

    // Método sobrecargado: sin día
    public static void mostrarMaxima(double temperatura) {
        System.out.printf("La temperatura máxima fue: %.2f°C\n", temperatura);
    }

    // Método sobrecargado: con día
    public static void mostrarMaxima(double temperatura, String dia) {
        System.out.printf("La temperatura más alta fue %.2f°C el día %s\n", temperatura, dia);
    }

    // F R S Temp
    public static double sumarTemperaturasRecursiva(double[] temperaturas, int index) {
        if (index == temperaturas.length) {
            return 0;
        } else {
            return temperaturas[index] + sumarTemperaturasRecursiva(temperaturas, index + 1);
        }
    }
}