package com.example.bookstore.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ViewSaleModel {
    private Long bookId;
    private String customerEmail;
    private Double price;
}
