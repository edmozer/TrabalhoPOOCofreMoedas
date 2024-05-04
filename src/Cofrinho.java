import java.util.ArrayList;

public class Cofrinho {

    private ArrayList<Moeda> listaMoeda;

    public Cofrinho() {
        this.listaMoeda = new ArrayList<>();
    }

    public void adicionar(Moeda moeda) {
        this.listaMoeda.add(moeda);
    }

    public void listagemMoedas() {
        if (listaMoeda.isEmpty()) {
            System.out.println("O cofrinho está vazio.");
            return;
        }
        for (int i = 0; i < listaMoeda.size(); i++) {
            System.out.println("Índice: " + i);
            listaMoeda.get(i).info();
        }
    }

    public ArrayList<Moeda> getListaMoeda() {
        return listaMoeda;
    }

    public void removerMoeda(int indice) {
        listaMoeda.remove(indice);
    }
}