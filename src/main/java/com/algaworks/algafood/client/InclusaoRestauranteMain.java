package com.algaworks.algafood.client;

import com.algaworks.algafood.client.api.ClientApiException;
import com.algaworks.algafood.client.api.RestauranteClient;
import com.algaworks.algafood.client.model.RestauranteModel;
import com.algaworks.algafood.client.model.input.EnderecoInput;
import com.algaworks.algafood.client.model.input.IdInput;
import com.algaworks.algafood.client.model.input.RestauranteInput;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class InclusaoRestauranteMain {
    public static void main(String[] args) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            RestauranteClient restauranteClient = new RestauranteClient(restTemplate, "http://api.algafood.local:8080");

            EnderecoInput endereco = EnderecoInput.builder()
                    .cep("38500-111")
                    .logradouro("Rua Xyz")
                    .numero("300")
                    .complemento("casa")
                    .bairro("Centro")
                    .cidade(new IdInput<>(1l))
                    .build();

            RestauranteInput restaurante = RestauranteInput.builder()
                    .nome("Comida Mineira")
                    .taxaFrete(new BigDecimal("9.50"))
                    .cozinha(new IdInput<>(1l))
                    .endereco(endereco)
                    .build();

            RestauranteModel restauranteModel = restauranteClient.adicionar(restaurante);
            System.out.println(restauranteModel);
        } catch (ClientApiException e) {
            if (e.getProblem() != null) {
                System.out.println(e.getProblem().getUserMessage());

                e.getProblem().getObjects().forEach(object ->
                        System.out.println("-" + object.getUserMessage())
                );
            } else {
                System.out.println("Erro desconhecido");
                e.printStackTrace();
            }
        }
    }
}
