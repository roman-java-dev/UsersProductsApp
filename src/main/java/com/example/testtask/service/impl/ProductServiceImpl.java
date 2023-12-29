package com.example.testtask.service.impl;

import com.example.testtask.model.Product;
import com.example.testtask.repository.ProductRepository;
import com.example.testtask.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> saveAll(List<Product> products) {
        return productRepository.saveAll(products);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
