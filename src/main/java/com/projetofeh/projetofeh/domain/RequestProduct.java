package com.projetofeh.projetofeh.domain;
//Esse é um record DTO, serve apenas para transferir dados ou receber dados.


import org.antlr.v4.runtime.misc.NotNull;

public record RequestProduct(
        String id,
        String name,
        @NotNull
        Integer price_in_cents
) {
}
