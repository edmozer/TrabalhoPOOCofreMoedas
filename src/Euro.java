public class Euro extends Moeda{

    public Euro(double valorInserido) {
        this.valor = valorInserido;
    }

    public void info() {
        System.out.println("Euro - " + valor);
    }

    public double converter() {
        return this.valor * 5.30;
    }

}