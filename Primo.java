/*
ENUNCIADO:
Programa una clase con un método esPrimo(int numero) que determine si un número es primo.

El método debe:
 • Devolver true si el número es primo.
 • Devolver false en caso contrario.
 • No utilizar estructuras innecesarias.
 • Ser eficiente para números medianamente grandes.

Incluye un método main para probarlo con varios ejemplos.
*/

public class Primo {


    /**
     * Determina, de forma eficiente, si un número es primo.
     * @param numero Número a evaluar.
     * @return true si el número es primo, false en caso contrario.
     */
    public static boolean esPrimo(int numero) {
        // Suponemos que el número es primo (hasta que se de demuestre lo contrario)
        boolean primo = true;
        int tope = (int) Math.sqrt(numero) + 1; // Solo necesitamos probar hasta la raíz cuadrada del número
        // Caso especial: divisible entre 2
        if (numero > 2 && numero % 2 == 0) {
            return false; // No es primo
        }
        // Para cada numero k desde 2 hasta numero-1:
        for (int k = 3; k < tope; k+=2) {
            // Si numero es divisible por k, entonces no es primo 
            if (numero % k == 0) {
                primo = false;
                break; // No es necesario seguir buscando divisores
            }
        }
        
        // Si después de probar todos los k, no encontramos ningún divisor, entonces es primo
        return primo;
    }

    
    public static void main(String[] args) {

        for (int i = 1; i <= 100000; i++) {
            if (esPrimo(i)) {
                System.out.print(i);
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
