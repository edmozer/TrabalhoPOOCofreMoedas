import java.util.Scanner;

public class Menu {

    private Scanner opcao;
    private Cofrinho cofrinho;

    public Menu() {
        opcao = new Scanner(System.in);
        cofrinho = new Cofrinho();
    }

    public void telaPrincipal() {
        System.out.println("COFRINHO:");
        System.out.println("1- Adicionar Moeda:");
        System.out.println("2- Remover Moeda");
        System.out.println("3- Listar Moedas:");
        System.out.println("4- Calcular valor total convertido para real:");
        System.out.println("5- Encerrar");

        int selecao = opcao.nextInt();

        switch(selecao) {
            case 1:
                System.out.println("Escolha a moeda:");
                System.out.println("1- Real:");
                System.out.println("2- Dolar:");
                System.out.println("3- Euro:");
                int opcaoMoeda = opcao.nextInt();

                System.out.println("Digite  o valor: ");
                double valorMoeda = opcao.nextDouble();

                Moeda moeda = null;

                if (opcaoMoeda == 1) {
                    moeda = new Real(valorMoeda);

                }else if (opcaoMoeda ==2) {
                    moeda	= new Dollar(valorMoeda);

                }else if (opcaoMoeda == 3) {
                    moeda = new Euro(valorMoeda);

                }else {
                    System.out.println("Opcao Invalida");
                    telaPrincipal();
                }

                cofrinho.adicionar(moeda);
                telaPrincipal();
                break;

            case 2:
                break;

            case 3:
                cofrinho.listagemMoedas();
                telaPrincipal();
                break;

            case 4:
                break;

            case 5:
                System.out.println("Programa encerrado");
                break;

            default:
                System.out.println("Opcao Invalida");
                telaPrincipal();
                break;
        }


    }
}