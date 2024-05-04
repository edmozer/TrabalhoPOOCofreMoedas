
import java.util.ArrayList;


public class Cofrinho {private ArrayList<Moeda> listaMoeda;

    public Cofrinho() {
        this.listaMoeda = new ArrayList<>();
    }

    public void adicionar(Moeda moeda) {
        this.listaMoeda.add(moeda);

    }

    public void listagemMoedas() {
        for (Moeda moeda : this.listaMoeda) {
            moeda.info();
        }
    }
}
