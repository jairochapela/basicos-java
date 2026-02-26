/*
Programa una clase con un método contarVocales(String texto) que devuelva el
número de vocales que contiene una cadena.

El método debe:
 • Contar tanto mayúsculas como minúsculas.
 • Ignorar caracteres que no sean letras.
 • No utilizar expresiones regulares.
 • Devolver un entero con el total de vocales.

Incluye ejemplos de uso en el main.
*/

public class ComprobadorPW {

    private static final String VOCALES = "AEIOUÁÉÍÓÚÜÏÄËÖÀÈÌÒÙÂÊÎÔÛÃ";


    /**
     * Cuenta el número de vocales en un texto dado.
     * @param texto El texto en el que se contarán las vocales.
     * @return El número total de vocales en el texto.
     */
    public static int contarVocales(String texto) {
        int contador = 0;
        // Convertir a mayúsculas la cadena de texto
        String textoM = texto.toUpperCase();
        // Para cada caracter c en texto:
        for (char c : textoM.toCharArray()) {
            //   Si c es una vocal (encontrada en VOCALES), entonces:
            if (VOCALES.indexOf(c) != -1) {
                contador++; // Incrementamos el contador en 1
            }
        }

        return contador;
    }

    /**
     * Cuenta el número de letras en un texto dado.
     * @param texto El texto en el que se contarán las letras.
     * @return El número total de letras en el texto.
     */
    public static int contarLetras(String texto) {
        int contador = 0;
        // Convertir a mayúsculas la cadena de texto
        String textoM = texto.toUpperCase();
        // Para cada caracter c en texto:
        for (char c : textoM.toCharArray()) {
            //   Si c es una letra (encontrada en LETRAS), entonces:
            if (Character.isLetter(c)) {
                contador++; // Incrementamos el contador en 1
            }
        }

        return contador;
    }


    /**
     * Cuenta el número de consonantes en un texto dado.
     * @param texto El texto en el que se contarán las consonantes.
     * @return El número total de consonantes en el texto.
     */
    public static int contarConsonantes(String texto) {
        return contarLetras(texto) - contarVocales(texto);
    }

    /**
     * Cuenta el número de caracteres especiales en un texto dado.
     * @param texto El texto en el que se contarán los caracteres especiales.
     * @return El número total de caracteres especiales en el texto.
     */
    public static int contarCaracteresEspeciales(String texto) {
        return texto.length() - contarLetras(texto) - contarNumeros(texto);
    }

    /**
     * Cuenta el número de dígitos en un texto dado.
     * @param texto Texto en el que se contarán los dígitos.
     * @return El número total de dígitos en el texto.
     */
    public static int contarNumeros(String texto) {
        int contador = 0;
        // Para cada caracter c en texto:
        for (char c : texto.toCharArray()) {
            //   Si c es un número (encontrado en NUMEROS), entonces:
            if (Character.isDigit(c)) {
                contador++; // Incrementamos el contador en 1
            }
        }
        return contador; // Devolver el contador de números
    }

    /**
     * Cuenta el número de mayúsculas en un texto dado.
     * @param texto Texto en el que se contarán las mayúsculas.
     * @return El número total de letras mayúsculas en el texto.
     */
    public static int contarMayusculas(String texto) {
        int contador = 0;
        // Para cada caracter c en texto:
        for (char c : texto.toCharArray()) {
            if (Character.isUpperCase(c)) {
                contador++; // Incrementamos el contador en 1
            }
        }
        return contador; // Devolver el contador de mayúsculas
    }

    /**
     * Cuenta el número de minúsculas en un texto dado.
     * @param texto Texto en el que se contarán las minúsculas.
     * @return El número total de letras minúsculas en el texto.
     */
    public static int contarMinusculas(String texto) {
        int contador = 0;
        // Para cada caracter c en texto:
        for (char c : texto.toCharArray()) {
            if (Character.isLowerCase(c)) {
                contador++; // Incrementamos el contador en 1
            }
        }
        return contador; // Devolver el contador de minúsculas    
    }


    /**
     * Determina si una contraseña es segura según los siguientes criterios:
     * - Al menos 12 caracteres de longitud.
     * - Contiene al menos una letra mayúscula.
     * - Contiene al menos una letra minúscula.
     * - Contiene al menos un dígito.
     * - Contiene al menos un carácter especial (no letra ni dígito).
     * @param password Contraseña a evaluar.
     * @return true si la contraseña es segura, false en caso contrario.
     */
    public static boolean esPasswordSegura(String password) {
        int longitud = password.length();
        int numMayusculas = contarMayusculas(password);
        int numMinusculas = contarMinusculas(password);
        int numDigitos = contarNumeros(password);
        int numEspeciales = contarCaracteresEspeciales(password);
        return longitud >= 12 && numMayusculas > 0 && numMinusculas > 0 &&
            numDigitos > 0 && numEspeciales > 0;
    }


    public static void main(String[] args) {
        String texto1 = "Hola Mundo";
        String texto2 = "Java es un lenguaje de programación";
        String texto3 = "12345!@#$%";
        String texto4 = "Árboles y cigüeñas";

        String textos[] = {texto1, texto2, texto3, texto4};

        for (String t : textos) {
            System.out.println("Texto: " + t);
            System.out.println("Número de vocales: " + contarVocales(t));
            System.out.println("Número de letras: " + contarLetras(t));
            System.out.println("Número de consonantes: " + contarConsonantes(t));
            System.out.println("Número de caracteres especiales: " + contarCaracteresEspeciales(t));
            System.out.println("Número de números: " + contarNumeros(t));
            System.out.println("Número de mayúsculas: " + contarMayusculas(t));
            System.out.println("Número de minúsculas: " + contarMinusculas(t));
            System.out.println();
        }

        String password1 = "ContraseñaSegura123!";
        String password2 = "password";
        String password3 = "P@ssw0rd";
        String passwords[]= {password1, password2, password3};

        for (String p : passwords) {
            System.out.println("Contraseña: " + p);
            System.out.println("¿Es segura? " + esPasswordSegura(p));
            System.out.println();
        }
    }
}
