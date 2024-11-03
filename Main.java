

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
        int[][] matrizDescriptografada = Descriptografia.Descriptografar(matrizCriptografada);
        String Palavra = Descriptografia.decodificarMatriz(matrizDescriptografada);
        System.out.println(Palavra);


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

/*public static void menu() {
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
    }/*/