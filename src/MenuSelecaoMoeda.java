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
        System.out.println("1 - Real (Brasil)");
        System.out.println("2 - Dólar (Estados Unidos)");
        System.out.println("3 - Euro (Europa)");
        System.out.println("4 - Libra Esterlina (Inglaterra)");
        System.out.println("5 - Iene (Japão)");
        System.out.println("6 - Franco Suíço (Suíça)");
        System.out.println("7 - Yuan (China)");
        System.out.println("8 - Peso Argentino (Argentina)");
        System.out.println("9 - Rublo (Rússia)");
        System.out.println("10 - Retornar ao menu anterior");

        int opcaoMoeda = opcao.nextInt();

        switch (opcaoMoeda) {
            case 1:
                return new Real(obterValorMoeda());
            case 2:
                return new Dolar(obterValorMoeda());
            case 3:
                return new Euro(obterValorMoeda());
            case 4:
                return new LibraEsterlina(obterValorMoeda());
            case 5:
                return new Iene(obterValorMoeda());
            case 6:
                return new FrancoSuico(obterValorMoeda());
            case 7:
                return new Yuan(obterValorMoeda());
            case 8:
                return new PesoArgentino(obterValorMoeda());
            case 9:
                return new Rublo(obterValorMoeda());
            case 10:
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
