package ru.aamsystems.testtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aamsystems.testtask.entity.Product;

import java.math.BigInteger;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, BigInteger> {
    List<Product> findByNameContains(final String name);
}
