public class Dollar extends Moeda{

    public Dollar(double valorInserido) {
        this.valor = valorInserido;
    }

    public void info() {
        System.out.println("Dolar - " + valor);
    }

    public double converter() {
        return this.valor * 5.10;
    }

}