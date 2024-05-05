import java.util.Scanner;

public class RemoverMoeda {

    private Scanner opcao;
    private Cofrinho cofrinho;

    public RemoverMoeda(Scanner opcao, Cofrinho cofrinho) {
        this.opcao = opcao;
        this.cofrinho = cofrinho;
    }

    public void removerMoeda() {
        if (cofrinho.getListaMoeda().isEmpty()) {
            System.out.println("Não há o que remover.");
            System.out.println("");
            System.out.println("Retornando ao menu principal...");
            System.out.println("");
            return;
        }

        for (int i = 1; i <= cofrinho.getListaMoeda().size(); i++) {
            Moeda moeda = cofrinho.getListaMoeda().get(i - 1);
            System.out.println("ID: " + i);
            moeda.info();
        }

        System.out.println("Selecione a moede de acordo com o ID informado acima dela. Digite o ID da moeda que deseja remover:");
        int indice = opcao.nextInt();

        if (indice < 1 || indice > cofrinho.getListaMoeda().size()) {
            System.out.println("Índice inválido. Tente novamente.");
            removerMoeda();
            return;
        }

        cofrinho.removerMoeda(indice - 1);
        System.out.println("Valor removido com sucesso.");
    }
}
