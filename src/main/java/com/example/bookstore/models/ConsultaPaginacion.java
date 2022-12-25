package com.example.bookstore.models;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
public class ConsultaPaginacion {
    
    private List<BookModel> content;
    private int size;
    private int numberofElement;
    private int totalElements;
    private int totalPages;
    private int number;
}



