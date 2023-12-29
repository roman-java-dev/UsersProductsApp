package com.example.testtask.mapper;

import com.example.testtask.dto.ProductDto;
import com.example.testtask.dto.ProductResponseDto;
import com.example.testtask.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "entryDate", dateFormat = "dd-MM-yyyy")
    ProductResponseDto toResponseDto(Product product);

    @Mapping(target = "entryDate", dateFormat = "MM-dd-yyyy")
    Product toEntity(ProductDto.ProductRecordDTO recordDTO);

    List<ProductResponseDto> toResponseDtoList(List<Product> products);

    List<Product> toEntityList(List<ProductDto.ProductRecordDTO> recordDTOs);
}