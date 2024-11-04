import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();

        /*for (int i = 0; i < 27; i++ ) {
            System.out.println(tabelaConversao[i]);
        }*/

        /*Enumeration<String> k = tabelaConversao.keys();
        while (k.hasMoreElements()) {
            String key = k.nextElement();
            System.out.println("Key: " + key + ", Value: "
                               + tabelaConversao.get(key));
         }*/

                               
        

        /*int[][] matrizDescriptografada = Descriptografia.Descriptografar(matrizCriptografada);
        String Palavra = Descriptografia.decodificarMatriz(matrizDescriptografada);
        System.out.println(Palavra);*/


        /*// Exibe matriz criptografada
        System.out.println("Matriz Criptografada:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matrizCriptografada[i][j] + " ");
            }
            System.out.println();
        }*/
    }

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();  
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("[1] Criptografar\n[2] Descriptografar\n[0] Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir uma linha
            switch (opcao) {
                case 1:
                    int[][] matrizCriptografada = Criptografia.criptografar();
                    System.out.println("Matriz Criptografada:");
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 2; j++) {
                            System.out.print(matrizCriptografada[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    String Palavra = Descriptografia.descriptografar();
                    System.out.println(Palavra);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            String x = scanner.nextLine();
            clear();
        }
    }
}

