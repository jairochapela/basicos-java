import java.util.Scanner;

public class CalculadoraBMI {
    
    public static void main(String[] args) {
        // Solicitar al usuario su peso y altura
        Scanner s = new Scanner(System.in);
        System.out.print("Por favor, introduce tu peso en kilogramos: ");
        double peso = s.nextDouble();
        System.out.print("Por favor, introduce tu estatura en metros: ");
        double estatura = s.nextDouble();

        // Código para calcular el BMI
        double bmi = peso / (estatura * estatura);
        System.out.println("Tu índice de masa corporal (BMI) es: " + bmi);

        // Evaluación de condiciones basadas en el BMI
        if (bmi < 18.5) {
            System.out.println("Bajo peso");
        } else if (bmi < 24.9) {
            System.out.println("Peso normal");
        } else if (bmi < 29.9) {
            System.out.println("Sobrepeso");
        } else {
            System.out.println("Obesidad");
        }
    }
}
