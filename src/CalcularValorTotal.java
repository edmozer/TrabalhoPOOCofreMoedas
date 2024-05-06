public class CalcularValorTotal {

    // Declaracao de um objeto da classe Cofrinho
    private Cofrinho cofrinho;

    // Metodo construtor que recebe um objeto Cofrinho como parametro
    public CalcularValorTotal(Cofrinho cofrinho) {
        this.cofrinho = cofrinho;
    }

    // Metodo que calcula o valor total das moedas no cofrinho
    public double calcularValorTotal() {
        double valorTotal = 0;
        // Laco de repeticao para iterar sobre a lista de moedas no cofrinho
        for (Moeda moeda : cofrinho.getListaMoeda()) {
            // Acumula o valor convertido de cada moeda ao valor total
            valorTotal += moeda.converter();
        }

        return valorTotal; // Retorna o valor total calculado
    }

    // Metodo que exibe o valor total formatado em reais e uma mensagem
    public void mostrarValorTotal() {
        double valorTotal = calcularValorTotal(); // Calcula o valor total
        // Formata o valor total com duas casas decimais
        String valorFormatado = String.format("%.2f", valorTotal);
        // Exibe o valor total formatado em reais junto com uma mensagem
        System.out.println("Valor total em reais é: R$ " + valorFormatado);
        System.out.println("");
        System.out.println("Retornando ao menu principal...");
        System.out.println("");
    }
}
