public class ExemploVetor {
    public static void main(String[] args) {
        new ExemploVetor();
    }
     int[] numeros = new int[5];
    private ExemploVetor(){
        getValores();
        imprimirValores();
        randomizarValores();
        imprimirValores();
    }
        
    private void randomizarValores() {
        for(int i = 0; i < numeros.length; i++){
            numeros[i] = (int)(Math.random() * 10);
        }
    }
        
    private void getValores() {
        numeros[0] = 1;
        numeros[1] = 2;
        numeros[2] = 3;
        numeros[3] = 4;
        numeros[4] = 5;
    }

    private void imprimirValores(){
        for(int i = 0; i < numeros.length; i++){
            System.out.println(numeros[i]);
        }
    }
}
