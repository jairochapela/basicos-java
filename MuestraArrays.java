import java.util.Date;

public class MuestraArrays {
    
    public static void main(String[] args) {
        // Array de números enteros
        int[] numeros = {1, 2, 3, 5, 8};
        double[] decimales = {1.5, 2.5, 3.5, 4.5};
        String[] palabras = {"Alpha", "Bravo", "Charlie", "Delta"};
        Date[] fechas = {
            new Date(2020 - 1900, 0, 1),
            new Date(2021 - 1900, 5, 15),
            new Date(2022 - 1900, 11, 31)
        };
        int [] sinNumeros = new int[10];
        for (int i = 0; i < sinNumeros.length; i++) {
            sinNumeros[i] = i * 3;
        }

        for (int indice = 0; indice < numeros.length; indice++) {
            System.out.println("Número en la posición " + indice + ": " + numeros[indice]);
        }

        for (int indice = 0; indice < decimales.length; indice++) {
            System.out.println("Decimal en la posición " + indice + ": " + decimales[indice]);
        }

        for (int indice = 0; indice < palabras.length; indice++) {
            System.out.println("Palabra en la posición " + indice + ": " + palabras[indice]);
        }

        for (int indice = 0; indice < fechas.length; indice++) {
            System.out.println("Fecha en la posición " + indice + ": " + fechas[indice]);
        }

        for (int indice = 0; indice < sinNumeros.length; indice++) {
            System.out.println("Número generado en la posición " + indice + ": " + sinNumeros[indice]);
        }
    }

}
