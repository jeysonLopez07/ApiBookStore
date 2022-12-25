package com.example.bookstore.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.controllers.BookController;
import com.example.bookstore.models.BookModel;
import com.example.bookstore.models.SalesModel;
import com.example.bookstore.repositories.BookRepository;
import com.example.bookstore.repositories.SalesRepository;

@Service
public class SalesService {
    @Autowired
    SalesRepository saleRepository;

    @Autowired
    BookRepository bookRepository;

public Object saveSale( Long bookId,String customerEmail){
   
    
    BookModel book=bookRepository.findByBookId(bookId);
    SalesModel saveData=new SalesModel();
    if(!Objects.isNull(book)){
        saveData.setBook(book);
        saveData.setCustomerEmail(customerEmail);
        saveData.setPrice(book.getSalePrice());
        return saleRepository.save(saveData);
    }else{
     
        return null;
    }
}

public Boolean updateBook( Long bookId){
   
    BookModel book=bookRepository.findByBookId(bookId);
     int resta=book.getStock()-1;
     if(resta==0){
        book.setAvailable(false);
     }

    book.setStock(resta);
    bookRepository.save(book);
    return true;
}


}