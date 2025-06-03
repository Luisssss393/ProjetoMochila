// Faça um programa para ler os valores de dois vetores de inteiros, cada um contendo 10 elementos. 
//Crie um terceiro vetor em que cada elemento é a soma dos valores contidos nas posições respectivas dos vetores originais. 
//Por exemplo, vetor1 = [1,2,3] vetor2 = [1,5,6] vetor3 = [2,7,9]. 
//Exiba, ao final, os três vetores na tela. Faça três métodos: um método para ler valores dos vetores, outro para somar e outro para escrever os vetores.


import java.util.Arrays;
import java.util.Scanner;

public class Uni6Exe04 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int[] vetor1 = lerVetor(teclado);
        int[] vetor2 = lerVetor(teclado);
        int[] vetor3 = somarVetor(vetor1, vetor2);
        escreverVetores(vetor1, vetor2, vetor3);
        teclado.close();
    }

    public static int[] lerVetor(Scanner teclado){
        int[] numeros = new int[10];

        System.out.println("Digite 10 valores inteiros: ");
        for(int i = 0; i < numeros.length; i++){
            numeros[i] = teclado.nextInt();
        }
        return numeros;
    }

    public static int[] somarVetor(int[] vetor1, int[] vetor2){
        int[] soma = new int[vetor1.length];
        for(int i = 0; i < vetor1.length; i++){
            soma[i] += vetor1[i] + vetor2[i];
        }
        return soma;
    }

    public static void escreverVetores(int[]vetor1, int[]vetor2, int[]vetor3){
        System.out.println("Vetor 1: " + Arrays.toString(vetor1));
        System.out.println("Vetor 2: " + Arrays.toString(vetor2));
        System.out.println("Soma dos vetores: " + Arrays.toString(vetor3));
    }
}
