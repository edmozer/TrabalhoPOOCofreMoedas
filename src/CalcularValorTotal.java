public class CalcularValorTotal {

    private Cofrinho cofrinho;

    public CalcularValorTotal(Cofrinho cofrinho) {
        this.cofrinho = cofrinho;
    }

    public double calcularValorTotal() {
        double valorTotal = 0;
        for (Moeda moeda : cofrinho.getListaMoeda()) {
            valorTotal += moeda.converter();
        }

        return valorTotal;
    }

    public void mostrarValorTotal() {
        double valorTotal = calcularValorTotal();
        String valorFormatado = String.format("%.2f", valorTotal);
        System.out.println("Valor total em reais é: R$ " + valorFormatado);
        System.out.println("");
        System.out.println("Retornando ao menu principal...");
        System.out.println("");
    }
}
