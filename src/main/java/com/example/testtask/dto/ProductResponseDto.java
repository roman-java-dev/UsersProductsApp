package com.example.testtask.dto;

import java.time.LocalDate;

public record ProductResponseDto(
        LocalDate entryDate,
        Long itemCode,
        String itemName,
        Long itemQuantity,
        String status
) {
}
