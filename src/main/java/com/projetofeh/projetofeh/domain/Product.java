package com.projetofeh.projetofeh.domain;

import jakarta.persistence.*;
import lombok.*;


@Table(name="product")
    @Entity(name="product")
    @EqualsAndHashCode(of = "id")
    @Getter
    @Setter
@AllArgsConstructor
@NoArgsConstructor

    public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private String id;
        private String name;
        private Number price_in_cents;

        public Product(RequestProduct requestProduct){
            this.name = requestProduct.name();
            this.price_in_cents = requestProduct.price_in_cents();
        }

    }

