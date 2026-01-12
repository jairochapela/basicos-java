public class Slugifier {
    

    /**
     * Convierte un texto en un "slug" adecuado para URLs.
     * Ejemplos:
     * "Hola Mundo" -> "hola-mundo"
     * "Java & Programación" -> "java-programacion"
     * "  Espacios  y   símbolos! " -> "espacios-y-simbolos"
     * @param texto El texto a convertir
     * @return El texto convertido en slug
     */
    public static String slugify(String texto) {
        // Eliminar espacios al inicio y al final
        texto = texto.trim();
        // Convertir a minúsculas
        texto = texto.toLowerCase();
        // Reemplazar espacios y símbolos por un guión
        texto = texto.replaceAll("[^\\p{L}\\p{N}]+", "-");
        // Si el resultado empieza o termina con guión, eliminarlo
        texto = texto.replaceAll("^-|-$", "");
        return texto;    
    }


    public static void main(String[] args) {
        String[] textosPrueba = {
            "Hola Mundo",
            "Java & Programación",
            "  Espacios  y   símbolos! ",
            "Título con acentos: áéíóú ü ñ",
            "+Símbolos especiales #$%&/()=?¡¿",
            "¡Feliz 2026!"
        };

        for (String texto : textosPrueba) {
            String slug = slugify(texto);
            System.out.println("Texto: \"" + texto + "\" -> Slug: \"" + slug + "\"");
        }
    }
}
