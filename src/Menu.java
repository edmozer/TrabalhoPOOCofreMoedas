import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private Scanner opcao;
    private Cofrinho cofrinho;

    public Menu() {
        opcao = new Scanner(System.in);
        cofrinho = new Cofrinho();
    }

    public void telaPrincipal() {
        System.out.println("COFRE DE MOEDAS:");
        System.out.println("1 - Adicionar Moeda:");
        System.out.println("2 - Remover Moeda");
        System.out.println("3 - Listar Moedas:");
        System.out.println("4 - Calcular valor total convertido para real:");
        System.out.println("5 - Finalizar");

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
                break;

            case 3:
                cofrinho.listagemMoedas();
                telaPrincipal();
                break;

            case 4:
                // Implement functionality for calculating total value
                break;

            case 5:
                System.out.println("Operação encerrada.");
                break;

            default:
                System.out.println("Opção Inválida. Tente novamente.");
                telaPrincipal();
                break;
        }
    }
}
