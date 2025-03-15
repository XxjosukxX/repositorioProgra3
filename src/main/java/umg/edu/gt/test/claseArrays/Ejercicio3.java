package umg.edu.gt.test.claseArrays;

import org.apache.log4j.Logger;

public class Ejercicio3 {
    // Crear un logger de log4j
    private static final Logger logger = Logger.getLogger(Ejercicio3.class);

    // Método para calcular la suma de todos los elementos de la matriz
    public int sumaMatriz(int[][] mat) {
        int suma = 0;
        
        // Registrar que estamos comenzando la suma
        logger.info("Iniciando la suma de los elementos de la matriz.");

        for (int[] fila : mat) {
            for (int num : fila) {
                suma += num;
            }
        }
        
        // Registrar el resultado
        logger.info("La suma total de la matriz es: " + suma);
        return suma;
    }
    
    // Método main para probar el código
    public static void main(String[] args) {
        Ejercicio3 ejercicio = new Ejercicio3();
        
        int[][] mat1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        // Log de la suma de mat1
        logger.info("Suma de los elementos de mat1: " + ejercicio.sumaMatriz(mat1)); // Salida: 45
        
        int[][] mat2 = {
            {10, 20},
            {30, 40}
        };
        
        // Log de la suma de mat2
        logger.info("Suma de los elementos de mat2: " + ejercicio.sumaMatriz(mat2)); // Salida: 100
    }
}
