import java.util.Scanner;

public class Uni6Exe02 {
    public static void main(String[] args) {
        double[] numeros = lerNumeros(); // Lê os números
        double media = mediaNumeros(numeros); // Calcula a média
        System.out.println("A média dos números é: " + media); // Exibe a média
        imprimirValoresMaioresMedia(numeros, media);
    }

    // Método para ler os 12 números reais
    public static double[] lerNumeros() {
        Scanner teclado = new Scanner(System.in);
        double[] numeros = new double[12]; // Vetor para armazenar os números

        System.out.println("Escreva 12 valores reais: ");
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = teclado.nextDouble(); // Lê cada número e coloca no vetor
        }
        teclado.close();
        return numeros;
    }

    // Método para calcular a média dos números
    public static double mediaNumeros(double[] numeros) {
        double soma = 0;
        for (int i = 0; i < numeros.length; i++) {
            soma += numeros[i]; // Soma cada valor do vetor
        }
        
        return soma / numeros.length; // Retorna a média
    }

    public static void imprimirValoresMaioresMedia(double[] numeros, double media){
        System.out.println("Valores maiores que a média: ");
        for(int i = 0; i < numeros.length; i++){
            if (numeros[i] > media) {
                System.out.println(numeros[i]);
            }
        }
    }
}
