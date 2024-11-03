import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Criptografia {

    // Tabela de conversão
    static final Map<String, Integer> tabelaConversao = new HashMap<>();
    static {
        tabelaConversao.put("*", 0);
        for (char c = 'A'; c <= 'Z'; c++) {
            tabelaConversao.put(Character.toString(c), c - 'A' + 1);
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
                String letra = matrizPalavra[i][j];
                matrizCodificada[i][j] = tabelaConversao.get(letra);
            }
        }
        return matrizCodificada;
    }

    // Criptografa multiplicando pela matriz de criptografia
    public static int[][] criptografarPalavra(int[][] matrizConvertida) {
        int[][] matrizCriptografada = new int[3][2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    matrizCriptografada[i][j] += matrizCriptografia[i][k] * matrizConvertida[k][j];
                }
            }
        }
        return matrizCriptografada;
    }
}
