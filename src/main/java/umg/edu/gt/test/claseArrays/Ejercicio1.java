package umg.edu.gt.test.claseArrays;

import org.apache.log4j.Logger;

public class Ejercicio1 {
    // Crear un logger de log4j
    private static final Logger logger = Logger.getLogger(Ejercicio1.class);

    // Método para calcular la máxima riqueza
    public int maximaRiqueza(int[][] cuentas) {
        int maxRiqueza = 0;

        // Registrar el inicio del cálculo
        logger.info("Iniciando cálculo de la máxima riqueza.");

        for (int[] cliente : cuentas) {
            int riquezaCliente = 0;
            for (int cuenta : cliente) {
                riquezaCliente += cuenta;
            }
            // Actualizar la máxima riqueza encontrada
            maxRiqueza = Math.max(maxRiqueza, riquezaCliente);
        }

        // Registrar el resultado
        logger.info("La máxima riqueza es: " + maxRiqueza);
        return maxRiqueza;
    }

    // Método main para probar el código
    public static void main(String[] args) {
        Ejercicio1 banco = new Ejercicio1();

        int[][] cuentas1 = {{1,2,3},{3,2,1}};
        logger.info("Máxima riqueza para cuentas1: " + banco.maximaRiqueza(cuentas1)); // Salida: 6

        int[][] cuentas2 = {{1,5},{7,3},{3,5}};
        logger.info("Máxima riqueza para cuentas2: " + banco.maximaRiqueza(cuentas2)); // Salida: 10

        int[][] cuentas3 = {{2,8,7},{7,1,3},{1,9,5}};
        logger.info("Máxima riqueza para cuentas3: " + banco.maximaRiqueza(cuentas3)); // Salida: 17
    }
}