package com.example.bookstore.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TrasactionModel {
    private Long bookid;
    private List<Long> sales;
    private Double totalRevenue;
    private List<String> customer;

}
