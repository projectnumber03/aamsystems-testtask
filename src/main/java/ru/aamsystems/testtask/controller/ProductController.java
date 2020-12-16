package ru.aamsystems.testtask.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.aamsystems.testtask.entity.Product;
import ru.aamsystems.testtask.service.ProductService;

import java.math.BigInteger;
import java.util.Map;

@Controller
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/")
    public String index(final Map<String, Object> model) {
        model.put("products", productService.findAll());
        return "index";
    }

    @PostMapping(value = "/", params = "addButton")
    public String onAddButtonClick(final Map<String, Object> model) {
        model.put("product", new Product());
        return "product_upsert";
    }

    @PostMapping(value = "/", params = "editButton")
    public String onEditButtonClick(@RequestParam(name = "editButton") final BigInteger id,
                                    final Map<String, Object> model) {
        model.put("product", productService.findById(id).orElse(new Product()));
        return "product_upsert";
    }

    @PostMapping(value = "/", params = "deleteButton")
    public String onDeleteButtonClick(@RequestParam(name = "deleteButton") final BigInteger id) {
        productService.delete(id);
        return "redirect:/";
    }

    @PostMapping(value = "/", params = "searchButton")
    public String onSearchButtonClick(@RequestParam(name = "search") final String name,
                                      final Map<String, Object> model) {
        model.put("products", productService.findByName(name));
        return "index";
    }

    @PostMapping("/")
    public String upsertProduct(final Product product) {
        productService.upsert(product);
        return "redirect:/";
    }

}
