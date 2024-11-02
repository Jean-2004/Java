

public class Main {
    public static void main(String[] args) {
        /*for (int i = 0; i < 27; i++ ) {
            System.out.println(tabelaConversao[i]);
        }*/

        /*Enumeration<String> k = tabelaConversao.keys();
        while (k.hasMoreElements()) {
            String key = k.nextElement();
            System.out.println("Key: " + key + ", Value: "
                               + tabelaConversao.get(key));
         }*/

                               
        String palavra = Criptografia.lerPalavra();
        String[][] matrizPalavra = Criptografia.criarMatrizPalavra(palavra);

        int[][] matrizCodificada = Criptografia.converterPalavra(matrizPalavra);
        int[][] matrizCriptografada = Criptografia.criptografarPalavra(matrizCodificada);

        // Exibindo matriz criptografada
        System.out.println("Matriz Criptografada:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matrizCriptografada[i][j] + " ");
            }
            System.out.println();
        }
    }
}