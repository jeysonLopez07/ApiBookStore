package com.example.bookstore.models;
import jakarta.persistence.*;
import lombok.Getter;

import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="book")

public class BookModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long bookId;
    @Column(nullable = false)
    private String title;
    private String description;
    @Column(nullable = false)
    private Integer stock;
    @Column(nullable = false)
    private Double salePrice;
    private Boolean available;
}
