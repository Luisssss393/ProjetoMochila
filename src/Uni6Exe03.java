import java.util.Scanner;

public class Uni6Exe03 {
    public static void main(String[] args) {
        double[] numeros = lerNumeros();  // Lê os valores
        organizarImparEPar(numeros);      // Ajusta os valores no vetor
        imprimirNumeros(numeros);         // Imprime os valores atualizados
    }

    // Método para ler 12 valores reais
    public static double[] lerNumeros() {
        Scanner teclado = new Scanner(System.in);
        double[] numeros = new double[12]; // Vetor para armazenar os números

        System.out.println("Escreva 12 valores reais: ");
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = teclado.nextDouble(); // Lê cada número
        }
        teclado.close();
        return numeros;
    }

    // Método para ajustar os valores (aumento de 5% ou 2% baseado na posição)
    public static void organizarImparEPar(double[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            if (i % 2 == 0) {  // Posições pares (0, 2, 4, 6, 8, 10)
                numeros[i] *= 1.02;  // Aumenta 2%
            } else {  // Posições ímpares (1, 3, 5, 7, 9, 11)
                numeros[i] *= 1.05;  // Aumenta 5%
            }
        }
    }

    // Método para imprimir os valores atualizados
    public static void imprimirNumeros(double[] numeros) {
        System.out.println("Valores atualizados:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Posição " + i + ": " + numeros[i]);  // Imprime o valor da posição
        }
    }
}
