package com.example.bookstore.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.models.BookModel;
import com.example.bookstore.models.SalesModel;
import com.example.bookstore.models.TrasactionModel;
import com.example.bookstore.repositories.BookRepository;
import com.example.bookstore.repositories.LikedRepository;
import com.example.bookstore.repositories.SalesRepository;

@Service
public class TransactionServices {
    @Autowired
    LikedRepository likeRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    SalesRepository saleRepository;
   
    public Object getTransactions(Long bookId){
        BookModel consultaBook=bookRepository.findByBookId(bookId);

        if(Objects.isNull(consultaBook)){
         
            return "No se encontró libro con ese Id";   
        }else{
            TrasactionModel data=new TrasactionModel();
            List<SalesModel> consultaSale=(List<SalesModel>) saleRepository.findAll();

            List<Long> lista = new ArrayList<Long>();
            List<String> lista2 = new ArrayList<String>();
            Double suma=0.00;
            for (SalesModel sale : consultaSale) {
                if(sale.getBook().getBookId()==bookId){
                    lista.add(sale.getSalesId());
                    lista2.add(sale.getCustomerEmail());
                    suma=suma+sale.getPrice();
                }

                
            }

            if(lista.size()==0){
                return "No se encontraron ventas de ese bookId";
            }else{
                data.setBookid(bookId);
                data.setSales(lista);
                data.setTotalRevenue(suma);
                data.setCustomer(lista2);
                
                return data;

            }

        }
    }
}
