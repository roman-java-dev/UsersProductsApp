package com.example.testtask.controller;

import com.example.testtask.dto.ProductDto;
import com.example.testtask.dto.ProductResponseDto;
import com.example.testtask.mapper.ProductMapper;
import com.example.testtask.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/all")
    public List<ProductResponseDto> getAll() {
        return ProductMapper.INSTANCE.toResponseDtoList(productService.getAll());
    }
    @PostMapping("/add")
    public List<ProductResponseDto> add(@RequestBody ProductDto productDto) {
        return ProductMapper.INSTANCE.toResponseDtoList(productService.saveAll(
                ProductMapper.INSTANCE.toEntityList(productDto.getRecords())));
    }
}
