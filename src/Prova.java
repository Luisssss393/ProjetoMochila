public class Prova {

    // 1. Método 'teste' movido para fora do 'main' e tornado 'static'
    //    para que possa ser chamado diretamente do método principal.
    private static void teste(int[] vetor, int tamanho, int numero){
        int aux = 0;
        for(int i = 0; i < tamanho; i++){
            for(int j = 0; j < i; j++){
                // 2. 'vet' corrigido para 'vetor' para referenciar o parâmetro correto.
                aux = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = aux;
            }
            numero++; // 3. Ponto e vírgula adicionado para finalizar a instrução.
        }
    }

    public static void main(String[] args) {
        // 4. Declaração de array corrigida para a sintaxe padrão do Java.
        int[] vetor = {10, 5, 3, 8, 9};
        int numero = vetor.length; // 'numero' será 5

        // 5. Chamada do método 'teste' sem atribuição, pois ele é 'void'
        //    (não retorna nenhum valor).
        teste(vetor, 5, numero);

        System.out.println("Vetor após o método teste (embaralhado):");
        for (int valor : vetor) {
            System.out.print(valor + " ");
        }
        System.out.println("\nValor de 'numero' no main (inalterado): " + numero);
    }
}