package com.algaworks.algafood.client.api;

import com.algaworks.algafood.client.model.RestauranteModel;
import com.algaworks.algafood.client.model.RestauranteResumoModel;
import com.algaworks.algafood.client.model.input.RestauranteInput;
import lombok.AllArgsConstructor;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class RestauranteClient {
    private static final String RESOURCE_PATH = "/restaurantes";
    private RestTemplate restTemplate;

    private String url;

    public List<RestauranteResumoModel> listar() {

        var resourceUri = URI.create(url + RESOURCE_PATH);

        try {
            RestauranteResumoModel[] restaurantes = restTemplate
                    .getForObject(resourceUri, RestauranteResumoModel[].class);

            return Arrays.asList(restaurantes);
        } catch (HttpClientErrorException e) {
            throw new ClientApiException(e.getMessage(), e);
        }
    }

    public RestauranteModel adicionar(RestauranteInput restaurante) {

        var resourceUri = URI.create(url + RESOURCE_PATH);

        try {
            return restTemplate
                    .postForObject(resourceUri, restaurante, RestauranteModel.class);
        } catch (HttpClientErrorException e){
            throw new ClientApiException(e.getMessage(), e);
        }
    }
}
