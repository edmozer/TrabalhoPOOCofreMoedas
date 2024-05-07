import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Cofrinho {

    // Lista de moedas no cofrinho
    private ArrayList<Moeda> listaMoeda;
    // Scanner para entrada de dados
    private Scanner scanner;

    // Construtor que recebe um objeto Scanner como argumento
    public Cofrinho(Scanner scanner) {
        this.listaMoeda = new ArrayList<>();
        this.scanner = scanner;
    }

    // Metodo para adicionar uma moeda ao cofrinho
    public void adicionar(Moeda moeda) {
        this.listaMoeda.add(moeda);
    }

    // Metodo para listar as moedas no cofrinho
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

    // Metodo para resetar os valores no cofrinho
    public void resetarValores() {
        listaMoeda.clear();
        System.out.println("Deseja enviar todos valores para uma conta em um Paraíso Fiscal? (S/N)");
        String opcao = scanner.next();
        if (opcao.equalsIgnoreCase("S")) {
            System.out.println("Todos os valores foram enviados para ********.");
            System.out.println("Seu dinheiro está fora do alcance da Receita Federal.");
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

    // Metodo para obter a lista de moedas
    public ArrayList<Moeda> getListaMoeda() {
        return listaMoeda;
    }

    // Metodo para obter a cotação de moedas
    public void CotacaoMoeda() {
        CotacaoMoeda cotacaoMoeda = new CotacaoMoeda();
        cotacaoMoeda.mostrarCotacaoAtual();
    }

    // Metodo para remover uma moeda do cofrinho com base no indice
    public void removerMoeda(int indice) {
        listaMoeda.remove(indice);
    }
}
