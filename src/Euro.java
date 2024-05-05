import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Euro extends Moeda {
    private static final String URL_API = "https://api.exchangerate-api.com/v4/latest/EUR";
    private static double taxaDeConversao;

    public Euro(double valorInserido) {
        this.valor = valorInserido;
    }

    public void info() {
        System.out.println("Euro - " + valor);
    }

    // Método para buscar a taxa de conversão atual do Euro usando uma API
    private static void atualizarTaxaDeConversao() throws IOException, ParseException {
        URL url = new URL(URL_API);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        InputStream inputStream = con.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        JSONParser parser = new JSONParser();
        JSONObject jsonResponse = (JSONObject) parser.parse(inputStreamReader);
        JSONObject rates = (JSONObject) jsonResponse.get("rates");
        taxaDeConversao = (double) rates.get("BRL");
    }

    // Método para converter o valor em Euro para outra moeda usando a taxa de conversão atualizada
    public double converter() {
        try {
            atualizarTaxaDeConversao();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            // Lidar com erros de conexão ou parse do JSON se precisar
        }
        return this.valor * taxaDeConversao;
    }
}
