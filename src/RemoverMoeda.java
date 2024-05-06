import java.util.Scanner;

// Classe para remocao de moedas do cofrinho
public class RemoverMoeda {

    private Scanner opcao; // Scanner para entrada do usuario
    private Cofrinho cofrinho; // Objeto Cofrinho para gerenciar moedas

    // Construtor da classe RemoverMoeda
    public RemoverMoeda(Scanner opcao, Cofrinho cofrinho) {
        this.opcao = opcao; // Inicializa o Scanner
        this.cofrinho = cofrinho; // Inicializa o objeto Cofrinho
    }

    // Método para remover uma moeda do cofrinho
    public void removerMoeda() {
        // Verifica se o cofrinho esta vazio
        if (cofrinho.getListaMoeda().isEmpty()) {
            System.out.println("Não há o que remover."); // Mensagem se não houver moedas no cofrinho
            System.out.println("");
            System.out.println("Retornando ao menu principal...");
            System.out.println("");
            return;
        }

        // Exibe as moedas presentes no cofrinho com seus respectivos IDs
        for (int i = 1; i <= cofrinho.getListaMoeda().size(); i++) {
            Moeda moeda = cofrinho.getListaMoeda().get(i - 1);
            System.out.println("ID: " + i);
            moeda.info(); // Mostra informacoes da moeda
        }

        // Solicita ao usuario o ID da moeda que deseja remover
        System.out.println("Selecione a moeda de acordo com o ID informado acima dela. Digite o ID da moeda que deseja remover:");
        int indice = opcao.nextInt();

        // Verifica se o índice informado e valido
        if (indice < 1 || indice > cofrinho.getListaMoeda().size()) {
            System.out.println("Índice inválido. Tente novamente."); // Mensagem se o indice for invalido
            removerMoeda(); // Chama novamente o metodo para remover uma moeda
            return;
        }

        // Remove a moeda do cofrinho com base no indice informado
        cofrinho.removerMoeda(indice - 1);
        System.out.println("Valor removido com sucesso."); // Mensagem de sucesso ao remover a moeda
    }
}
