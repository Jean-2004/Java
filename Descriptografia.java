import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Descriptografia {
    // Matriz inversa de descriptografia
    static final int[][] matrizDescriptografia = {
        {3, -2, 1},
        {-1, 1, 0},
        {-2, 2, -1}
    };
    // Tabela de conversão com o número como chave e a letra como valor
    static final Map<Integer, String> tabelaConversaoInvertida = new HashMap<>();
    static {
        tabelaConversaoInvertida.put(0, "*");
        for (char c = 'A'; c <= 'Z'; c++) {
            tabelaConversaoInvertida.put(c - 'A' + 1, Character.toString(c));
        }
    }

    // Lê uma matriz inserida
    public static int[][] lerMatriz() {
        int[][] matrizCriptografada = new int[3][2];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite os elementos da matriz criptografada (3x2):");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("Elemento [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrizCriptografada[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }
        return matrizCriptografada;
    }

   
   // Descriptografa a matriz através de uma multiplicação de matrizes
    public static int[][] descriptografarMatriz(int[][] matrizCriptografada) {
        int[][] matrizDescriptografada = new int[3][2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    matrizDescriptografada[i][j] += matrizDescriptografia[i][k] * matrizCriptografada[k][j];
                }
            }
        }
        return matrizDescriptografada;
    }

    // Converte numéros em letras de acordo com a tabela de conversão
    public static String decodificarMatriz(int[][] matrizDescriptografada) {
        StringBuilder palavra = new StringBuilder();

        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 3; i++) {
                int valor = (int) matrizDescriptografada[i][j];
                if (tabelaConversaoInvertida.containsKey(valor)) {
                    palavra.append(tabelaConversaoInvertida.get(valor));
                } else {
                    palavra.append("*");
                }
            }
        }
        return palavra.toString();
    }

    // Realiza todas as funções
    public static String descriptografar() {
        int[][] matrizCriptografada = lerMatriz();
        int[][] matrizDescriptografada = Descriptografia.descriptografarMatriz(matrizCriptografada);
        String Palavra = Descriptografia.decodificarMatriz(matrizDescriptografada);
        return Palavra;
    }
}
