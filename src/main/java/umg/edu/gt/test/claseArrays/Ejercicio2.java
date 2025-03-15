# Configuración básica de log4j
log4j.rootLogger=INFO, console

# Appender para consola
log4j.appender.console=org.apache.log4j.ConsoleAppender
log4j.appender.console.layout=org.apache.log4j.PatternLayout
log4j.appender.console.layout.ConversionPattern=%d{ISO8601} [%-5p] %c{1} - %m%n
3. Modificar la Clase para Usar log4j
A continuación te muestro cómo modificar la clase Ejercicio2 para que utilice log4j para registrar mensajes en lugar de usar System.out.println.

java
Copiar
Editar
package umg.edu.gt.test.claseArrays;

import java.util.*;
import org.apache.log4j.Logger;

public class Ejercicio2 {
    // Crear un logger de log4j
    private static final Logger logger = Logger.getLogger(Ejercicio2.class);

    // Método para ordenar las diagonales de la matriz
    public int[][] ordenarDiagonales(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        
        // Registrar que estamos comenzando a ordenar las diagonales
        logger.info("Iniciando el ordenamiento de las diagonales.");

        // Ordenar cada diagonal que comienza en la primera fila
        for (int col = 0; col < n; col++) {
            ordenarDiagonal(mat, 0, col, m, n);
        }
        
        // Ordenar cada diagonal que comienza en la primera columna
        for (int row = 1; row < m; row++) {
            ordenarDiagonal(mat, row, 0, m, n);
        }
        
        logger.info("El ordenamiento de las diagonales ha finalizado.");
        return mat;
    }
    
    // Método auxiliar para ordenar una diagonal
    private void ordenarDiagonal(int[][] mat, int row, int col, int m, int n) {
        List<Integer> diagonal = new ArrayList<>();
        int r = row, c = col;
        
        // Extraer los elementos de la diagonal
        while (r < m && c < n) {
            diagonal.add(mat[r][c]);
            r++;
            c++;
        }
        
        // Ordenar la diagonal
        Collections.sort(diagonal);
        
        // Colocar los elementos ordenados de nuevo en la matriz
        r = row;
        c = col;
        int index = 0;
        while (r < m && c < n) {
            mat[r][c] = diagonal.get(index++);
            r++;
            c++;
        }
    }
    
    // Método main para probar el código
    public static void main(String[] args) {
        Ejercicio2 ejercicio = new Ejercicio2();
        
        int[][] mat1 = {
            {3, 3, 1, 1},
            {2, 2, 1, 2},
            {1, 1, 1, 2}
        };
        
        logger.info("Ordenando diagonales de la matriz mat1...");
        int[][] resultado1 = ejercicio.ordenarDiagonales(mat1);
        logger.info("Resultado para mat1: " + Arrays.deepToString(resultado1));
        
        int[][] mat2 = {
            {11, 25, 66, 1, 69, 7},
            {23, 55, 17, 45, 15, 52},
            {75, 31, 36, 44, 58, 8},
            {22, 27, 33, 25, 68, 4},
            {84, 28, 14, 11, 5, 50}
        };
        
        logger.info("Ordenando diagonales de la matriz mat2...");
        int[][] resultado2 = ejercicio.ordenarDiagonales(mat2);
        logger.info("Resultado para mat2: " + Arrays.deepToString(resultado2));
    }
}