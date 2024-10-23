package com.projetofeh.projetofeh.repository;


import com.projetofeh.projetofeh.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//JpaRepository faz parte do SpringData, dessa forma ganha acesso a métodos prontos. Realiza operações no banco.
public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findAllByActiveTrue();

}
