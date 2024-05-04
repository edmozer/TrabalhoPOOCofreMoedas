public class Real extends Moeda{

    public Real(double valorInserido) {
        this.valor = valorInserido;
    }

    public void info() {
        System.out.println("Real - " + valor);
    }

    public double converter() {
        return this.valor;

    }

}