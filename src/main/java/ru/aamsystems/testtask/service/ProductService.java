package ru.aamsystems.testtask.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aamsystems.testtask.entity.Product;
import ru.aamsystems.testtask.repository.ProductRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(final BigInteger id) {
        return productRepository.findById(Optional.ofNullable(id).orElse(new BigInteger("-1")));
    }

    public List<Product> findByName(final String name) {
        return productRepository.findByNameContains(name);
    }

    public void save(final Product product) {
        productRepository.save(product);
    }

    public void delete(final BigInteger id) {
        findById(id).ifPresent(productRepository::delete);
    }

    public void upsert(final Product product) {
        findById(product.getId()).ifPresentOrElse(p -> {
            p.setDescription(product.getDescription());
            p.setName(product.getName());
            save(p);
        }, () -> save(product));
    }

}
