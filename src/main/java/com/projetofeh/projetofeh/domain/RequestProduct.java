package com.projetofeh.projetofeh.domain;
//Esse é um record DTO, serve apenas para transferir dados ou receber dados.
import jakarta.validation.constraints.NotNull;

public record RequestProduct(

        String id,
        String name,
        @NotNull
        Integer price
) {
}
