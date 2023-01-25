package com.algaworks.algafood.client.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Problem {
    private Integer status;
    private OffsetDateTime timestamp;
    private String userMessage;
    private List<Object> objects = new ArrayList<>();

    @Getter
    @Setter
    public static class Object {
        private String name;
        private String userMessage;
    }
}
