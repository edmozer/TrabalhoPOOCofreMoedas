import java.util.Scanner;

// Classe para selecao da moeda a ser adicionada ao cofrinho
public class MenuSelecaoMoeda {

    private Scanner opcao; // Scanner para entrada do usuario
    private boolean voltarMenuPrincipal; // Flag para indicar se deve retornar ao menu principal

    // Construtor da classe MenuSelecaoMoeda
    public MenuSelecaoMoeda(Scanner scanner) {
        this.opcao = scanner; // Inicializa o Scanner
        this.voltarMenuPrincipal = false; // Inicializa a flag como false
    }

    // Metodo para selecionar a moeda a ser adicionada ao cofrinho
    public Moeda selecionarMoeda() {
        // Exibe as opcoes de moeda disponiveis
        System.out.println("____________________________________");
        System.out.println("Escolha a unidade monetaria:");
        System.out.println("1 - Real (Brasil)");
        System.out.println("2 - Dolar (Estados Unidos)");
        System.out.println("3 - Euro (Europa)");
        System.out.println("4 - Libra Esterlina (Inglaterra)");
        System.out.println("5 - Iene (Japao)");
        System.out.println("6 - Franco Suico (Suica)");
        System.out.println("7 - Yuan (China)");
        System.out.println("8 - Peso Argentino (Argentina)");
        System.out.println("9 - Rublo (Russia)");
        System.out.println("10 - Cancelar e retornar ao menu anterior");

        int opcaoMoeda = opcao.nextInt(); // Le a opcao escolhida pelo usuario

        // Realiza a acao correspondente a opcao escolhida
        switch (opcaoMoeda) {
            case 1:
                return new Real(obterValorMoeda()); // Retorna um objeto Real com o valor informado
            case 2:
                return new Dolar(obterValorMoeda()); // Retorna um objeto Dolar com o valor informado
            case 3:
                return new Euro(obterValorMoeda()); // Retorna um objeto Euro com o valor informado
            case 4:
                return new LibraEsterlina(obterValorMoeda()); // Retorna um objeto LibraEsterlina com o valor informado
            case 5:
                return new Iene(obterValorMoeda()); // Retorna um objeto Iene com o valor informado
            case 6:
                return new FrancoSuico(obterValorMoeda()); // Retorna um objeto FrancoSuico com o valor informado
            case 7:
                return new Yuan(obterValorMoeda()); // Retorna um objeto Yuan com o valor informado
            case 8:
                return new PesoArgentino(obterValorMoeda()); // Retorna um objeto PesoArgentino com o valor informado
            case 9:
                return new Rublo(obterValorMoeda()); // Retorna um objeto Rublo com o valor informado
            case 10:
                voltarMenuPrincipal = true; // Define a flag para retornar ao menu principal
                return null; // Retorna null, indicando cancelamento
            default:
                System.out.println("Opcao Invalida. Tente novamente."); // Mensagem de opcao invalida
                return selecionarMoeda(); // Chama recursivamente o metodo para escolher a moeda
        }
    }

    // Metodo para obter o valor da moeda a ser adicionada
    private double obterValorMoeda() {
        double valor = 0; // Inicializa o valor como 0
        boolean entradaValida = false; // Flag para indicar se a entrada e valida

        // Loop para garantir uma entrada valida
        while (!entradaValida) {
            System.out.println("Digite a quantidade: "); // Solicita ao usuario que digite a quantidade

            if (opcao.hasNextDouble()) { // Verifica se a entrada e um numero
                valor = opcao.nextDouble(); // Le o valor digitado pelo usuario
                entradaValida = true; // Define a flag como true, indicando uma entrada valida
            } else {
                System.out.println("Entrada invalida. Por favor, digite apenas numeros."); // Mensagem de entrada invalida
                opcao.next(); // Limpa o buffer de entrada
            }
        }

        System.out.println("Valor registrado com sucesso."); // Mensagem de sucesso ao registrar o valor
        System.out.println("Redirecionando ao menu principal..."); // Mensagem de redirecionamento ao menu principal
        return valor; // Retorna o valor digitado pelo usuario
    }

    // Metodo para verificar se deve retornar ao menu principal
    public boolean deveRetornarMenuPrincipal() {
        return voltarMenuPrincipal; // Retorna a flag que indica se deve retornar ao menu principal
    }
}
