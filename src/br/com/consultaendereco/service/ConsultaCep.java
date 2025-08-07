package br.com.consultaendereco.service;

import br.com.consultaendereco.model.DadosEndereco;
import br.com.consultaendereco.model.Endereco;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class ConsultaCep {

    public Optional<Endereco> buscarEndereco(String cep) {
        URI enderecoApi = URI.create("https://viacep.com.br/ws/" + cep + "/json/");
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(enderecoApi)
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String jsonEndereco = response.body();
            Gson gson = new Gson();
            DadosEndereco dadosEndereco = gson.fromJson(jsonEndereco, DadosEndereco.class);

            Endereco endereco = new Endereco(dadosEndereco);

            return Optional.of(endereco);
        } catch (Exception e) {
            System.out.println();
            return Optional.empty();
        }
    }
}
