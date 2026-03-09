import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class ConsultaMoeda {

    public double buscaTaxa(String origem, String destino) {

        String endereco = "https://v6.exchangerate-api.com/v6/a545c819c84cfa364efbfe04/latest/" + origem;

        try {

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();

            var json = gson.fromJson(response.body(), com.google.gson.JsonObject.class);
            var rates = json.getAsJsonObject("conversion_rates");

            return rates.get(destino).getAsDouble();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao consultar a API");
        }
    }
}