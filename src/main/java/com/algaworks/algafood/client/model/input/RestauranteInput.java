package com.algaworks.algafood.client.model.input;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class RestauranteInput {
    private String nome;
    private BigDecimal taxaFrete;
    private IdInput<Long> cozinha;
    private EnderecoInput endereco;
}
