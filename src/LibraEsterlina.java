import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LibraEsterlina extends Moeda {
    private static final String URL_API = "https://api.exchangerate-api.com/v4/latest/GBP";
    private static double taxaDeConversao;

    public LibraEsterlina(double valorInserido) {
        this.valor = valorInserido;
    }

    public void info() {
        System.out.println("Libra Esterlina - " + valor);
    }

    private static void atualizarTaxaDeConversao() throws IOException, ParseException {
        HttpURLConnection con = null;
        try {
            URL url = new URL(URL_API);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            InputStream inputStream = con.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            JSONParser parser = new JSONParser();
            JSONObject jsonResponse = (JSONObject) parser.parse(inputStreamReader);
            JSONObject rates = (JSONObject) jsonResponse.get("rates");
            taxaDeConversao = (double) rates.get("BRL");
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
    }

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
