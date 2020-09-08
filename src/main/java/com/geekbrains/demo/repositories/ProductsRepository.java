package com.geekbrains.demo.repositories;

import com.geekbrains.demo.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends PagingAndSortingRepository<Product, Long> {
    Page<Product> findAllByCostBetween(Pageable pageable, double minCost, double maxCost);
    Product findOneByTitle(String title);
}
