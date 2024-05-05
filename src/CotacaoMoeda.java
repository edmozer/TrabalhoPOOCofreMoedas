import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CotacaoMoeda {

    private static final String[] CODIGOS_MOEDAS = {"USD", "EUR", "GBP", "JPY", "CHF", "CNY", "ARS", "RUB"};

    public void mostrarCotacaoAtual() {
        System.out.println("=============================================");
        System.out.println("Cotação atual de todas as moedas cadastradas:");
        System.out.println("=============================================");
        for (String codigo : CODIGOS_MOEDAS) {
            try {
                double cotacao = buscarCotacaoMoeda(codigo);
                System.out.println(obterNomeMoeda(codigo) + " (" + codigo + "): R$ " + cotacao);
            } catch (IOException | ParseException e) {
                System.out.println("Erro ao buscar cotação da moeda " + codigo);
            }
        }
        System.out.println("=================================");
        System.out.println("");
        System.out.println("Retornando ao menu principal...");
        System.out.println("");
    }

    private double buscarCotacaoMoeda(String codigoMoeda) throws IOException, ParseException {
        String urlApi = "https://api.exchangerate-api.com/v4/latest/" + codigoMoeda;
        HttpURLConnection con = null;
        try {
            URL url = new URL(urlApi);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            InputStream inputStream = con.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            JSONParser parser = new JSONParser();
            JSONObject jsonResponse = (JSONObject) parser.parse(inputStreamReader);
            JSONObject rates = (JSONObject) jsonResponse.get("rates");
            return (double) rates.get("BRL");
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
    }

    private String obterNomeMoeda(String codigoMoeda) {
        switch (codigoMoeda) {
            case "USD":
                return "Dólar";
            case "EUR":
                return "Euro";
            case "GBP":
                return "Libra Esterlina";
            case "JPY":
                return "Iene";
            case "CHF":
                return "Franco Suíço";
            case "CNY":
                return "Yuan";
            case "ARS":
                return "Peso Argentino";
            case "RUB":
                return "Rublo";
            default:
                return "Moeda Desconhecida";
        }
    }
}
