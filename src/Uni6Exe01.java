import java.util.Scanner;

public class Uni6Exe01 {

    public static void main(String[] args) {
        int[] numeros = lerNumeros();  
        escreverInverso(numeros);
    }

    
    public static int[] lerNumeros() {
        Scanner teclado = new Scanner(System.in);
        int[] numeros = new int[10];

        System.out.println("Digite 10 números inteiros:");
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = teclado.nextInt();
        }
        teclado.close();
        return numeros; 
    }

    public static void escreverInverso(int[] numeros) {
        System.out.println("Os números na ordem inversa são:");
        for (int i = numeros.length - 1; i >= 0; i--) {
            System.out.println(numeros[i]);
        }
    }
}
