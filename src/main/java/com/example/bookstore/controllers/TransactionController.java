package com.example.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.services.TransactionServices;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    
    @Autowired
    TransactionServices transactionService;

    @GetMapping("books/{bookId}")
    public Object getBooksPaginated(@PathVariable Long bookId){
        return transactionService.getTransactions(bookId);

    }

}
