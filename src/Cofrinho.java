import java.util.ArrayList;
import java.util.Scanner;

public class Cofrinho {

    private ArrayList<Moeda> listaMoeda;
    private Scanner scanner;

    public Cofrinho(Scanner scanner) { // Constructor with Scanner argument
        this.listaMoeda = new ArrayList<>();
        this.scanner = scanner;
    }

    public void adicionar(Moeda moeda) {
        this.listaMoeda.add(moeda);
    }

    public void listagemMoedas() {
        if (listaMoeda.isEmpty()) {
            System.out.println("Não existem valores registrados.");
            System.out.println("");
            System.out.println("Redirecionando ao menu principal");
            System.out.println("");
            return;
        }
        for (int i = 0; i < listaMoeda.size(); i++) {
            int id = i + 1;
            System.out.println("ID da unidade monetária: " + id);
            listaMoeda.get(i).info();
        }
    }


    public void resetarValores() {
        listaMoeda.clear();
        System.out.println("Deseja enviar todos valores para uma conta em um Paraíso Fiscal? (S/N)");
        String opcao = scanner.next();
        if (opcao.equalsIgnoreCase("S")) {
            System.out.println("Todos os valores foram enviados para ********. Seu dinheiro está fora do alcance da Receita Federal.");
            System.out.println("");
            System.out.println("Retornando ao menu principal...");
            System.out.println("");
        } else {
            System.out.println("Os valores permanecem no sistema.");
            System.out.println("");
            System.out.println("Retornando ao menu principal...");
            System.out.println("");
        }
    }

    public ArrayList<Moeda> getListaMoeda() {
        return listaMoeda;
    }

    public void CotacaoMoeda() {
        CotacaoMoeda cotacaoMoeda = new CotacaoMoeda();
        cotacaoMoeda.mostrarCotacaoAtual();
    }

    public void removerMoeda(int indice) {
        listaMoeda.remove(indice);
    }
}