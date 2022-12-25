package com.example.bookstore.controllers;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.models.SalesModel;
import com.example.bookstore.models.ViewSaleModel;
import com.example.bookstore.models.requestModel;
import com.example.bookstore.services.SalesService;



@RestController
@RequestMapping("/sales")

public class SalesController {
    @Autowired
    SalesService saleService;


    @PostMapping()
    public Object postMethodName(@RequestBody requestModel request) {

        Long bookId = request.getBookId();
        String customerEmail=request.getCustomerEmail();

      
        Object Data=this.saleService.saveSale(bookId,customerEmail);
       
        if(!Objects.isNull(Data)){
            ViewSaleModel sale=new ViewSaleModel(((SalesModel) Data).getBook().getBookId(),((SalesModel) Data).getCustomerEmail(),((SalesModel) Data).getPrice()); 
            saleService.updateBook(bookId);
            return sale;
        }else{
            String mensaje="No se encontró libro con ese Id";
            return mensaje;
        }
      
    }

}
