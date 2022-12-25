package com.example.bookstore.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.models.BookModel;
import com.example.bookstore.models.LikeModel;
import com.example.bookstore.models.ViewLikeModel;
import com.example.bookstore.repositories.BookRepository;
import com.example.bookstore.repositories.LikedRepository;



@Service
public class LikeService {
    
    @Autowired
    LikedRepository likeRepository;
    @Autowired
    BookRepository bookRepository;

    public Object guardarDatos(ViewLikeModel miEntidad) {

        BookModel consultaBook=bookRepository.findByBookId(miEntidad.getBookId());

        if(!Objects.isNull(consultaBook)){

            if(consultaBook.getAvailable()==false){
                return "No está disponible el libro";
            }else{
                LikeModel consulta=likeRepository.findByBookId(miEntidad.getBookId());
        
                if(Objects.isNull(consulta)){
                 LikeModel datos=new LikeModel();
                 datos.setBookId(miEntidad.getBookId());
                 datos.setLikes(1);
                 List<String> lista = new ArrayList<String>();
                 lista.add(miEntidad.getCustomerEmail());
                 datos.setCustomer(lista);
                 return likeRepository.save(datos); 
                }else{
               
                 consulta.setBookId(miEntidad.getBookId());
                 Integer suma=consulta.getLikes()+1;
                 consulta.setLikes(suma);
                 List<String> newArray=consulta.getCustomer();
                 newArray.add(miEntidad.getCustomerEmail());
                 consulta.setCustomer(newArray);
                 return likeRepository.save(consulta);    
                }
            }
        
        }else{
           return null;
     
        }

      
     
    } 

}
