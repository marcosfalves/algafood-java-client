package com.algaworks.algafood.client.model.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class IdInput<T> {
    private T id;
}