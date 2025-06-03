import java.util.Scanner;

public class Uni6Exe05 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String[] resDele = new String[5];
        String[] resDela = new String[5];

        perguntasEle(resDele, teclado);
        perguntasEla(resDela, teclado);
        comparaResposta(resDele, resDela);
        int contador = comparaResposta(resDele, resDela);
        mostraResultado(contador);
    }

    private static void mostraResultado(int contador) {
        if (contador == 15) {
            System.out.println("Casem!!!");
        } else if(contador >= 10 & contador <= 14) {
            System.out.println("Vocês têm muita coisa em comum!");
        } else if(contador >= 5 & contador <= 9){
            System.out.println("Talvez não dê certo :(");
        } else if (contador >= 0 & contador <= 4){
            System.out.println("Vale um encontro");
        } else if (contador >= -1 & contador <= -9){
            System.out.println("Melhor nem perder tempo");
        } else if(contador >= -10){
            System.out.println("Vocês se odeiam!!!");
        }
    }

    private static int comparaResposta(String[] resDele, String[] resDela) {
        int contador = 0;
        for (int i = 0; i < 5; i++) {
            if (resDele[i].equals(resDela[i])) {
                contador += 3;
            } else if (
                (resDele[i].equals("S") && resDela[i].equals("NR")) ||
                (resDele[i].equals("N") && resDela[i].equals("NR")) ||
                (resDela[i].equals("S") && resDele[i].equals("NR")) ||
                (resDela[i].equals("N") && resDele[i].equals("NR"))
            ) {
                contador += 1;
            } else if (
                (resDele[i].equals("S") && resDela[i].equals("N")) ||
                (resDele[i].equals("N") && resDela[i].equals("S"))
            ) {
                contador -= 1;
            }
        }
                return contador;
    }

    private static void perguntasEle(String[] resDele, Scanner teclado) {
        String[] enunciado = { "Digite a resposta com S, N ou NR" };
        String[] perguntas = { "Gosta de música sertaneja?", "Gosta de futebol?", "Gosta de seriados?",
                "Gosta de redes sociais?", "Gosta da Oktoberfest?" };
        for (int i = 0; i < 5; i++) {
            System.out.println(enunciado[0]);
            System.out.println(perguntas[i]);
            resDele[i] = teclado.next().toUpperCase();
        }

    }

    private static void perguntasEla(String[] resDela, Scanner teclado) {
        String[] enunciado = { "Digite a resposta com S, N ou NR" };
        String[] perguntas = { "Gosta de música sertaneja?", "Gosta de futebol?", "Gosta de seriados?",
                "Gosta de redes sociais?", "Gosta da Oktoberfest?" };

        for (int i = 0; i < 5; i++) {
            System.out.println(enunciado[0]);
            System.out.println(perguntas[i]);
            resDela[i] = teclado.next().toUpperCase();
        }
    }

}
