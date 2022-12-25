package com.example.bookstore.models;

import jakarta.persistence.*;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="sale")
public class SalesModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long SalesId;

    @ManyToOne 
    private BookModel book;

    private String customerEmail;

    private Double price;
    
}
