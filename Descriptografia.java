import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



//Começando a revelar os segredos
public class Descriptografia {

    static final int[][] matrizDescriptografia = {
        {3, -2, 1},
        {-1, 1, 0},
        {-2, 2, -1}
    };
    
    static final Map<Integer, String> tabelaConversaoInvertida = new HashMap<>();
    static {
        tabelaConversaoInvertida.put(0, "*");
        for (char c = 'A'; c <= 'Z'; c++) {
            tabelaConversaoInvertida.put(c - 'A' + 1, Character.toString(c));
        }
    }

    public static int[][] lerMatriz() {
        int[][] matrizCriptografada = new int[3][2];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite os elementos da matriz criptografada (3x2):");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("Elemento [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrizCriptografada[i][j] = scanner.nextInt();
                scanner.nextLine();
            }
        }
        return matrizCriptografada;
    }

   
   //Descriptografia
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

    //Decodificando a Matriz
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


    public static String descriptografar() {
        int[][] matrizCriptografada = lerMatriz();
        int[][] matrizDescriptografada = Descriptografia.descriptografarMatriz(matrizCriptografada);
        String Palavra = Descriptografia.decodificarMatriz(matrizDescriptografada);
        return Palavra;
    }

/*public class CriptografiaDescriptografia {
    static Map<Character, Integer> tabelaConversao = new HashMap<>();
    static Map<Integer, Character> tabelaConversaoInvertida = new HashMap<>();
    static SimpleMatrix matrizCriptografia = new SimpleMatrix(new double[][]{{1, 0, 1}, {1, 1, 1}, {0, 2, -1}});
    static SimpleMatrix matrizCriptografiaInversa = matrizCriptografia.invert();

    static {
        // Inicializando a tabela de conversão e sua inversa
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ*";
        for (int i = 0; i < letras.length(); i++) {
            tabelaConversao.put(letras.charAt(i), i + 1);
            tabelaConversaoInvertida.put(i + 1, letras.charAt(i));
        }
    }

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("[1] Criptografar\n[2] Descriptografar\n[0] Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    criptografar(scanner);
                    break;
                case 2:
                    descriptografar(scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void criptografar(Scanner scanner) {
        System.out.print("Digite uma palavra de 6 letras: ");
        String palavra = scanner.nextLine().toUpperCase();

        if (palavra.length() != 6 || !palavra.matches("[A-Z]*")) {
            System.out.println("A palavra deve conter exatamente 6 letras e sem caracteres especiais.");
            return;
        }

        double[][] matrizCodificada = converterPalavra(palavra);
        SimpleMatrix matrizConvertida = new SimpleMatrix(matrizCodificada);
        SimpleMatrix matrizCriptografada = matrizCriptografia.mult(matrizConvertida);

        System.out.println("Palavra digitada: " + palavra);
        System.out.println("Matriz codificada:\n" + Arrays.deepToString(matrizCodificada));
        System.out.println("Matriz criptografada:\n" + matrizCriptografada);
    }

    public static void descriptografar(Scanner scanner) {
        double[][] matrizCriptografada = new double[3][2];

        System.out.println("Digite os elementos da matriz criptografada (3x2):");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("Elemento [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrizCriptografada[i][j] = scanner.nextDouble();
            }
        }

        SimpleMatrix matrizInput = new SimpleMatrix(matrizCriptografada);
        SimpleMatrix matrizDescriptografada = matrizCriptografiaInversa.mult(matrizInput);

        // Arredonda os valores para inteiros
        double[][] matrizDescriptografadaInteiros = new double[3][2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                matrizDescriptografadaInteiros[i][j] = Math.round(matrizDescriptografada.get(i, j));
            }
        }

        String mensagemOriginal = decodificarMatriz(matrizDescriptografadaInteiros);

        System.out.println("Matriz criptografada:\n" + matrizInput);
        System.out.println("Matriz descriptografada:\n" + Arrays.deepToString(matrizDescriptografadaInteiros));
        System.out.println("Mensagem original: " + mensagemOriginal);
    }

    public static double[][] converterPalavra(String palavra) {
        double[][] matrizCodificada = new double[3][2];
        int contador = 0;

        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 3; i++) {
                char letra = palavra.charAt(contador++);
                matrizCodificada[i][j] = tabelaConversao.get(letra);
            }
        }
        return matrizCodificada;
    }

    public static String decodificarMatriz(double[][] matrizDescriptografada) {
        StringBuilder palavra = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
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
}

 */
    }
