/**
 * Actividad 2: Metodo de Runge-Kutta de 4to orden (RK4) para el problema de valor inicial
 *     y' = x + y,   y(0) = 1,   x_final = 0.3
 * Formula del metodo:
 *     k1 = f(x_n, y_n)
 *     k2 = f(x_n + h/2, y_n + h*k1/2)
 *     k3 = f(x_n + h/2, y_n + h*k2/2)
 *     k4 = f(x_n + h,   y_n + h*k3)
 *     y_{n+1} = y_n + (h/6) * (k1 + 2*k2 + 2*k3 + k4)
 */
public class MetodoRungeKutta {

    // Funcion de la EDO: f(x, y) = x + y
    public static double evaluarFuncion(double x, double y) {
        return x + y;
    }

    // Solucion analitica exacta de y' = x + y, y(0) = 1  ->  y(x) = 2e^x - x - 1
    // Se usa solo para calcular el error absoluto |y_exacta(x_n) - y_n|
    public static double solucionExacta(double x) {
        return 2 * Math.exp(x) - x - 1;
    }

    public static void main(String[] args) {
        double x0 = 0.0;
        double y0 = 1.0;
        double h = 0.01;
        double xFinal = 0.3;

        int nPasos = (int) Math.round((xFinal - x0) / h);
        double x = x0;
        double y = y0;

        // Se agregan las columnas de la solucion exacta y del error absoluto
        System.out.println("n\t x_n\t y_n (RK4)\t y_exacta\t Error absoluto");
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("%d\t %.4f\t %.8f\t %.8f\t %.2e\n", 0, x, y, solucionExacta(x), Math.abs(solucionExacta(x) - y));

        for (int i = 0; i < nPasos; i++) {
            // Calculo de las 4 pendientes (k1, k2, k3, k4)
            double k1 = evaluarFuncion(x, y);
            double k2 = evaluarFuncion(x + h / 2, y + h * k1 / 2);
            double k3 = evaluarFuncion(x + h / 2, y + h * k2 / 2);
            double k4 = evaluarFuncion(x + h, y + h * k3);

            // Actualizacion ponderada de y y avance de x en h
            y = y + (h / 6) * (k1 + 2 * k2 + 2 * k3 + k4);
            x = x0 + (i + 1) * h;   // se calcula desde x0 para no acumular error de redondeo

            // Impresion del paso con la solucion exacta y el error absoluto
            double yExacta = solucionExacta(x);
            System.out.printf("%d\t %.4f\t %.8f\t %.8f\t %.2e\n", i + 1, x, y, yExacta, Math.abs(yExacta - y));
        }
    }
}
