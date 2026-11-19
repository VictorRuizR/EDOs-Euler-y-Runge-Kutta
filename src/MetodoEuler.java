/**
 * Actividad 1: Metodo de Euler para el problema de valor inicial
 *     y' = x - y,   y(0) = 1,   x_final = 0.3
 * Formula del metodo:  y_{n+1} = y_n + h * f(x_n, y_n),   x_{n+1} = x_n + h
 */
public class MetodoEuler {

    // Funcion de la EDO: f(x, y) = x - y
    public static double evaluarFuncion(double x, double y) {
        return x - y;
    }

    // Solucion analitica exacta de y' = x - y, y(0) = 1  ->  y(x) = x - 1 + 2e^(-x)
    // Se usa solo para calcular el error absoluto |y_exacta(x_n) - y_n|
    public static double solucionExacta(double x) {
        return x - 1 + 2 * Math.exp(-x);
    }

    public static void main(String[] args) {
        double x0 = 0.0;
        double y0 = 1.0;
        double h = 0.01; // Variar este valor en el reporte (ej. 0.1, 0.05, 0.01)
        double xFinal = 0.3;

        // Criterio de paro (numero total de pasos N)
        int nPasos = (int) Math.round((xFinal - x0) / h);
        double x = x0;
        double y = y0;

        // Se agregan las columnas de la solucion exacta y del error absoluto
        System.out.println("n\t x_n\t y_n (Euler)\t y_exacta\t Error absoluto");
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%d\t %.4f\t %.6f\t %.6f\t %.6f\n", 0, x, y, solucionExacta(x), Math.abs(solucionExacta(x) - y));

        for (int i = 0; i < nPasos; i++) {
            // Calculo de la pendiente y actualizacion de x y y
            double pendiente = evaluarFuncion(x, y);  // f(x_n, y_n)
            y = y + h * pendiente;                    // y_{n+1} = y_n + h * f(x_n, y_n)
            x = x0 + (i + 1) * h;                     // x_{n+1} (se calcula desde x0 para no acumular error de redondeo)

            // Impresion del paso con la solucion exacta y el error absoluto
            double yExacta = solucionExacta(x);
            System.out.printf("%d\t %.4f\t %.6f\t %.6f\t %.6f\n", i + 1, x, y, yExacta, Math.abs(yExacta - y));
        }
    }
}
