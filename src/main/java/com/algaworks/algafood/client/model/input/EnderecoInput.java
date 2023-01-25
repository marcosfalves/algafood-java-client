package com.algaworks.algafood.client.model.input;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EnderecoInput {
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private IdInput<Long> cidade;
}
