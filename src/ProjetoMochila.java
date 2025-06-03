import java.util.Scanner;

public class ProjetoMochila {

    private String[] nomesDosItens;
    private int[] pesosDosItens;
    private int pesoQueAguenta;
    private int pesoAtualNaMochila;
    private int quantosItensTem;

    public void menuPrincipal() {
        Scanner leitor = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("\n------- Menu ----------");
            System.out.println("1. Inserir algo na mochila");
            System.out.println("2. Imprimir mochila");
            System.out.println("3. Ver item mais pesado");
            System.out.println("4. Organizar mochila por peso");
            System.out.println("5. Excluir item da mochula");
            System.out.println("0. Sair");
            System.out.print("Digite o número para escolher alguma opção acima: ");

            if (leitor.hasNextInt()) {
                escolha = leitor.nextInt();
            } else {
                System.out.println("Opção inválida. Tente novamente");
                leitor.next();
                escolha = -1;
                continue;
            }
            leitor.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Qual o nome do item? ");
                    String nome = leitor.nextLine();
                    System.out.print("Qual o peso desse item (em kg)? ");
                    int peso;
                    if (leitor.hasNextInt()) {
                        peso = leitor.nextInt();
                        leitor.nextLine();
                        inserir(nome, peso);
                    } else {
                        System.out.println("Peso inválido. Digite um número inteiro para o peso.");
                        leitor.next();
                    }
                    break;
                case 2:
                    imprimirMochila();
                    break;
                case 3:
                    System.out.println(valorItemMaisPesado());
                    break;
                case 4:
                    ordernarMochila();
                    break;
                case 5:
                    System.out.print("Qual o nome do item que você quer tirar? ");
                    String itemParaExcluir = leitor.nextLine();
                    excluirItemMochila(itemParaExcluir);
                    break;
                case 0:
                    System.out.println("Obrigado e volte sempre!");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");
            }
        } while (escolha != 0);

        leitor.close(); // Fecha a ferramenta de leitura quando você sai do programa
    }

    public ProjetoMochila(int capacidadeMax) {
        this.pesoQueAguenta = capacidadeMax;

        this.nomesDosItens = new String[capacidadeMax];
        this.pesosDosItens = new int[capacidadeMax];
        this.pesoAtualNaMochila = 0;
        this.quantosItensTem = 0;
        menuPrincipal();
    }

    public void inserir(String nome, int peso) {

        if (quantosItensTem >= nomesDosItens.length) {
            System.out.println("A mochila já está cheia!");
            return;
        }

        if (pesoAtualNaMochila + peso > pesoQueAguenta) {
            System.out.println("Esse item (" + peso + "kg) é muito pesado!!");
            return;
        }

        nomesDosItens[quantosItensTem] = nome;
        pesosDosItens[quantosItensTem] = peso;
        pesoAtualNaMochila += peso;
        quantosItensTem++;
        System.out.println("'" + nome + "' (" + peso + "kg) adicionado! o pesoa tual é: " + pesoAtualNaMochila + "kg");
    }

    public void imprimirMochila() {
        if (quantosItensTem == 0) {
            System.out.println("A mochila está vazia");
            return;
        }
        System.out.println("\n--- Os itens na mochila (do último para o primeiro) ---");
        for (int i = quantosItensTem - 1; i >= 0; i--) {
            System.out.println("- " + nomesDosItens[i] + " (" + pesosDosItens[i] + "kg.)");
        }
    }

    public String valorItemMaisPesado() {
        if (quantosItensTem == 0) {
            return "A mochila esta vazia";
        }

        int posicaoDoMaisPesado = 0;
        int maiorPesoEncontrado = pesosDosItens[0];

        for (int i = 1; i < quantosItensTem; i++) {
            if (pesosDosItens[i] > maiorPesoEncontrado) {
                maiorPesoEncontrado = pesosDosItens[i];
                posicaoDoMaisPesado = i;
            }
        }
        return "O item mais pesado é: '" + nomesDosItens[posicaoDoMaisPesado] + "' com " + maiorPesoEncontrado + "kg.";
    }

    public void ordernarMochila() {
        if (quantosItensTem <= 1) {
            System.out.println("Só tem um item ou nenhum");
            return;
        }

        for (int i = 0; i < quantosItensTem - 1; i++) {
            for (int j = 0; j < quantosItensTem - 1 - i; j++) {
                if (pesosDosItens[j] > pesosDosItens[j + 1]) {
                    int pesoTemporario = pesosDosItens[j];
                    pesosDosItens[j] = pesosDosItens[j + 1];
                    pesosDosItens[j + 1] = pesoTemporario;

                    String nomeTemporario = nomesDosItens[j];
                    nomesDosItens[j] = nomesDosItens[j + 1];
                    nomesDosItens[j + 1] = nomeTemporario;
                }
            }
        }
        System.out.println("Mochila organizada por peso (do mais leve para o mais pesado).");

        System.out.println("\n--- Itens na Mochila (Organizados por Peso) ---");
        for (int i = 0; i < quantosItensTem; i++) {
            System.out.println("- " + nomesDosItens[i] + " (" + pesosDosItens[i] + "kg)");
        }
        System.out.println("----------------------------------------------");
    }

    public void excluirItemMochila(String nomeDoItemParaExcluir) {
        if (quantosItensTem == 0) {
            System.out.println("A mochila está vazia");
            return;
        }

        int posicaoEncontrada = -1;
        for (int i = 0; i < quantosItensTem; i++) {
            if (nomesDosItens[i] != null && nomesDosItens[i].equalsIgnoreCase(nomeDoItemParaExcluir)) {
                posicaoEncontrada = i;
                break;
            }
        }

        if (posicaoEncontrada == -1) {
            System.out.println("Esse item não está na mochila!!");
            return;
        }

        int pesoRemovido = pesosDosItens[posicaoEncontrada];

        for (int i = posicaoEncontrada; i < quantosItensTem - 1; i++) {
            nomesDosItens[i] = nomesDosItens[i + 1];
            pesosDosItens[i] = pesosDosItens[i + 1];
        }

        nomesDosItens[quantosItensTem - 1] = null;
        pesosDosItens[quantosItensTem - 1] = 0;

        pesoAtualNaMochila -= pesoRemovido;
        quantosItensTem--;
        System.out.println("Item '" + nomeDoItemParaExcluir + "' (" + pesoRemovido + "kg) removido");
    }

    public static void main(String[] args) {
        Scanner entradaInicial = new Scanner(System.in);
        System.out.print("Olá, qual o peso máximo (em kg) que sua mochila pode carregar?");
        int capacidadeDaMochila;

        if (entradaInicial.hasNextInt()) {
            capacidadeDaMochila = entradaInicial.nextInt();
            if (capacidadeDaMochila <= 0) {
                System.out.println("Valor inválido!");
                entradaInicial.close();
                return;
            }
        } else {
            System.out.println("Valor inválidp!");
            entradaInicial.close();
            return;
        }
        entradaInicial.nextLine();

        ProjetoMochila minhaMochila = new ProjetoMochila(capacidadeDaMochila);
        int i = 0;
        entradaInicial.close();
    }
}