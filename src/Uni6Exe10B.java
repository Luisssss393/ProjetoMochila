import java.util.Scanner;

public class Uni6Exe10B {
    public static void main(String[] args) {
        teste();
    }

    private static int teste() {
        int opcao = 0;
        int vet[] = new int[50];
        int posicao = 0;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite uma opção válida entre 1 e 8:");
        do {
            System.out.println("---------------------------------------------");
            System.out.println("Menu");
            System.out.println("Opção 1: Incluir valor");
            System.out.println("Opção 2: Pesquisar valor");
            System.out.println("Opção 3: Alterar valor");
            System.out.println("Opção 4: Excluir valor");
            System.out.println("Opção 5: Mostrar valores");
            System.out.println("Opção 6: Ordenar valores");
            System.out.println("Opção 7: Inverter valores");
            System.out.println("Opção 8: Sair do sistema");
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    posicao = incluirVetor(vet, posicao, teclado);
                    break;
                case 2:
                    pesquisarValor(vet, teclado);
                    break;
                case 3:
                    alteraValor(vet, teclado);
                    break;
                case 4:
                    excluiValor(vet, posicao, teclado);
                    break;
                case 5:
                    mostraValor(vet, teclado, posicao);
                    break;
                case 6:
                    ordenaValor(vet, teclado, posicao);
                    break;
                case 7:
                    inverteValor(vet, teclado, posicao);
                    break;
                case 8:
                    System.out.println("Obrigado por usar o sistema, até logo!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente");
                    break;
            }
        } while (opcao != 8);
        return opcao;
    }

    private static void inverteValor(int[] vet, Scanner teclado, int posicao) {
        for(int i = 0; i < posicao; i++){
            for(int j = 0; j < i; j++){
                int temp = vet[i];
                vet[i] = vet[j];
                vet[j] = temp;
            }
            System.out.println("Valores invertidos!");
        }
    }

    private static void ordenaValor(int[] vet, Scanner teclado, int posicao) {
        for (int i = 0; i < posicao - 1; i++) {
            for (int j = 0; j < posicao - 1 - i; j++) {
                if (vet[j] > vet[j + 1]) {
                    int temporario = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = temporario;
                }
            }
        }
        mostraValor(vet, teclado, posicao);
    }

    private static void mostraValor(int[] vet, Scanner teclado, int posicao) {
        System.out.println("Mostrando os valores no vetor: ");
        for (int i = 0; i < posicao; i++) {
            System.out.println("Posição " + i + ": [" + vet[i] + "]");
        }
    }

    private static int excluiValor(int[] vet, int posicao, Scanner teclado) {
        System.out.println("Digite o valor a ser excluido: ");
        int numeroDigitado = teclado.nextInt();
        for (int i = 0; i < posicao; i++) {
            if (vet[i] == numeroDigitado) {
                for (int j = i; j < posicao - 1; j++) {
                    vet[i] = vet[i + 1];

                }
                posicao--;
                System.out.println("Valor " + numeroDigitado + " excluído com sucesso!");
                return posicao;

            }
        }
        System.out.println("Valor não encontrado");
        return posicao;
    }

    private static void alteraValor(int[] vet, Scanner teclado) {
        System.out.println("Digite o valor a ser alterado: ");
        int numeroDigitadoSair = teclado.nextInt();
        for (int i = 0; i < vet.length; i++) {
            if (vet[i] == numeroDigitadoSair) {
                System.out.println("Digite o valor que irá substituir o número " + numeroDigitadoSair);
                int numeroDigitadoEntrada = teclado.nextInt();
                vet[i] = numeroDigitadoEntrada;
                System.out.println("Valor alterado!");
                return;
            }
        }
        System.out.println("Valor não encontrado");
    }

    private static void pesquisarValor(int[] vet, Scanner teclado) {
        System.out.println("Digite o valor que deseja pesquisar: ");
        int numeroDigitado = teclado.nextInt();
        for (int i = 0; i < vet.length; i++) {
            if (numeroDigitado == vet[i]) {
                System.out.println("Número " + numeroDigitado + " encontrado na posição " + i);
                return;
            }
        }
        System.out.println("Numero não encontrado");
    }

    private static int incluirVetor(int[] vet, int posicao, Scanner teclado) {
        System.out.println("Digite o número a ser incluído no vetor:");
        int numero = teclado.nextInt();
        if (posicao < vet.length) {
            vet[posicao] = numero;
            System.out.println("Número " + numero + " adicionado na posição vet[" + posicao + "].");
        } else {
            System.out.println("Posição não existe");
        }
        return posicao + 1;

    }
}
