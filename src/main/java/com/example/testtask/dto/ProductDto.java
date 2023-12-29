package com.example.testtask.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductDto {
    private List<ProductRecordDTO> records;

    @Data
    public static class ProductRecordDTO {
        private String entryDate;
        private String itemCode;
        private String itemName;
        private String itemQuantity;
        private String status;
    }
}