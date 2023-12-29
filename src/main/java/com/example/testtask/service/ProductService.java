package com.example.testtask.service;

import com.example.testtask.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> saveAll(List<Product> products);

    List<Product> getAll();
}
