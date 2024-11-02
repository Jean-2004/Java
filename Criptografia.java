import java.util.Scanner;
import java.util.Arrays;  

public class Criptografia {

    // Tabela de conversão
    static final String[] tabelaConversao = new String[27];
    static {
        tabelaConversao[0] = "*";
        for (char c = 'A'; c <= 'Z'; c++) {
            tabelaConversao[c - 'A' + 1] = Character.toString(c);
        }
    }

    // Matriz de criptografia
    static final int[][] matrizCriptografia = {
        {1, 0, 1},
        {1, 1, 1},
        {0, 2, -1}
    };


     // Lê a palavra de entrada
    public static String lerPalavra() {
        Scanner scanner = new Scanner(System.in);
        String palavra;
        while (true) {
            System.out.print("Digite uma palavra de 6 letras: ");
            palavra = scanner.nextLine().toUpperCase();

            if (palavra.matches("[A-Z]{6}")) {
                break;
            } else {
                System.out.println("A palavra deve conter apenas 6 letras.");
            }
        }
        scanner.close();
        return palavra;
    }
    

    public static void main(String[] args) {
        /*for (int i = 0; i < 27; i++ ) {
            System.out.println(tabelaConversao[i]);
        }*/
        String palavra = lerPalavra();
        String[][] matrizPalavra = criarMatrizPalavra(palavra);
        System.out.println(Arrays.deepToString(matrizPalavra));

        /*int[][] matrizCodificada = converterPalavra(matrizPalavra);
        int[][] matrizCriptografada = criptografarPalavra(matrizCodificada);

        // Exibindo matriz criptografada
        System.out.println("Matriz Criptografada:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matrizCriptografada[i][j] + " ");
            }
            System.out.println();
        }*/
    }

   

    // Cria matriz de letras da palavra de entrada
    public static String[][] criarMatrizPalavra(String palavra) {
        String[][] matrizPalavra = new String[3][2];
        int contador = 0;
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 3; i++) {
                matrizPalavra[i][j] = String.valueOf(palavra.charAt(contador++));
            }
        }
        return matrizPalavra;
    }

    // Converte letras em números de acordo com a tabela de conversão
    public static int[][] converterPalavra(String[][] matrizPalavra) {
        int[][] matrizCodificada = new int[3][2];
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 3; i++) {
                char letra = matrizPalavra[i][j].charAt(0);
                matrizCodificada[i][j] = tabelaConversao[letra - 'A'];
            }
        }
        return matrizCodificada;
    }

    // Criptografa multiplicando pela matriz de criptografia
    public static int[][] criptografarPalavra(int[][] matrizConvertida) {
        int[][] matrizCriptografada = new int[3][2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                matrizCriptografada[i][j] = 0;
                for (int k = 0; k < 3; k++) {
                    matrizCriptografada[i][j] += matrizCriptografia[i][k] * matrizConvertida[k][j];
                }
            }
        }
        return matrizCriptografada;
    }
}
