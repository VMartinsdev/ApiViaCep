package br.com.VMartins.consultaApiViaCep.service;

import br.com.VMartins.consultaApiViaCep.dto.CepDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class CepService {

    public CepDto consultaCep(String cep) throws IOException, InterruptedException {

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://viacep.com.br/ws/"+cep+"/json/")).build();
        HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        CepDto cepDto = gson.fromJson(json, CepDto.class);
        return cepDto;
    }

}
