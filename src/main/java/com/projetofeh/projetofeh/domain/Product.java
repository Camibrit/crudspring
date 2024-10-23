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
        private Integer price;
        private Boolean active;

        public Product(RequestProduct requestProduct){
            this.name = requestProduct.name();
            this.price = requestProduct.price();
            this.active = true;
        }

    }

