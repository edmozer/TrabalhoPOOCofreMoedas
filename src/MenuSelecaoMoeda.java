import java.util.Scanner;

public class MenuSelecaoMoeda {

    private Scanner opcao;
    private boolean voltarMenuPrincipal;

    public MenuSelecaoMoeda(Scanner scanner) {
        this.opcao = scanner;
        this.voltarMenuPrincipal = false;
    }

    public Moeda selecionarMoeda() {
        System.out.println("Escolha a unidade monetária:");
        System.out.println("1- Real:");
        System.out.println("2- Dólar:");
        System.out.println("3- Euro:");
        System.out.println("4- Retornar ao menu anterior");

        int opcaoMoeda = opcao.nextInt();

        switch (opcaoMoeda) {
            case 1:
                return new Real(obterValorMoeda());
            case 2:
                return new Dollar(obterValorMoeda());
            case 3:
                return new Euro(obterValorMoeda());
            case 4:
                voltarMenuPrincipal = true;
                return null;
            default:
                System.out.println("Opção Inválida. Tente novamente.");
                return selecionarMoeda();
        }
    }

    private double obterValorMoeda() {
        System.out.println("Digite a quantidade: ");
        return opcao.nextDouble();
    }

    public boolean deveRetornarMenuPrincipal() {
        return voltarMenuPrincipal;
    }
}
