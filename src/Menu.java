import java.util.Scanner;

public class Menu {

    private Scanner opcao;
    private Cofrinho cofrinho;

    public Menu() {
        opcao = new Scanner(System.in);
        cofrinho = new Cofrinho(opcao); // Pass Scanner to Cofrinho constructor
    }

    public void telaPrincipal() {
        System.out.println("==================================");
        System.out.println("      BANCO DA QUALIDADE");
        System.out.println("==================================");
        System.out.println("1 - Adicionar valor");
        System.out.println("2 - Remover valor");
        System.out.println("3 - Listar Moedas na conta");
        System.out.println("4 - Calcular valor total disponível convertido para Real");
        System.out.println("5 - Mostrar cotação atual de todas as moedas disponíveis");
        System.out.println("6 - Resetar valores ");
        System.out.println("7 - Finalizar");
        System.out.println("Selecione uma opção: ");

        int selecao = opcao.nextInt();

        switch (selecao) {
            case 1:
                MenuSelecaoMoeda menuSelecaoMoeda = new MenuSelecaoMoeda(opcao);
                Moeda moedaSelecionada = menuSelecaoMoeda.selecionarMoeda();
                if (menuSelecaoMoeda.deveRetornarMenuPrincipal()) {
                    telaPrincipal();
                    return;
                }
                cofrinho.adicionar(moedaSelecionada);
                telaPrincipal();
                break;

            case 2:
                RemoverMoeda removerMoeda = new RemoverMoeda(opcao, cofrinho);
                removerMoeda.removerMoeda();
                telaPrincipal();
                break;

            case 3:
                cofrinho.listagemMoedas();
                telaPrincipal();
                break;

            case 4:
                CalcularValorTotal calculadora = new CalcularValorTotal(cofrinho);
                calculadora.mostrarValorTotal();
                telaPrincipal();
                break;

            case 5:
                cofrinho.CotacaoMoeda();
                telaPrincipal();
                break;

            case 6:
                cofrinho.resetarValores();
                telaPrincipal();
                break;

            case 7:
                System.out.println("Operação encerrada.");
                break;

            default:
                System.out.println("Opção Inválida. Tente novamente.");
                telaPrincipal();
                break;
        }

    }

    private void mostrarCotacaoAtual() {
        System.out.println("Cotação atual de todas as moedas:");
        for (Moeda moeda : cofrinho.getListaMoeda()) {
            System.out.println(moeda.getClass().getSimpleName() + ": " + moeda.converter());
        }
    }
}
