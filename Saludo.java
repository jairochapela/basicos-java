import java.util.Scanner;

public class Saludo {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Por favor, introduce tu nombre: ");
        String nombre = s.nextLine();
        System.out.println("Hola, " + nombre + "!");
    }
}
