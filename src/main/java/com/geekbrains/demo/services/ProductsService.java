package com.geekbrains.demo.services;

import com.geekbrains.demo.entities.Product;
import com.geekbrains.demo.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    private ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public Product findByTitle(String title) {
        return productsRepository.findOneByTitle(title);
    }

    public Product findById(Long id) {
        return productsRepository.findById(id).orElse(null);
    }

    public List<Product> getAllProducts() {
        return (List<Product>)productsRepository.findAll();
    }

    public Page<Product> getProductsByCost(Pageable pageable, Double min, Double max) {
        if (min == null) {
            min = 0.0;
        }
        if (max == null) {
            max = Double.MAX_VALUE;
        }
        return productsRepository.findAllByCostBetween(pageable, min, max);
    }

    public Product saveOrUpdate(Product product) {
        return productsRepository.save(product);
    }
}
