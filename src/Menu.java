import java.util.Scanner;

// A classe Menu representa o menu principal da aplicacao
public class Menu {

    private Scanner opcao; // Scanner para entrada do usuario
    private Cofrinho cofrinho; // Objeto Cofrinho para gerenciar moedas

    // Construtor da classe Menu
    public Menu() {
        opcao = new Scanner(System.in); // Inicializa o Scanner
        cofrinho = new Cofrinho(opcao); // Inicializa o objeto Cofrinho
    }

    // Metodo para exibir o menu principal
    public void telaPrincipal() {
        // Exibe o cabecalho do menu
        System.out.println("==================================");
        System.out.println("        BANCO DA QUALIDADE");
        System.out.println("==================================");
        // Mostra as opcoes do menu
        System.out.println("1 - Adicionar valor");
        System.out.println("2 - Remover valor");
        System.out.println("3 - Listar Moedas na conta");
        System.out.println("4 - Calcular valor total disponível convertido para Real");
        System.out.println("5 - Mostrar cotação atual de todas as moedas disponíveis");
        System.out.println("6 - Resetar valores ");
        System.out.println("7 - Finalizar");
        System.out.println("Selecione uma opção: ");

        // Le a opção selecionada pelo usuario
        int selecao = opcao.nextInt();

        // Executa a acao correspondente a opçao selecionada
        switch (selecao) {
            case 1:
                // Adicionar valor - Chama o menu para seleçao de moeda e adiciona ao cofrinho
                MenuSelecaoMoeda menuSelecaoMoeda = new MenuSelecaoMoeda(opcao);
                Moeda moedaSelecionada = menuSelecaoMoeda.selecionarMoeda();
                if (menuSelecaoMoeda.deveRetornarMenuPrincipal()) {
                    telaPrincipal(); // Retorna ao menu principal se necessário
                    return;
                }
                cofrinho.adicionar(moedaSelecionada); // Adiciona a moeda selecionada ao cofrinho
                telaPrincipal(); // Retorna ao menu principal
                break;

            case 2:
                // Remover valor - Remove uma moeda do cofrinho
                RemoverMoeda removerMoeda = new RemoverMoeda(opcao, cofrinho);
                removerMoeda.removerMoeda();
                telaPrincipal(); // Retorna ao menu principal
                break;

            case 3:
                // Listar Moedas na conta - Lista todas as moedas no cofrinho
                cofrinho.listagemMoedas();
                telaPrincipal(); // Retorna ao menu principal
                break;

            case 4:
                // Calcular valor total - Calcula e mostra o valor total das moedas em Real
                CalcularValorTotal calculadora = new CalcularValorTotal(cofrinho);
                calculadora.mostrarValorTotal();
                telaPrincipal(); // Retorna ao menu principal
                break;

            case 5:
                // Mostrar cotação atual - Mostra a cotaçao atual de todas as moedas disponiveis
                cofrinho.CotacaoMoeda();
                telaPrincipal(); // Retorna ao menu principal
                break;

            case 6:
                // Resetar valores - Reseta todas as moedas no cofrinho
                cofrinho.resetarValores();
                telaPrincipal(); // Retorna ao menu principal
                break;

            case 7:
                System.out.println("Operação encerrada."); // Mensagem de encerramento
                break;

            default:
                System.out.println("Opção Inválida. Tente novamente."); // Mensagem de opção invalida
                telaPrincipal(); // Retorna ao menu principal
                break;
        }

    }
}
